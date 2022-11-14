<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import = "com.dollarsbank.dao.ItemsDAO" %> 
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.DriverManager"%>	
<%@ page import="java.sql.SQLException"%>	

<!DOCTYPE html>
<jsp:useBean id="ItemsDAO" class="com.dollarsbank.dao.ItemsDAO" scope="session"/>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome Page</title>
<!-- can use bootstrap styling -->
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
					<a class="nav-link" aria-current="page" href="./">Home</a> 
					<a class="nav-link" href="#"><%= request.getSession().getAttribute("currentUser")%></a> 
					<a class="nav-link" href="LogoutServlet">Logout</a>
					<!-- <a class="nav-link disabled">Disabled</a> -->
				</div>
			</div>
		</div>
	</nav>

	<h1>Welcome! You are successfully logged in.</h1>
	
	<div>
	<form method = "post">
		<table border = 5 cellpadding = 5>
		<tr>
			<td>Name</td>
			<td>Code</td>
			<td>Price</td>
		</tr>
			<%
				ResultSet rs;
				
				String query = "select * from items;";
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					String url = "jdbc:mysql://localhost:3306/dollarsbank_servlets";
					String username = "root";
					String password = "root";
					Connection conn = DriverManager.getConnection(url, username, password);
					
					PreparedStatement pstmt = conn.prepareStatement(query);
					
					System.out.println(pstmt);
					rs = pstmt.executeQuery();
					
					while(rs.next()) {
				%>
			<tr>
				
				<td><%= rs.getString("item_name") %></td>
				<td><%= rs.getString("item_code")%></td>
				<td><%= rs.getDouble("item_price")%></td>
			</tr>

				<%
					}
				%>
		</table>
			<%
					conn.close();
				}
				catch (SQLException  e) {
					e.printStackTrace();
				} 
			%>
		
	
	</form>
	
	
		
	</div>

</body>
</html>