<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login Page</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
</head>
<body>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
		crossorigin="anonymous"></script>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Dollars Bank</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
				aria-controls="navbarNavAltMarkup" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
				<div class="navbar-nav">
					<a class="nav-link" href="./">Home</a> 
					<a class="nav-link active" aria-current="page" href="Login.jsp">Login</a> 
					<a class="nav-link" href="Register.jsp">Register</a>
					<!-- <a class="nav-link disabled">Disabled</a> -->
				</div>
			</div>
		</div>
	</nav>

	<!-- copy jumbotron code from bootstrap website or just include h1 tag at top of page to give the page a title -->
	<div class="jumbotron jumbotron-fluid">
		<div class="container">
			<h1 class="display-4">Login Page</h1>
			<p class="lead">Welcome! Please login below. Make sure to fill in
				all fields.</p>
		</div>
	</div>

	<!-- copy login form from bootstrap or create your own form -->
	<!-- make sure to set both inputs with required attribute -->
	<form action="LoginServlet" method=post>
		<div class="form-group">
			<label for="username">Username</label> <input type=text
				id="username" name="username" class="form-control" required>
		</div>

		<div class="form-group">
			<label for="password">Password</label> <input type="password" id="password"
				name="password" class="form-control" required>
		</div>

		<input type="submit" value="Login" class="btn btn-dark">
	</form>
</body>
</html>