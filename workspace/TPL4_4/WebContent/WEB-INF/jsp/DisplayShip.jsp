<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ship Details</title>
<style>
table {
	border-collapse: collapse;
	font-family: monotype corsiva;
	font-size: 18px;
	font-weight: bold;
}

body {
	background-image: url("ship4.jpg");
	background-repeat: no-repeat;
	background-size: 100% 300%;
}

th {
	background-color: #50A6C2;
	color: white;
}

a:hover {
	color: #50A6C2;
}

#s3 {
	font-family: monotype corsiva;
	font-size: 18px;
	font-weight: bold;
	width: 60px;
	height: 30px;
}

#s3:hover {
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
	<br>
	<br>
	<form:form action="DeleteByShipId.html" modelAttribute="DeleteByShipId"
		align="center">

		<table align=center border="2" cellspacing="2" cellpadding="10">

			<tr>
				<th>Ship Name</th>
				<th>Ship Id</th>
				<th>Reservation Capacity</th>
				<th>Seating Capacity</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>


			<tr>
				<td>${ship.shipName}</td>
				<td>${ship.shipId}</td>
				<td>${ship.reservationCapacity}</td>
				<td>${ship.seatingCapacity}</td>
				<td><a
					href="ModifyShip1.html?value=${ship.shipId}&value1=${ship.shipName}&value2=${ship.seatingCapacity}&value3=${ship.reservationCapacity}">Edit</a></td>
				<td><input type="checkbox" name="delete" value="${ship.shipId}" id = "i" onclick="ifchecked(this.id)"/></td>
			</tr>






		</table>
		<br>
		<br>
		<input type="submit" id="s3" value="Delete" onclick="return isSelected()">
	</form:form>
</body>
</html>