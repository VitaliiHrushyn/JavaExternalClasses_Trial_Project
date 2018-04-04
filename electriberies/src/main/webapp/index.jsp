<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Guest page</title>
	</head>
	<body>
		<center>
			<h1>Hello, guest!</h1>
			<h3>Please, login or register</h3>
			<br>
			<form method ="post" action="${pageContext.request.contextPath}/app/login">
			  <fieldset>
			    <legend>Login form</legend>
			    login:<br>
			    <input type="text" name="login" value=""><br>
			    Password:<br>
			    <input type="password" name="password"><br><br>
			    <input type="submit" value="Submit">
			  </fieldset>
			</form>
			<br>
			<br>
			<form method ="post" action="${pageContext.request.contextPath}/app/registration">
			  <fieldset>
			    <legend>Register form</legend>
			    login:<br>
			    <input type="text" name="reglogin" value=""><br>
			    Password:<br>
			    <input type="password" name="regppassword"><br>
			    Confirm password:<br>
			    <input type="password" name="regcofirmpassword"><br><br>
			    <input type="submit" value="Submit">
			  </fieldset>
			</form>
		</center>
	</body>
</html> 