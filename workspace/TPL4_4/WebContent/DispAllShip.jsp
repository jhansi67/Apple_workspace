<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View all ships</title>
<style>
table {
	border-collapse: collapse;
	font-family: monotype corsiva;
	font-size: 18px;
	font-weight: bold;
	width: 100%;
}

body {
	background-image: url("ship4.jpg");
	background-repeat: no-repeat;
	background-size: 100% 200%;
}

#s1 {
	font-family: monotype corsiva;
	font-size: 18px;
	font-weight: bold;
	width: 60px;
	height: 30px;
}

#s1:hover {
	background-color: #50A6C2;
	color: white;
}

tr:nth-child(even) {
	background-color: #f2f2f2
}

th {
	background-color: #50A6C2;
	color: white;
}

a:hover {
	color: #50A6C2;
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
	<br>
	<form:form action="DeleteByShipId.html" modelAttribute="DeleteByShipId"
		align="center">
		<table align=center cellspacing="2" cellpadding="10" border="2">

			<tr>
				<th>Ship Id</th>
				<th>Ship Name</th>
				<th>Reservation Capacity</th>
				<th>Seating Capacity</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>

			<c:forEach var="ele" items="${dispall}">

				<tr>
					<td><c:out value="${ele.shipId}" /></td>
					<td><c:out value="${ele.shipName}" /></td>
					<td><c:out value="${ele.seatingCapacity}" /></td>
					<td><c:out value="${ele.reservationCapacity}" /></td>

					<%!int i = 0;%>
					<td><a
						href="ModifyShip1.html?value=${ele.shipId}&value1=${ele.shipName}&value2=${ele.seatingCapacity}&value3=${ele.reservationCapacity}">Edit</a></td>
					<td><input type="checkbox" name="delete" value="${ele.shipId}"
						id="<%=++i%>" onclick="ifchecked(this.id)" /></td>

				</tr>


			</c:forEach>
		</table>
		<br>
		<br>
		<input type="submit" id="s1" value="Delete"
			onclick=" return isSelected()" />
	</form:form>
</body>
</html>