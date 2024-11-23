package com.FoodApp.Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.FoodApp.DAO.userDAO;
import com.FoodApp.DAOImpl.userDAOImpl;
import com.FoodApp.Model.user;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class loginPage extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		userDAO udao = new userDAOImpl();
		user user = udao.getUserByEmail(email);

		if (user != null) {
			// Debugging: print the password comparison
			System.out.println("User password: " + user.getPassword());
			System.out.println("Entered password: " + password);

			if (password.equals(user.getPassword())) {
				// Password matches, redirect to home.jsp
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				response.sendRedirect("incorrect.jsp");

			} else {
				// Password incorrect, redirect to incorrect.jsp

				response.sendRedirect("homeMain.jsp");
			}
		} else {
			// User not found, redirect to signup page
			response.sendRedirect("signup.html");
		}
	}
}
