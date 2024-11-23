<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #222;
            color: white;
        }
        .container {
            max-width: 400px;
            margin-top: 100px;
            padding: 20px;
            background-color: rgba(0, 100, 0, 0.7);
            border-radius: 10px;
            box-shadow: 0 0 10px #00FFFF;
        }
        input[type=submit] {
            background-color: #04AA6D;
            color: white;
            width: 100%;
            margin-top: 10px;
        }
        input[type=submit]:hover {
            background-color: #00FFFF;
            color: #FF0000;
        }
    </style>
</head>
<body>

    <div class="container">
        <form action="loginServlet" method="post">
            <h2 class="text-center">Login Page</h2>
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="text" class="form-control" name="email" placeholder="Email" required>
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" class="form-control" name="password" placeholder="Password" required>
            </div>
            <input type="submit" value="Login">
            <div class="forgot">
                <a href="#">Forgot Password?</a>
            </div>
        </form>
    </div>

</body>
</html>
