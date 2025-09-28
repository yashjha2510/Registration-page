<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="regForm" method="post">
		Name : <input type="text" name="user_name"> <br> <br>
		Email : <input type="email" name="user_email"> <br> <br>
		Password : <input type="password" name="user_pass"> <br> <br>
		Gender : <input type="radio" name="user_gender" value="male">Male
				<input type="radio" name="user_gender" value="female">Female
				<input type="radio" name="user_gender" value="others">others
		 <br> <br>
		City : <select name="user_city">
				<option>Select City</option>
				<option>gwalior</option>
				<option>mumbai</option>
				<option>bhopal</option>
				<option>Inodre</option>
				<option>ujjain</option>
				</select>
		<input type="submit" value="Register">
	</form>
</body>
</html>