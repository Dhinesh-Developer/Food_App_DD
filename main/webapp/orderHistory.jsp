<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order History</title>
<!-- Bootstrap CSS -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#">Last Try</a>
		<!-- Add your navbar items here -->
	</nav>

	<div class="container mt-5">
		<h1>Your Order History</h1>
		<table class="table">
			<thead>
				<tr>
					<th>Order ID</th>
					<th>Item</th>
					<th>Quantity</th>
					<th>Total Price</th>
					<th>Date</th>
				</tr>
			</thead>
			<tbody>
				<!-- Populate with past orders from database -->
				<tr>
					<td>1</td>
					<td>Sample Item</td>
					<td>2</td>
					<td>$20.00</td>
					<td>2024-10-13</td>
				</tr>
			</tbody>
		</table>
	</div>

	<!-- Bootstrap JS (Optional) -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
