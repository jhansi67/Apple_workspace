<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
	background-size: 100% 200%;
}

#s {
	font-family: monotype corsiva;
	font-size: 18px;
	font-weight: bold;
	width: 60px;
	height: 30px;
}

#s:hover {
	background-color: #50A6C2;
	color: white;
}
</style>

<script type="text/javascript">
	function checkCapacity() {
		var scap = document.f1.seatingCapacity.value;
		var rcap = document.f1.reservationCapacity.value;

		if(scap.indexOf(".")>=0 || rcap.indexOf(".")>=0 )
		{
			alert("Invalid no")
			return false;
		}
		
		if(isNaN(scap))
		{
			alert('Entered seating capacity is not a number');
			return false;
		}
		
		if(isNaN(rcap))
		{
			alert('Entered reservation capacity is not a number');
			return false;
		}
		
		scap = parseInt(scap);
		rcap = parseInt(rcap);

		if (rcap > scap)
		{
			alert("Reservation capacity should be less or equal to the seating capacity...");
			return false;
		}
	}
</script>
</head>
<body>

	<form:form action="ModifyShip.html" modelAttribute="ModifyShip"
		name="f1">
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<table align="center" cellspacing="4" cellpadding="15">

			<tr>
				<td colspan="3">Enter Ship Name</td>
				<td><form:input path="shipName" /></td>
				<td><form:errors path="shipName" /></td>
			</tr>
			<tr>
				<td colspan="3">Enter Seating Capacity</td>
				<td><form:input path="seatingCapacity" id = "scap"/></td>
				<td><form:errors path="seatingCapacity" /></td>
			</tr>
			<tr>
				<td colspan="3">Enter Reservation Capacity</td>
				<td><form:input path="reservationCapacity" id = "rcap"/></td>
				<td><form:errors path="reservationCapacity" /></td>
			</tr>
			<tr>

				<td colspan="3" align="center"></td>
				<td colspan="3">
					<input type="submit" id="s" value="Add" onclick="return checkCapacity()"/>
				</td>
				<td></td>
			</tr>
		</table>
	</form:form>

</body>
</html>