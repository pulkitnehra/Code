<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Evergreen Bookstore Administration</title>
</head>
<body>

	<jsp:directive.include file="header.jsp"/>	
	<div align="center">
	<br><br>
	<h2>Administration Dashboard</h2>
	<hr width="70%" >
	</div>
	
	<div align="center">
	<h2>Quick Actions:</h2><b>
	<a href="create_book">New Book</a> &nbsp;
	<a href="createa_user">New User</a> &nbsp;
	<a href="create_category">New Category</a> &nbsp;
	<a href="create_customer">New Customer</a> 
	</b>
	</div>
	
	
	<div align="center">
	<hr width="70%" >
	<h2>Recent Sales:</h2>	 
	</div>
	
	<div align="center">
	<hr width="70%" >
	<h2>Recent Reviews:</h2>	 
	</div>
	
	<div align="center">
	<hr width="70%" >
	<h2>Statistics:</h2>
	<hr width="70%" >	 
	</div>
	
	
	<jsp:directive.include file="footer.jsp"/>
</body>
</html>