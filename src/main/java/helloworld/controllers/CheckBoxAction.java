package helloworld.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/CheckBoxAction"})
public class CheckBoxAction extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String title = "Doc du lieu tu Check Box trong Servlet";
		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
		out.println(docType + "<html>\n" + "<head><title>" + title + "</title></head>\n"
				+ "<body bgcolor = \"#f0f0f0\">\n" + "<h1 align = \"center\">" + title + "</h1>\n" + "<ul>\n"
				+ " <li><b>Toan : </b>: " + req.getParameter("toan") + "\n" + " <li><b>Vat Ly: </b>: "
				+ req.getParameter("ly") + "\n" + " <li><b>Hoa Hoc: </b>: " + req.getParameter("hoa") + "\n"
				+ "</ul>\n" + "</body>" + "</html>");

	}

}
