<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form:form action="ViewByRouteId.html" modelAttribute="ViewByRouteId">
		<table align=center>
			<tr>
				<td>Enter Route Id whose details are to be viewed
			</tr>

			<tr>
				<td><form:input path="routeID" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="View" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>