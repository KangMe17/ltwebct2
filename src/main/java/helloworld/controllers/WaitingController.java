package helloworld.controllers;

import java.io.IOException;

import helloworld.models.UserModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/waiting"})
public class WaitingController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    HttpSession session = req.getSession();
	    if (session != null && session.getAttribute("account") != null) {
	        UserModel u = (UserModel) session.getAttribute("account");
	        req.setAttribute("username", u.getUsername());
	        
	        // Check roles and avoid redirect loops
	        String currentURI = req.getRequestURI();
	        if (u.getRoleid() == 1 && !currentURI.contains("/admin/home")) {
	            resp.sendRedirect(req.getContextPath() + "/admin/home");
	        } else if (u.getRoleid() == 2 && !currentURI.contains("/manager/home")) {
	            resp.sendRedirect(req.getContextPath() + "/manager/home");
	        } else if (u.getRoleid() == 3 && !currentURI.contains("/home")) {
	            resp.sendRedirect(req.getContextPath() + "/home");
	        } 
	    } else {
	        resp.sendRedirect(req.getContextPath() + "/login");
	    }

	}

}
