<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
  <meta charset="utf-8">
  <title>Devices App</title>
  <style>
   body {
    font: 11pt Arial, Helvetica, sans-serif; /* Рубленый шрифт текста */
    margin: 0; /* Отступы на странице */
   }
   h1 {
    font-size: 36px; /* Размер шрифта */
    margin: 0; /* Убираем отступы */
    color: #000; /* Цвет текста */
   }
   h2 {
    margin-top: 0; /* Убираем отступ сверху */
   }
   #header { /* Верхний блок */
    background: #ccc; /* Цвет фона */
    padding: 10px; /* Поля вокруг текста */
   }
   #sidebar { /* Левая колонка */
    float: left; /* Обтекание справа */
    border: 1px solid #333; /* Параметры рамки вокруг */
    width: 20%; /* Ширина колонки */
    padding: 5px; /* Поля вокруг текста */
    margin: 10px 10px 20px 5px; /* Значения отступов */
   }
   #content { /* Правая колонка */
    margin: 10px 5px 20px 25%; /* Значения отступов */
    padding: 5px; /* Поля вокруг текста */
    border: 1px solid #333; /* Параметры рамки */
   }
   #footer { /* Нижний блок */
    background: #333; /* Цвет фона */
    padding: 5px; /* Поля вокруг текста */
    color: #fff; /* Цвет текста */
    clear: left; /* Отменяем действие float */
   }
   #form { 
    width: 500px; 
    background: #ccc;
    padding: 15px;
    border: solid 1px black; 
    align: center;
   }
  </style>
 </head>
 <body>
  <div id="header"><h1>H1 Title</h1></div>
  <div id="sidebar">
  	<h2>Hello, guest!</h2>
    <p><a href="registration.gsp">Registration</a></p>
  </div>
  <div id="content">
    <center>
			<h3>Please, login</h3>
			<br>
			<div id="form">
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
  </div>
  <div id="footer">&copy; Vitalii Hrushyn</div>
 </body>
</html>