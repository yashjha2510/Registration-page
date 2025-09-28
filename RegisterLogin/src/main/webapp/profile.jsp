<%@ page language="java" import="com.yash.model.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% User user = (User) session.getAttribute("session_user"); %>

	<h3>welcome <%= user.getName() %></h3>
	
	<a href="logout">Logout</a>
</body>
</html>