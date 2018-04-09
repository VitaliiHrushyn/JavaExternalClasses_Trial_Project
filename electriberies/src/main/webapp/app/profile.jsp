<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>My profile</title>
	</head>
	<body>
		<c:set var="login" value="${requestScope.login}"/>
		<c:set var="message" value="${requestScope.message}"/>
		<h2>${login}'s profile</h2>
		<h3>${message}</h3>
		<menu>
			<h3>Menu</h3>
			<a href="${pageContext.request.contextPath}/app/logout">Logout</a>
			<br>
			<a href="${pageContext.request.contextPath}/app/showdevices">Show devices</a>
		</menu>
	</body>
</html>