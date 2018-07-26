<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete</title>
</head>
<body>
	<form:form action="schedule_delete" modelAttribute="listid">
		<table border="1" align="center">
			<tr>
				<th>Schedule Id</th>
				<th>Select</th>
			</tr>
			<c:forEach var="l" items="${list }">
				<tr>
					<td>${l.scheduleID}</td>
					<td><form:checkbox path="listid" value="${l.scheduleID}" /></td>
				</tr>
			</c:forEach>
		</table>
	</form:form>
</body>
</html>