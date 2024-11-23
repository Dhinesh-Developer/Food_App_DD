<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Menu Page</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <!-- Animation CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css">
    <style>
        /* Light green theme styling */
        body {
            background-color: #f0fdf0;
            color: #333;
        }
        h1 {
            color: #006400;
            margin-bottom: 30px;
        }
        .menu-card {
            background-color: #e0ffe0;
            border: none;
            box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.2);
            transition: transform 0.3s ease, box-shadow 0.3s ease;
        }
        .menu-card:hover {
            transform: scale(1.05);
            box-shadow: 0px 8px 16px rgba(0, 0, 0, 0.3);
        }
        .card-title {
            color: #006400;
        }
        .card-text {
            color: #333;
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <h1 class="text-center">Menu for Restaurant ID <%= request.getParameter("restaurantId") %></h1>
        <div class="row">
            <%
                String restaurantId = request.getParameter("restaurantId");

                Connection con = null;
                Statement st = null;
                ResultSet res = null;
                
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "root", "root@dk");
                    st = con.createStatement();
                    res = st.executeQuery("SELECT * FROM menu WHERE restaurantid = " + restaurantId);

                    while (res.next()) {
                        String itemName = res.getString("itemname");
                        String price = res.getString("price");
                        String ratings = res.getString("ratings");
            %>
                        <div class="col-md-4 mb-4">
                            <div class="card menu-card animate__animated animate__fadeIn">
                                <div class="card-body">
                                    <h5 class="card-title"><strong><%= itemName %></strong></h5>
                                    <p class="card-text"><strong>Price:</strong> ₹<%= price %></p>
                                    <p class="card-text"><strong>Ratings:</strong> <%= ratings %> / 5</p>
                                </div>
                            </div>
                        </div>
            <%
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (res != null) res.close();
                    if (st != null) st.close();
                    if (con != null) con.close();
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
