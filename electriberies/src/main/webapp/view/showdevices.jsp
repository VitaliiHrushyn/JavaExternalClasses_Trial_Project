<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
  <c:set var="login" value="${sessionScope.login}"/>
  <div id="header"><h1><c:out value="${requestScope.login}"/>'s devices</h1></div>
  <div id="sidebar">
  	<h2>MENU</h2>
  	<p><a href="${pageContext.request.contextPath}/app/logout">Logout</a></p>
    <p><a href="${pageContext.request.contextPath}/app/login">Profile</a></p>
    	<fieldset>
			    <legend>Power</legend>
			<c:set var="totalPower" value="${requestScope.totalPower}"/>
			total: ${totalPower}
			<br>
			<c:set var="totalPower" value="${requestScope.currentPower}"/>
			current: ${currentPower}
			<br>
		</fieldset>
	<form method ="get" action="${pageContext.request.contextPath}/app/finddevice">
			  <fieldset>
			    <legend>Search for device:</legend>
			    Power:<br>
			    from ...<input type="number" name="powerFrom" value="0"> 
			    <br>
			    to  ...... <input type="number" name="powerTo" value="3000"><br>
			    Voltage:<br>
			    <input type="checkbox" name="220" value="checked" checked> 220 V 
  				<input type="checkbox" name="380" value="checked" checked> 380 V<br></br>
			    <input type="submit" value="Search">
			  </fieldset>
			</form>
  </div>
  <div id="content">
  	<h4>Devices: <em>(switched ON first)</em></h4>
  			<c:set var="devices" value="${requestScope.devices}"/>
  			
		 	<c:forEach var="device" items="${devices}">
			 <hr>
				<ul>	
					<li>Name: <c:out value="${device.name}"/> </li>
					<li>Power: <c:out value="${device.power}"/> </li>
					<li>Voltage: <c:out value="${device.voltage}"/> </li>  
					<li>Switched: <c:if test="${device.switched == true}">ON</c:if>
								  <c:if test="${device.switched == false}">OFF</c:if> 
								  </li>
					<li>Location: <c:out value="${device.location}"/> </li>
					<li>Work: <c:out value="${device.doWork()}"/> </li>
				</ul>				
			</c:forEach> 
    <div>
		<!-- <c:set var="message" value="${requestScope.message}"/>
		<h4>message: ${message}</h4>  -->
	</div>		
  </div>
  <div id="footer">&copy; Vitalii Hrushyn</div>
 </body>
</html>