<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manage Users - Evergreen Bookstore Administration</title>
</head>
<body>

	<jsp:directive.include file="header.jsp"/>	
	<div align="center">
	<br><br>
	<h2>User's Management</h2>
	<a href="user_form.jsp"><b>Create New User</b></a>
	</div>
	
	<c:if test="${message !=null}">
	<div align="center">
	<h4><i>${message}</i></h4>
	</div>
	</c:if>
	<div align="center">
	&nbsp;&nbsp;
	<table border="3" cellpadding=5>
	<tr>
	<th>Index</th>
	<th>ID</th>
	<th>Email</th>
	<th>Full Name</th>
	<th>Actions</th>
	</tr>
	
	<!-- Fetching and inserting data into table -->
	<c:forEach var="user" items="${listusers}" varStatus="status">
	<tr>
	<td>${status.index + 1}</td>
	<td>${user.userId}</td>
	<td>${user.email}</td>
	<td>${user.fullName}</td>
	<td>
	<b>
	<a href="edit_user?id=${user.userId}">Edit</a>&nbsp;
	<a href="javascript:confirmDelete(${user.userId})">Delete</a>
	</b>
	</td>
	</tr>
	</c:forEach>
	
	</table>
	
	</div>
	

	
	<jsp:directive.include file="footer.jsp"/>
</body>
<script type="text/javascript">

	function confirmDelete(userId){
		if(confirm("Are You sure you want to delete the user with ID: "+ userId +" ?.")){
			window.location = "delete_user?id=" +userId;
		}
	}

</script>

</html>