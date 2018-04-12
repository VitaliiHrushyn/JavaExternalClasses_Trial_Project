<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Guest page</title>
	 <style type="text/css">
   .block1 { 
    width: 500px; 
    background: #ccc;
    padding: 15px;
    border: solid 1px black; 
    align: center;
   }
  </style> 
	</head>
	<body>
		<center>
			<h1>Hello, guest!</h1>
			<h3>Please, login</h3>
			<br>
			<div class="block1">
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
			</div>
			<br>
			<p><c:out value="${requestScope.message}"/></p>
			<br>
			<p> <h3>or</h3>			
				<form method="post" action="${pageContext.request.contextPath}/registration.jsp">
    			<button type="submit">Register</button>
				</form>
			</p>
	  	</center>
	  	
        <a href="${pageContext.request.contextPath}/app/exception">Exception</a>
	</body>
</html> 