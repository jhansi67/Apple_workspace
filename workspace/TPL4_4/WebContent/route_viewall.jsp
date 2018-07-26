<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
	background-size: 100% 200%;
}
a:hover{
	color: #50A6C2;
}
#s9{
	font-family: monotype corsiva;
	font-size: 18px;
	font-weight: bold;
	width: 60px;
	height: 30px;
	
}
#s9:hover{
	background-color: #50A6C2;
	color: white;
}

</style>
</head>
<body>
<br><br>
<form:form action="DeleteByShipId1.html" modelAttribute="DeleteByShipId1" align="center">
<table align="center" border="1" cellspacing="2" cellpadding="10">
<tr>
<th>Route ID</th>
<th>Source</th>
<th>Destination</th>
<th>Travel Duration</th>
<th>Fare</th>
<th>Click to edit</th>
<th>Click to delete</th>
</tr>
<c:forEach var="l" items="${list1}">
<tr>
<td>${l.routeID}</td>
<td>${l.source}</td>
<td>${l.destination}</td>
<td>${l.travelDuration}</td>
<td>${l.fare}</td>
<td><a href="ModifyRoute.html?value=${l.routeID}&value1=${l.source}&value2=${l.destination}&value3=${l.travelDuration}&value4=${l.fare}">Edit</a></td>
  <td><a href="DeleteRoute.html?value=${l.routeID}">Delete</a>
 </tr>
 </c:forEach>

</table>
<br><br>
    
    </form:form>
</body>
</html>