<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart</title>
<!-- Bootstrap CSS -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#">Last Try</a>
		<!-- Add your navbar items here -->
	</nav>

	<div class="container mt-5">
		<h1>Your Cart</h1>
		<table class="table">
			<thead>
				<tr>
					<th>Item</th>
					<th>Quantity</th>
					<th>Price</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<!-- Add items dynamically here from session or database -->
				<tr>
					<td>Sample Item</td>
					<td>1</td>
					<td>$10.00</td>
					<td><button class="btn btn-danger">Remove</button></td>
				</tr>
			</tbody>
		</table>
		<button class="btn btn-success">Proceed to Checkout</button>
	</div>

	<!-- Bootstrap JS (Optional) -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
