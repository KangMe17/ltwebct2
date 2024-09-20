package helloworld.controllers;

import java.io.IOException;

import helloworld.services.IUserService;
import helloworld.services.implement.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/forgotpassword" })
public class ForgotpasswordController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("views/forgotpassword.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    String email = req.getParameter("email");
	    IUserService service = new UserServiceImpl();
	    String alertMsg;

	    if (service.checkExistEmail(email)) {
	        // Generate a new password (e.g., random string or fixed temporary password)
	        String newPassword = "newPassword"; // Ideally generate a secure random password
	        boolean isUpdated = service.updatePasswordByEmail(email, newPassword);

	        if (isUpdated) {
	            // Send an email to the user with the new password (not implemented here)
	            alertMsg = "Mật khẩu mới đã được gửi đến email của bạn.";
	        } else {
	            alertMsg = "Đã xảy ra lỗi khi cập nhật mật khẩu.";
	        }
	    } else {
	        alertMsg = "Email không tồn tại!";
	    }

	    req.setAttribute("alert", alertMsg);
	    req.getRequestDispatcher("views/forgotpassword.jsp").forward(req, resp);
	}

}
