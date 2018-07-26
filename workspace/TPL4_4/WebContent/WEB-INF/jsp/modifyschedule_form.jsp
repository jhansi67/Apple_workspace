<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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


<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>



<!--  -->
<!--  -->
<!--  -->
<!--  -->
<!--  -->
<!--  -->
<!--  -->
<!--  -->

<!--  -->
<!--  -->
<!--  -->
<!--  -->
<!--  -->
<!--  -->
<!--  -->
<!--  -->

<script language="javascript" type="text/javascript"
	src="datetimepicker.js">
	//Date Time Picker script- by TengYong Ng of http://www.rainforestnet.com
	//Script featured on JavaScript Kit (http://www.javascriptkit.com)
	//For this script, visit http://www.javascriptkit.com
</script>



<!--  -->
<!--  -->
<!--  -->
<!--  -->
<!--  -->
<!--  -->
<!--  -->
<!--  -->

<!--  -->
<!--  -->
<!--  -->
<!--  -->
<!--  -->
<!--  -->
<!--  -->
<!--  -->











<script>
	$(document).ready(function() {
		$("#sd").datepicker({
			maxDate : new Date(2016, 12, 31),
			minDate : 0,
			changeMonth : true,
			changeYear : true
		});
	});
</script>





<title>Modify schedule</title>
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

#s13 {
	font-family: monotype corsiva;
	font-size: 18px;
	font-weight: bold;
	width: 150px;
	height: 30px;
}

#s13:hover {
	background-color: #50A6C2;
	color: white;
}

.errors {
	color: red;
}
</style>
</head>
<body>
	<br>
	<br>
	<br>
	<form:form action="schedule_modify.html" modelAttribute="sb1">
		<table align="center" cellspacing="2" cellpadding="10">
			<tr>
				<td colspan="2">Enter Schedule Id:</td>
				<td><form:input path="scheduleID"
						value='<%=request.getParameter("value")%>' readOnly="true" /></td>
			</tr>
			<tr>
				<td colspan="2">Enter Ship id:</td>
				<td><form:input path="shipID"
						value='<%=request.getParameter("value1")%>' /> <form:errors
						path="shipID" class="errors"></form:errors></td>
			</tr>
			<tr>
				<td colspan="2">Enter Route id:</td>
				<td><form:input path="routeID"
						value='<%=request.getParameter("value2")%>' /> <form:errors
						path="routeID" class="errors"></form:errors></td>
			</tr>
			<tr>
				<td colspan="2">Enter Start date:</td>
				<td>
					<form:input path="startDate" id="demo1" placeholder='<%=request.getParameter("value3")%>' /> 
					
				</td>

				<td><a href="javascript:NewCal('demo1','ddmmmyyyy',true,24)">
						<img src="cal.gif" width="16" height="16" border="0"
						alt="Pick a date">
					</a>
				</td>
				
				<td>
					<form:errors path="startDate" class="errors"></form:errors>
				</td>
			</tr>

			<tr>
				<td></td>
				<td colspan="2"><input type="submit" id="s13"
					value="Modify Schedule" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>