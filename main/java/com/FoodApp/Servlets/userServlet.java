package com.FoodApp.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/userServlet")
public class userServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Fetch form data
        String name = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");

        // You can process the form data here (e.g., save to database, validate)
        
        // Set response type to HTML
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        
        // HTML response
        pw.println("<html>");
        pw.println("<head>");
        pw.println("<title>Registration Successful</title>");
        pw.println("</head>");
        pw.println("<body>");
        pw.println("<h1>Thank you for registering, " + name + "!</h1>");
        pw.println("<p>Your registration details have been recorded.</p>");
        
        // Button to go to index.jsp
        pw.println("<form action='RestaurantHome.jsp'>");
        pw.println("<button type='submit'>Go to Menu and Restaurant Page</button>");
        pw.println("</form>");
        
        pw.println("</body>");
        pw.println("</html>");
        
        // Close the PrintWriter
        pw.close();
    }
}
