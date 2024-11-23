package com.FoodApp.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/restaurant")
public class restaurant extends HttpServlet {
    
    String SQL = "SELECT * FROM restaurant";
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
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();

        pw.println("<!DOCTYPE html>");
        pw.println("<html lang='en'>");
        pw.println("<head>");
        pw.println("<meta charset='UTF-8'>");
        pw.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        pw.println("<title>Last Try - Restaurants</title>");
        pw.println("<link href='https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css' rel='stylesheet'>");
        pw.println("<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css'/>");
        pw.println("<style>");
        pw.println("body { background-color: #f4f9f4; color: #333; }");
        pw.println(".navbar { background-color: #28a745; color: #fff; }");
        pw.println(".navbar-brand { color: #fff; font-weight: bold; }");
        pw.println(".restaurant-card { background: #fff; border-radius: 8px; box-shadow: 0 4px 8px rgba(0,0,0,0.1); }");
        pw.println(".restaurant-card img { height: 200px; object-fit: cover; border-radius: 8px 8px 0 0; }");
        pw.println(".btn-success { background-color: #28a745; border: none; }");
        pw.println(".no-image { color: #999; font-size: 14px; background-color: #e9ecef; }");
        pw.println("</style>");
        pw.println("</head>");
        pw.println("<body>");
        
        pw.println("<nav class='navbar navbar-expand-lg navbar-light'>");
        pw.println("  <a class='navbar-brand' href='#'>Last Try</a>");
        pw.println("  <div class='collapse navbar-collapse' id='navbarNav'>");
        pw.println("    <ul class='navbar-nav'>");
        pw.println("      <li class='nav-item'><a class='nav-link text-white' href='restaurant'>Home</a></li>");
        pw.println("      <li class='nav-item'><a class='nav-link text-white' href='cart.jsp'>Cart</a></li>");
        pw.println("      <li class='nav-item'><a class='nav-link text-white' href='login.jsp'>Login</a></li>");
        pw.println("      <li class='nav-item'><a class='nav-link text-white' href='signup.html'>Signup</a></li>");
        pw.println("      <li class='nav-item'><a class='nav-link text-white' href='orderHistory.jsp'>Order History</a></li>");
        pw.println("    </ul>");
        pw.println("  </div>");
        pw.println("</nav>");
        
        pw.println("<div class='container mt-5'>");
        pw.println("  <h1 class='mb-4'>Discover Our Restaurants</h1>");
        pw.println("  <div class='row'>");

        try {
            st = con.createStatement();
            res = st.executeQuery(SQL);

            while (res.next()) {
                pw.println("    <div class='col-md-4 mb-4'>");
                pw.println("      <div class='card restaurant-card animate__animated animate__fadeIn'>");
                
                byte[] imageBytes = res.getBytes("imagePath");
                if (imageBytes != null && imageBytes.length > 0) {
                    String base64Image = java.util.Base64.getEncoder().encodeToString(imageBytes);
                    pw.println("        <img src='data:image/jpg;base64," + base64Image + "' class='card-img-top' alt='Restaurant Image' />");
                } else {
                    pw.println("        <div class='card-img-top no-image d-flex align-items-center justify-content-center'>No image available</div>");
                }

                pw.println("        <div class='card-body'>");
                pw.println("          <h5 class='card-title'>" + res.getString("restaurantName") + "</h5>");
                pw.println("          <p class='card-text'><strong>Rating:</strong> " + res.getString("rating") + "</p>");
                pw.println("          <p class='card-text'><strong>ETA:</strong> " + res.getString("eta") + " mins</p>");
                pw.println("          <form action='menu.jsp' method='get'>");
                pw.println("            <input type='hidden' name='restaurantId' value='" + res.getInt("restaurantId") + "'/>");
                pw.println("            <button type='submit' class='btn btn-success btn-block'>View Menu</button>");
                pw.println("          </form>");
                pw.println("        </div>");
                pw.println("      </div>");
                pw.println("    </div>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            pw.println("  </div>"); // Close row
            pw.println("</div>"); // Close container
        }

        pw.println("<script src='https://code.jquery.com/jquery-3.5.1.min.js'></script>");
        pw.println("<script src='https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js'></script>");
        pw.println("</body>");
        pw.println("</html>");
    }

    @Override
    public void destroy() {
        try {
            if (res != null) res.close();
            if (st != null) st.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
