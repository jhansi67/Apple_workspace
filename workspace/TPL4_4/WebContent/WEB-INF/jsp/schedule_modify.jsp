<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modify</title>
</head>
<body>
	<h2>Schedule modified successfully</h2>
	<b>Modified schedule:</b>
	<table border="1" cellspacing="2" cellpadding="10" align="center">
		<tr>
			<td>Schedule Id:</td>
			<td>${sb1.scheduleID }</td>
		</tr>
		<tr>
			<td>Ship Id:</td>
			<td>${sb1.shipID }</td>
		</tr>
		<tr>
			<td>Route Id:</td>
			<td>${sb1.routeID }</td>
		</tr>
		<tr>
			<td>Start Date:</td>
			<td>${sb1.startDate }</td>
		</tr>
	</table>
</body>
</html>