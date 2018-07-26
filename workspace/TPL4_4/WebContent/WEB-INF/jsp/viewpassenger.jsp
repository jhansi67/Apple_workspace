<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
table {
    border-collapse: collapse;
    width: 100%;
    font-family: monotype corsiva;
	font-size: 18px;
	font-weight: bold;
}


tr:nth-child(even){background-color: #f2f2f2}


th {
    background-color: #50A6C2;
    color: white;
}
body{
	background-image: url("ship4.jpg");
	background-repeat: no-repeat;
	background-size: 100% auto;
}
a:hover{
	color: #50A6C2;
}
</style>
</head>
<body>
<br><br><br><br><br>
<table align="center" border="1" cellspacing="2" cellpadding="10">
<tr>
<th>Reservation ID</th>
<th>Schedule ID</th>
<th>Name</th>
<th>Age</th>
<th>Gender</th>
</tr>
<c:forEach var="l" items="${list2}">
<tr>
<td>${l.reservationID}</td>
<td>${l.scheduleID}</td>
<td>${l.name}</td>
<td>${l.age}</td>
<td>${l.gender}</td>
 </tr>
 </c:forEach>
</table>
</body>
</html>