<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment</title>

<link
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>
<script>
	$(document).ready(function() {
		$("#to").datepicker({
			maxDate : new Date(2100, 12, 31),
			minDate : 0,
			changeMonth : true,
			changeYear : true
		});
	});

	$(document).ready(function() {
		$("#from").datepicker({
			maxDate : 0,
			minDate : new Date(1900, 1, 1),
			changeMonth : true,
			changeYear : true
		});
	});
</script>



<style>
body {
	background: url('sr.jpg') no-repeat;
	background-size: 100% 400%;
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
	function test(i) {
		var v = document.getElementById("cno").value;
		var from = document.getElementById("from").value;
		var to = document.getElementById("to").value;
	//	alert(from)
	//	alert(to)
		
		if(from == null || from == ""){
			alert("Eneter date of issue of your card")
			return false;
		}
		
		if(to == null || to == ""){
			alert("Eneter exipry date of your card")
			return false;
		}
		
		if (v.indexOf(".") >= 0) {
			alert("Invalid no")
			return false;
		}
		v = parseInt(v);

		if (isNaN(v)) {
			alert("Entered data is not a number. Enter integer value for creditcard.")
			return false;
		}
		if (v <= 0) {
			alert("Creditcard number should be greater than 0")
			return false
		}

		return true;
	}
</script>
</head>
<body>
	<center>
		<h3>Online Payment</h3>
		<form:form action="paymentprocess.html" modelAttribute="creditcard">
			<table border="0" width="40%" cellpadding="4" width="70%">

				<tr>
					<td>Credit card No.:</td>
					<td><form:input path="creditCardNumber" id="cno" /></td>
				</tr>

				<tr>
					<td>Valid from:</td>
					<td><form:input path="validFrom" id="from" readonly="true"/></td>
				</tr>

				<tr>
					<td>Valid to:</td>
					<td><form:input path="validTo" id="to" readonly="true" /></td>
				</tr>

				<tr>
					<td></td>
					<td><input type="submit" value="Submit" id="s"
						onclick="return test()" /></td>
				</tr>
			</table>

		</form:form>

	</center>
	</center>
</body>
</html>