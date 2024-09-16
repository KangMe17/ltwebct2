package helloworld.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/helloform"})
public class HelloForm extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String ten = req.getParameter("ten");
		String holot = req.getParameter("holot");
		
		PrintWriter out = resp.getWriter();
		out.println("<b> First Name </b>:" + ten + "<br/><b> Last Name </b>:" + holot);
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ten = req.getParameter("ten");
		String holot = req.getParameter("holot");
		
		
		PrintWriter out = resp.getWriter();
		out.println("<b> First Name </b>:" + ten + "<br/><b> Last Name </b>:" + holot);
	}

}
