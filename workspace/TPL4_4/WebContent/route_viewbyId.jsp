<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
table{
	border-collapse: collapse;
	font-family: monotype corsiva;
	font-size: 18px;
	font-weight: bold; 
	width: 100%;
}
body{
background-image: url("ship4.jpg");
background-repeat: no-repeat;
background-size: 100% 300%;
}
th {
    background-color: #50A6C2;
    color: white;
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
<th>Route ID</th>
<th>Source</th>
<th>Destination</th>
<th>Travel Duration</th>
<th>Fare</th>
<th>Click to edit</th>
<th>Click to delete</th>
</tr>
<tr>
<td>${rb.routeID}</td>
<td>${rb.source}</td>
<td>${rb.destination}</td>
<td>${rb.travelDuration}</td>
<td>${rb.fare}</td>
<td><a href="ModifyRoute.html?value=${rb.routeID}&value1=${rb.source}&value2=${rb.destination}&value3=${rb.travelDuration}&value4=${rb.fare}">Edit</a></td>
<td><a href="DeleteRoute.html?value=${rb.routeID}">Delete</a></td>
</tr>
</table>
</body>
</html>