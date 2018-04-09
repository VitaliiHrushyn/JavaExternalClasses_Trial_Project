<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Search results page</title>
	</head>
	
	<body>
		<h1>Search results</h1>
		<menu>
			<h3>Menu</h3>
			<a href="${pageContext.request.contextPath}/app/login">My profile</a>
			<br>
			<a href="${pageContext.request.contextPath}/app/showdevices">Show all devices</a>
			<br>
			<br>
			<form method ="get" action="${pageContext.request.contextPath}/app/finddevice">
			  <fieldset>
			    <legend>Search for device</legend>
			    Power:<br>
			    from 
			    <input type="number" name="powerFrom" value="0"> 
			    to 
			    <input type="number" name="powerTo" value="3000"><br>
			    Voltage:<br>
			    <input type="checkbox" name="220" value="220" checked> 220 V 
  				<input type="checkbox" name="380" value="380"> 380 V<br><br>
			    <input type="submit" value="Search">
			  </fieldset>
			</form>
		</menu>
		<br>
		<hr>
			<c:set var="totalPower" value="${requestScope.totalPower}"/>
			Total power: ${totalPower}
			<br>
			<c:set var="totalPower" value="${requestScope.currentPower}"/>
			Current power: ${currentPower}
			<br>
		<hr>
		<h4>Devices: <em>(switched ON first)</em></h4>
			<c:forEach var="device" items="${requestScope.findeddevices}">
				<ul>	
					<li>Name: <c:out value="${device.name}"/> </li>
					<li>Power: <c:out value="${device.power}"/> </li>
					<li>Voltage: <c:out value="${device.voltage}"/> </li>  
					<li>Switched: <c:if test="${device.switched == true}">ON</c:if>
								  <c:if test="${device.switched == false}">OFF</c:if> 
								  </li>
					<li>Location: <c:out value="${device.location}"/> </li>
					<li>Doing: <c:out value="${device.doWork()}"/> </li>
				</ul>
				<hr>
			</c:forEach>
	</body>
</html>