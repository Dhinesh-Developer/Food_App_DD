<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.FoodApp.Model.restaurant" %>
<%@ page import="java.util.List" %>
<%@ page import="javax.servlet.http.HttpSession" %> <!-- Import HttpSession if not already imported -->
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home Page</title>
    <style>
        .restaurant-card {
            border: 1px solid #ccc;
            padding: 15px;
            margin: 10px;
            text-align: center;
        }
        .restaurant-image {
            width: 100px;
            height: 100px;
        }
    </style>
</head>
<body>

    <h1>Welcome 
        <% 
            // Avoid redeclaring the session if already declared elsewhere
            if (session != null) {
                com.FoodApp.Model.user u = (com.FoodApp.Model.user) session.getAttribute("user");
                if (u != null) {
                    // Ensure the method name is correct
                    out.println(u.getUsername());  // assuming the method is getUsername() (check your user class)
                } else {
                    out.println("Guest");
                }
            } else {
                out.println("Guest");
            }
        %>
        to Last Try
    </h1>

    <h2>Details about Restaurant Information</h2>
    
    <div>
        <% 
            // Retrieve the restaurant list from the session
            List<restaurant> restaurantList = (List<restaurant>) session.getAttribute("restaurantList");
            if (restaurantList != null) {
                for (restaurant restaurant : restaurantList) {
        %>
                    <div class="restaurant-card">
                        <!-- Fixed string literal and syntax issues -->
                        <h3><%= restaurant.getRestaurantName() %></h3>
                        <p>Rating: <%= restaurant.getRating() %></p>
                        <p>ETA: <%= restaurant.getEta() %> mins</p>
                    </div>
        <% 
                }
            } else { 
        %>
            <p>No restaurant details available.</p>
        <% 
            }
        %>
    </div>

</body>
</html>
