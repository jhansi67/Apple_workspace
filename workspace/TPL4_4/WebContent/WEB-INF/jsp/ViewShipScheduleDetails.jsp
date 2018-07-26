<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Schedule details</title>


<style type="text/css">
.header {
	font: 20px  monotype corsiva;
	color: #4B088A;
	font-weight: bold;
	font-size: 30px;
}

.reserve {
	background-image: url("OCEAN_SHIELD.jpg");
	background-repeat: no-repeat;
	background-size: 100% 430%;
}

#s{
	font-family: monotype corsiva;
	font-size: 18px;
	font-weight: bold;
	width: 70px;
	height: 25px;
	
}
#s:hover{
	background-color: #50A6C2;
	color: white;
}
table {
	font-family: monotype corsiva;
	font-weight: bold;
}

</style>
</head>


<body class="reserve">
	<center>
		<h2>Schedule Details By Date and Route:</h2>
		<table border = "1" width="70%">
			<th>Schedule Id</th>
			<th>Ship Id</th>
			<th>Route Id</th>
			<th>Start Date</th>
			<th>Reserve</th>
			
			<c:forEach var="a" items="${schduleList}">
			<tr>
				<td align = "center">	<c:out value="${a.scheduleID}" />	</td>
				<td align = "center">	<c:out value="${a.shipID}" />		</td>
				<td align = "center">	<c:out value="${a.routeID}" />		</td>
				<td align = "center">	<c:out value="${a.startDate}" />	</td>
				
			
				<td align = "center">	<a href = "DirectReserveShip.html?scheduleID=${a.scheduleID}">	reserve	</a>	</td>
			</tr>
			</c:forEach>
		</table>
	</center>
</body>
</html>