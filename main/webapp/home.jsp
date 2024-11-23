<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="com.FoodApp.Model.user" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home Page</title>
</head>
<body>

    <h1>Welcome 
        <% 
            // Retrieve the user object from the session
            HttpSession Session = request.getSession(false); // false means it won't create a new session if one doesn't exist
            if (session != null) {
                user u = (user) session.getAttribute("user");
                if (u != null) {
                    // Print the username
                    out.println(u);
                } else {
                    // Handle the case where the user object is not found in the session
                    out.println("Guest");
                }
            } else {
                out.println("Guest");
            }
        %>
        to Last Try
    </h1>

</body>
</html>
