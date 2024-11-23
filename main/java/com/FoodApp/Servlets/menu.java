package com.FoodApp.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.FoodApp.DAO.menuDAO;
import com.FoodApp.DAOImpl.menuDAOImpl;

@WebServlet("/menu")
public class menu extends HttpServlet {
    
    public menu(int restaurantId, String itemName, int price, String ratings, String isAvailable) {
		// TODO Auto-generated constructor stub
	}

	@Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Set content type to handle responses
        resp.setContentType("text/html;charset=UTF-8");
        
        try {
            // Parse parameters from request
            int restaurantId = Integer.parseInt(req.getParameter("restaurantId"));
            String itemName = req.getParameter("itemName");
            int price = Integer.parseInt(req.getParameter("price"));
            String ratings = req.getParameter("ratings");
            String isAvailable = req.getParameter("isAvailable");
            
            // Create menu object
            menu m = new menu(restaurantId, itemName, price, ratings, isAvailable); // Change to your correct Menu class
            
            // DAO operation
            menuDAO ad = new menuDAOImpl();
            int status = ad.insertMenu(m);
            
            // Check if insertion was successful
            if (status > 0) {
                resp.getWriter().write("Menu item added successfully!"); // Success message
            } else {
                resp.getWriter().write("Failed to add menu item."); // Failure message
            }
        } catch (NumberFormatException e) {
            resp.getWriter().write("Invalid input for price or restaurant ID."); // Error for number parsing
        } catch (Exception e) {
            resp.getWriter().write("An error occurred: " + e.getMessage()); // General error message
        }
    }
}
