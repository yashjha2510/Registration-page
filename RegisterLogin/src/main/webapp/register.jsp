<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/RegisterLogin/regForm" method="post">
		Name : <input type="text" name="user_name"> <br> <br>
		Email : <input type="text" name="user_email"> <br> <br>
		Password : <input type="text" name="user_pass"> <br> <br>
		Gender : <input type="radio" name="user_gender">Male
				<input type="radio" name="user_gender">Female
				<input type="radio" name="user_gender">others
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