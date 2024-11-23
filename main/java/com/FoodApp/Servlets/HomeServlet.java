package com.FoodApp.Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.FoodApp.Model.restaurant;

@WebServlet("/homeMain")
public class HomeServlet extends HttpServlet {
    
    String SQL = "select * from restaurant";
    Connection con;
    Statement st;
    ResultSet res;
    
    @Override
    public void init() throws ServletException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "root", "root@dk");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<restaurant> restaurants = new ArrayList<>();
        
        try {
            st = con.createStatement();
            res = st.executeQuery(SQL);
            
            while (res.next()) {
                restaurant restaurant = new restaurant();
                restaurant.setRestaurantName(res.getString("restaurantName"));
                restaurant.setRating(res.getString("rating"));
            //    restaurant.setEta(res.getString("eta"));
                restaurant.setImagepath(res.getString("imagePath"));
                
                restaurants.add(restaurant);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        // Store the restaurant list in the session
        HttpSession session = req.getSession();
        session.setAttribute("restaurantList", restaurants);
        
        // Forward the request to the JSP page
        req.getRequestDispatcher("/homeMain.jsp").forward(req, resp);
    }
}
