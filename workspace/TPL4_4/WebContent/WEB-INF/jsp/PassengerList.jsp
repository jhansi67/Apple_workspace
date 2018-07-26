<%@page import="java.util.ArrayList" import = "com.wipro.srs.bean.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>
<script>
	$(document).ready(function() {
		$("#jd").datepicker({
			maxDate : new Date(2016, 12, 31),
			minDate : new Date(2016, 12, 13),
			changeMonth : true,
			changeYear : true
		});
	});
</script>
<title>Passenger Details</title>

<style>
body {
	background: url('sr.jpg') no-repeat;
	background-size: 100% 300%;
	font-family: monotype corsiva;
	font-weight: bold;
}

#s {
	font-family: monotype corsiva;
	font-size: 18px;
	font-weight: bold;
	width: 70px;
	height: 25px;
}

#s:hover {
	background-color: #50A6C2;
	color: white;
}
</style>

<script type="text/javascript">
function test(i){
	var v = document.getElementById(i).value;
	
	if(v.indexOf(".")>=0)
	{
		alert("Invalid no")
		return false;
	}
	v = parseInt(v);
	
	if(isNaN(v)){
		alert("Entered data is not a number. Enter integer value for age.")
		return false;
	}
	if(v <= 0){
		alert("Age should be greater than 0")
		return false
	}
		
	return true;
}
</script>
</head>
<body>

	<br />
	<center>
	
	
		
	
	
		<font size="4"> Ticket fare per person is : <font color = "green">Rs. ${routefare}</font>								
		<br> Net payable amount for ${seat} persons is : <font color = "red">Rs. ${totalfare}<br></font>
		<br>You will be getting <font color = "red"> ${type}</font> tickets now as <font color = "green">${capacity}</font> seats are left<br>
		and ${totalWaitingReservations} no. of waiting reservations are there consisting of ${totalWaitingPassengers} passengers.
		<br>If you want to continue enter details of the passengers below and proceed...   <br>
		</font>
		<br>
		<form:form action="passenger.html" modelAttribute="pb">
			<table border="1" width="67%">
				<th align="center">Name</th>
				<th align="center">Age</th>
				<th align="left">Gender</th>


				<c:forEach begin="0" end="${seat-1}" varStatus="s">
					<tr>
						<td><input type="text" name="list[${s.index}].name" required
							WIDTH="50%" /></td>
						<td><input type="text" name="list[${s.index}].age" id = "list[${s.index}].age" required onblur="return test(this.id)"
							width="10%" /></td>

						<td width="40%"><input type="radio" value="M"
							name="list[${s.index}].gender" required />:Male <input
							type="radio" value="F" name="list[${s.index}].gender" required />:Female
						</td>


					</tr>
				</c:forEach>


			</table>
			<input type="submit" value="Submit" id="s" />
		</form:form>
	</center>
</body>
</html>