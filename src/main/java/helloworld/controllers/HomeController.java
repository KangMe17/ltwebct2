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
@WebServlet(urlPatterns = {"/admin/home"})
public class HomeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UserModel user = (UserModel) session.getAttribute("account");

        if (user == null) {
            // If no user is logged in, redirect to the login page
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        // Check the user's role to determine if they should be on the admin page
        if ("/admin/home".equals(req.getServletPath())) {
            if (user.getRoleid() == 1) {
                // Render admin dashboard
                req.getRequestDispatcher("/views/home.jsp").forward(req, resp);
            } else {
                // Unauthorized access to admin page
                resp.sendRedirect(req.getContextPath() + "/home");
            }
        } else {
            // Render general home page for users
            req.getRequestDispatcher("/views/home.jsp").forward(req, resp);
        }
    }
}
