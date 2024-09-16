package helloworld.controllers;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/views/register.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//Tiếng việt trong Servlet
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
//lấy thông tin từ views
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String married = request.getParameter("married") != null ? "Yes" : "No";
		String nation = request.getParameter("nation");
		String[] favorites = request.getParameterValues("favorite");
		String note = request.getParameter("note");
		
		// Convert favorite array to a comma-separated string
		String favorite = favorites != null ? String.join(", ", favorites) : "";
//tạo biến để đẩy thông tin qua views
		request.setAttribute("username", username);
		request.setAttribute("password", password);
		request.setAttribute("gender", gender);
		request.setAttribute("married", married);
		request.setAttribute("nation", nation);
		request.setAttribute("favorite", favorite);
		request.setAttribute("note", note);
//đẩy thông tin qua views
		request.getRequestDispatcher("/views/register.jsp").forward(request, response);
	}
}