<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
	background-size: 100% 260%;
}
a:hover{
	color: #50A6C2;
}
#s5{
	font-family: monotype corsiva;
	font-size: 18px;
	font-weight: bold;
	width: 60px;
	height: 30px;
	
}
#s5:hover{
	background-color: #50A6C2;
	color: white;
}
</style>

<script type="text/javascript">
	var selectnos = 0;
	function ifchecked(i) {

		if (document.getElementById(i).checked) {
			selectnos++;
		//	alert("checked="+i+" selects="+selectnos);
		} else {
			selectnos--;
		//	alert("unchecked= "+i+" selects="+selectnos);
		}
	}
	
	
	function isSelected() {
		if(selectnos == 0)
		{
			alert("You haven't selected any ship to delete...");
			return false;
		}
	}
</script>
</head>
<body>
<br>
	<form:form action="schedule_delete.html" align="center">
		<table align="center" border="1" cellspacing="2" cellpadding="10">
			<tr>
				<th>Schedule ID</th>
				<th>Ship ID</th>
				<th>Route ID</th>
				<th>Start Date</th>
				<th>Click to Edit</th>
				<th>Click to delete</th>
			</tr>
			<c:forEach var="l" items="${list}">
				<%!int i = 0;%>
				<tr>
					<td>${l.scheduleID}</td>
					<td>${l.shipID}</td>
					<td>${l.routeID}</td>
					<td>${l.startDate}</td>
					<td><a href="schedule_modify.html?value=${l.scheduleID}&value1=${l.shipID}&value2=${l.routeID}&value3=${l.startDate}">Edit</a></td>
					<td><input type="checkbox" name="delete" id="<%=++i%>" onclick="ifchecked(this.id)"
						value='${l.scheduleID }' /></td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<input type="submit" id="s5" value="Delete" onclick=" return isSelected()"/>
	</form:form>
</body>
</html>