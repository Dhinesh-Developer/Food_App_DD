package com.FoodApp.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.FoodApp.DAO.userDAO;
import com.FoodApp.DAOImpl.userDAOImpl;
import com.FoodApp.Model.user;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    
    private userDAO userDao;

    @Override
    public void init() {
        userDao = new userDAOImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Fetch login data
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        // Validate user
        user foundUser = userDao.getUserByEmail(email);

        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();

        if (foundUser != null && foundUser.getPassword().equals(password)) {
            // Redirect to index.jsp with the user's name
            resp.sendRedirect("index.jsp?username=" + foundUser.getUsername());
        } else {
            // Redirect to signup page if user not found
            resp.sendRedirect("signup.html");
        }
        
        pw.close();
    }
}
