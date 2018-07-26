<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
	width: 100%;
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

#s7 {
	font-family: monotype corsiva;
	font-size: 18px;
	font-weight: bold;
	width: 60px;
	height: 30px;
}

#s7:hover {
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
		if (selectnos == 0) {
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
	<form action="schedule_delete.html" method="post" align="center">
		<table align="center" border="1" cellspacing="2" cellpadding="10">
			<tr>
				<th>Schedule ID</th>
				<th>Ship ID</th>
				<th>Route ID</th>
				<th>Start Date</th>
				<th>Click to Edit</th>
				<th>Click to Delete</th>
			</tr>
			<tr>
				<td>${sb2.scheduleID}</td>
				<td>${sb2.shipID}</td>
				<td>${sb2.routeID}</td>
				<td>${sb2.startDate}</td>
				<td><a
					href="schedule_modify.html?value=${sb2.scheduleID}&value1=${sb2.shipID}&value2=${sb2.routeID}&value3=${sb2.startDate}">Edit</a></td>
				<td><input type="checkbox" name="delete" id="1" onclick="ifchecked(this.id)"
					value='${sb2.scheduleID }' /></td>
			</tr>
		</table>
		<br> <input type="submit" id="s7" value="Delete" onclick=" return isSelected()"/>
	</form>
</body>
</html>