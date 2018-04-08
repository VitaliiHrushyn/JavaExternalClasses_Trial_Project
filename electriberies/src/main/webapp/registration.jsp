<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Registration</title>
	</head>
	<body>
		<h1>Registration page</h1>
	
			<br>
			<div class="block1">
				<form method ="post" action="${pageContext.request.contextPath}/app/registration">
				  <fieldset>
				    <legend>Register form</legend>
				    login:<br>
				    <input type="text" name="reglogin" value=""><br>
				    Password:<br>
				    <input type="password" name="regpassword"><br>
				    Confirm password:<br>
				    <input type="password" name="regconfirmpassword"><br><br>
				    <input type="submit" value="Submit">
				  </fieldset>
				</form>
			</div>
				<br>
		<c:set var="message" value="${requestScope.message}"/>
		<h3>${message}.</h3>
		<br>
	</body>
</html>