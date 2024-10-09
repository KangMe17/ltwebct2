package helloworld.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import helloworld.models.CategoryModel;
import helloworld.services.ICategoryService;
import helloworld.services.implement.CategoryServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@MultipartConfig()
@WebServlet(urlPatterns = { "/admin/categories", "/admin/category/add", "/admin/category/insert",
		"/admin/category/edit", "/admin/category/update", "/admin/category/delete", "/admin/category/search" })
public class CategoryController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public ICategoryService cateService = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String url = req.getRequestURI();
		if (url.contains("/admin/category/add")) {
			req.getRequestDispatcher("/views/admin/category-add.jsp").forward(req, resp);
		} else if (url.contains("/admin/categories")) {
			List<CategoryModel> list = cateService.findAll();
			req.setAttribute("listcate", list);

			req.getRequestDispatcher("/views/admin/category-list.jsp").forward(req, resp);
		} else if (url.contains("/admin/category/edit")) {
			int id = Integer.parseInt(req.getParameter("id"));
			CategoryModel category = cateService.findById(id);

			req.setAttribute("cate", category);

			req.getRequestDispatcher("/views/admin/category-edit.jsp").forward(req, resp);
		} else if(url.contains("/admin/category/delete")) {
			String id = req.getParameter("id");
			cateService.delete(Integer.parseInt(id));
			resp.sendRedirect(req.getContextPath() + "/admin/categories");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String url = req.getRequestURI();
		if (url.contains("/admin/category/insert")) {
			// lấy dữ liệu từ views
			String categoryname = req.getParameter("categoryname");
			int status = Integer.parseInt(req.getParameter("status"));
			String images = req.getParameter("images");
			// đưa vào Model
			CategoryModel category = new CategoryModel();
			category.setCategoryname(categoryname);
			category.setStatus(status);
			// Xử lý upload file
			String fname = "";
			String uploadPath = "D:\\upload";
			File uploadDir = new File(uploadPath);
			if (!uploadDir.exists()) {
				uploadDir.mkdir();
			}

			try {
				Part part = req.getPart("images1");
				if (part.getSize() > 0) {
					String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
					int index = filename.lastIndexOf(".");
					String ext = filename.substring(index + 1);
					fname = System.currentTimeMillis() + "." + ext;
					part.write(uploadPath + "/" + fname);
					category.setImages(fname);

				} else if (images != null) {
					category.setImages(images);
				} else {
					category.setImages("avarta.png");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			// truyền Model vào insert
			cateService.insert(category);
			// trả về views
			resp.sendRedirect(req.getContextPath() + "/admin/category/add");
		} else if (url.contains("/admin/category/update")) {
			// lấy dữ liệu từ views
			int categoryid = Integer.parseInt(req.getParameter("categoryid"));
			String categoryname = req.getParameter("categoryname");
			int status = Integer.parseInt(req.getParameter("status"));
			String images = req.getParameter("images");
			// đưa vào Model
			CategoryModel category = new CategoryModel();
			category.setCategoryid(categoryid);
			category.setCategoryname(categoryname);
			category.setStatus(status);
			// Xử lý upload file
			String fname = "";
			String uploadPath = "D:\\upload";
			File uploadDir = new File(uploadPath);
			if (!uploadDir.exists()) {
				uploadDir.mkdir();
			}

			try {
				Part part = req.getPart("images1");
				if (part.getSize() > 0) {
					String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
					int index = filename.lastIndexOf(".");
					String ext = filename.substring(index + 1);
					fname = System.currentTimeMillis() + "." + ext;
					part.write(uploadPath + "/" + fname);
					category.setImages(fname);

				} else if (images != null) {
					category.setImages(images);
				} else {
					category.setImages("avarta.png");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			// truyền Model vào insert
			cateService.update(category);
			// trả về views
			resp.sendRedirect(req.getContextPath() + "/admin/categories");
		}
	}
}
