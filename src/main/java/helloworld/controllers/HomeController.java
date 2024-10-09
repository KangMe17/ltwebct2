package helloworld.controllers;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import helloworld.models.UserModel;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/home"})
public class HomeController extends HttpServlet {

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Get the current session, but don't create a new one if it doesn't exist
        HttpSession session = req.getSession(false);
        
        UserModel user = null;
        if (session != null) {
            user = (UserModel) session.getAttribute("account");
        }

        if (user != null) {
            // If the user is logged in, display a personalized homepage
            req.setAttribute("user", user);
        }
        // Forward to the homepage view (accessible by both logged-in and non-logged-in users)
        req.getRequestDispatcher("/views/home.jsp").forward(req, resp);
    }
}
