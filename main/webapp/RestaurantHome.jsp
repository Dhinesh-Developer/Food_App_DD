<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home Page</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <!-- Animation CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css">
    <style>
        /* General theme styling */
        body {
            background-color: #f0fdf0; /* Light green background */
            color: #333;
        }
        .navbar {
            background-color: #e0ffe0; /* Light green navbar */
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        .navbar-brand, .nav-link {
            color: #006400 !important; /* Dark green text */
        }
        .navbar-brand:hover, .nav-link:hover {
            color: #228B22 !important; /* Lighter green on hover */
        }
        .btn-outline-success {
            color: #006400; /* Dark green */
            border-color: #006400;
        }
        .btn-outline-success:hover {
            background-color: #006400;
            color: white;
        }

        /* Card styling */
        .restaurant-card {
            background-color: #e0ffe0;
            box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.2);
            transition: transform 0.3s ease, box-shadow 0.3s ease;
        }
        .restaurant-card:hover {
            transform: scale(1.05);
            box-shadow: 0px 8px 16px rgba(0, 0, 0, 0.2);
        }
        .card-title {
            color: #006400;
        }
        .no-image {
            display: flex;
            align-items: center;
            justify-content: center;
            background-color: #ccc;
            height: 200px;
            color: #666;
        }
    </style>
</head>
<body>
    <nav class="navbar navbar-expand-lg">
        <a class="navbar-brand" href="#">Last Try</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="restaurant">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="cart.jsp">Cart</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="login.jsp">Login</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="signup.html">Signup</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="orderHistory.jsp">Order History</a>
                </li>
            </ul>
            <form class="form-inline ml-auto" action="search.jsp" method="get">
                <input class="form-control mr-2" type="search" placeholder="Search" aria-label="Search" name="query">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>
    </nav>

    <div class="container mt-5 text-center">
        <h1>Welcome to Last Try</h1>
        <p>Click the button below to view our restaurants.</p>
        <a href="restaurant" class="btn btn-primary mb-4">Click here to view restaurants</a>
    </div>

    <!-- Restaurant Cards Section -->
    <div class="container">
        <div class="row">
            <!-- Replace the code below with servlet-generated restaurant cards -->
            <%
                // Example card layout
                for (int i = 0; i < 6; i++) { // Loop for sample cards
            %>
            <div class="col-md-4 mb-4">
                <div class="card restaurant-card animate__animated animate__fadeIn">
                    <img src="https://via.placeholder.com/300x200" class="card-img-top" alt="Restaurant Image" style="height:200px; object-fit:cover;">
                    <div class="card-body">
                        <h5 class="card-title">Restaurant Name</h5>
                        <p class="card-text"><strong>Rating:</strong> 4.5</p>
                        <p class="card-text"><strong>ETA:</strong> 30 mins</p>
                        <form action="menu.jsp" method="get">
                            <input type="hidden" name="restaurantId" value="1"/>
                            <input type="submit" value="View Menu" class="btn btn-success btn-block"/>
                        </form>
                    </div>
                </div>
            </div>
            <%
                }
            %>
        </div>
    </div>

    <!-- Bootstrap and jQuery JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
