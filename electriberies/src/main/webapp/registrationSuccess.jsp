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
		<c:set var="login" value="${requestScope.login}"/>
		<h3>${login}, you've been successfully registered.</h3>
		<br>
		<menu>
			<h3>Menu</h3>
			<br>
			<a href="${pageContext.request.contextPath}/app/index">Logout</a>
			<br>
			<a href="${pageContext.request.contextPath}/app/login">My profile</a>
		</menu>
	</body>
</html>