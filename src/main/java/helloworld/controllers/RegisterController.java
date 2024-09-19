package helloworld.controllers;

import java.io.IOException;

import helloworld.utils.Constant;
import helloworld.services.IUserService;
import helloworld.services.implement.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/register"})
public class RegisterController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute("username") != null) {
			resp.sendRedirect(req.getContextPath() + "/admin");
			return;
		}

		// Check cookie
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("username")) {
					session = req.getSession(true);
					session.setAttribute("username", cookie.getValue());
					resp.sendRedirect(req.getContextPath() + "/admin");
					return;
				}
			}
		}

		req.getRequestDispatcher(Constant.Path.REGISTER).forward(req, resp);
	}

	@SuppressWarnings("static-access")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    // Thiết lập mã hóa ký tự cho request và response để tránh lỗi ký tự
	    resp.setCharacterEncoding("UTF-8");
	    req.setCharacterEncoding("UTF-8");

	    // Lấy thông tin từ form đăng ký
	    String username = req.getParameter("username");
	    String password = req.getParameter("password");
	    String email = req.getParameter("email");
	    String fullname = req.getParameter("fullname");
	    String phone = req.getParameter("phone");
	    
	    // Khởi tạo service để xử lý logic người dùng
	    IUserService service = new UserServiceImpl();
	    
	    // Biến để lưu thông báo
	    String alertMsg = "";

	    // Kiểm tra xem email đã tồn tại chưa
	    if (service.checkExistEmail(email)) {
	        alertMsg = "Email đã tồn tại!";
	        req.setAttribute("alert", alertMsg);
	        // Trả về trang đăng ký với thông báo lỗi
	        req.getRequestDispatcher(Constant.Path.REGISTER).forward(req, resp);
	        return;
	    }

	    // Kiểm tra xem tên đăng nhập đã tồn tại chưa
	    if (service.checkExistUsername(username)) {
	        alertMsg = "Tài khoản đã tồn tại!";
	        req.setAttribute("alert", alertMsg);
	        // Trả về trang đăng ký với thông báo lỗi
	        req.getRequestDispatcher(Constant.Path.REGISTER).forward(req, resp);
	        return;
	    }

	    // Nếu các điều kiện hợp lệ, tiến hành đăng ký người dùng
	    boolean isSuccess = service.register(username, password, email, fullname, phone);

	    // Nếu đăng ký thành công, chuyển hướng sang trang đăng nhập
	    if (isSuccess) {
	        // Gửi email chào mừng nếu cần thiết
	        // SendMail sm = new SendMail();
	        // sm.sendMail(email, "Shopping.iotstar.vn", "Welcome to Shopping. Please Login to use the service. Thanks!");

	        // Chuyển hướng người dùng đến trang đăng nhập
	        resp.sendRedirect(req.getContextPath() + "/login");
	    } else {
	        // Nếu có lỗi hệ thống, hiển thị thông báo lỗi
	        alertMsg = "Lỗi hệ thống, vui lòng thử lại!";
	        req.setAttribute("alert", alertMsg);
	        // Trả về trang đăng ký với thông báo lỗi
	        req.getRequestDispatcher(Constant.Path.REGISTER).forward(req, resp);
	    }
	}

}