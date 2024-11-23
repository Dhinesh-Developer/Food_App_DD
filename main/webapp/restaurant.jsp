<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Restaurants - Last Try</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<style>
    body {
        background-color: #000;
        color: #fff;
    }
    .navbar-brand, .nav-link, .btn-outline-success {
        color: #8a2be2 !important;
    }
    .restaurant-card {
        background-color: #1e1e1e;
        border: none;
        margin-bottom: 20px;
    }
    .restaurant-image {
        height: 200px;
        width: 100%;
        object-fit: cover;
    }
</style>
</head>
<body>
    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand" href="#">Last Try</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item"><a class="nav-link" href="restaurant.jsp">Home</a></li>
                <li class="nav-item"><a class="nav-link" href="cart.jsp">Cart</a></li>
                <li class="nav-item"><a class="nav-link" href="login.jsp">Login</a></li>
                <li class="nav-item"><a class="nav-link" href="signup.html">Signup</a></li>
                <li class="nav-item"><a class="nav-link" href="orderHistory.jsp">Order History</a></li>
            </ul>
            <form class="form-inline ml-auto" action="search.jsp" method="get">
                <input class="form-control mr-2" type="search" placeholder="Search" aria-label="Search" name="query">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>
    </nav>

    <!-- Restaurant Cards -->
    <div class="container mt-5">
        <h1 class="text-center mb-4">Restaurants</h1>
        <div class="row">
            <% 
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "root", "root@dk");
                Statement st = con.createStatement();
                ResultSet res = st.executeQuery("SELECT * FROM restaurant");
                while (res.next()) {
                    String restaurantName = res.getString("restaurantName");
                    String rating = res.getString("rating");
                    String eta = res.getString("eta");
                    byte[] imageBytes = res.getBytes("imagePath");
                    String base64Image = imageBytes != null ? new String(java.util.Base64.getEncoder().encode(imageBytes)) : null;
            %>
            <div class="col-md-4">
                <div class="card restaurant-card">
                    <% if (base64Image != null) { %>
                        <img src="data:image/jpg;base64,<%= base64Image %>" class="card-img-top restaurant-image" alt="<%= restaurantName %>">
                    <% } else { %>
                        <img src="default-image.jpg" class="card-img-top restaurant-image" alt="Default Image">
                    <% } %>
                    <div class="card-body">
                        <h5 class="card-title"><%= restaurantName %></h5>
                        <p class="card-text"><strong>Rating:</strong> <%= rating %></p>
                        <p class="card-text"><strong>ETA:</strong> <%= eta %> mins</p>
                        <form action="menu.jsp" method="get">
                            <input type="hidden" name="restaurantId" value="<%= res.getInt("restaurantId") %>"/>
                            <button type="submit" class="btn btn-success btn-block">View Menu</button>
                        </form>
                    </div>
                </div>
            </div>
            <% } 
                res.close();
                st.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            %>
        </div>
    </div>

    <!-- Optional JavaScript -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
