<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.navigator {
	width: 100%;
	height: 100%;
	background: url('ocean1.jpg');
	color: white;
	font-family: script;
	font-size: 15px;
	font-weight: bold;
}
.navigator:hover{
	background: url('') no-repeat 20% 50%;
	color: black;
	border:  teal;
}
.table_dimension {
	height: 100%;
	width: 100%;
}

.back {
	background-image: url("nav1.jpg");
	background-repeat: no-repeat;
	background-size: 100% 130%
}


.header {
	font-family: Georgia, sans-serif;
	font-weight: bold;
	font-size: 20px;
	color: #006699;
}


</style>

</head>
<body class="back">
<center>
<br/>
	<br />
	<form>
		<table class="table_dimension">
			<tr height="50px">
				<td><a href="ViewShipDetails.html" target="NO3_RIGTH"> <input
						type="button" class="navigator" id="viewi" name="view"
						value="View Schedule Details" onclick="" width="100%" /><br /><br />
				</a></td>
			</tr>

			<tr height="8px"></tr>
			<tr>
				<td height="50px"><a href="CustomerReserveShip.html"
					target="NO3_RIGTH"> <input type="button" class="navigator"
						id="reserve" name="reserve" value="Reserve" onclick="" /><br /><br />
				</a></td>
			</tr>

			<tr height="8px"></tr>
			<tr>
				<td height="50px"><a href="ticketCancel.html"
					target="NO3_RIGTH"> <input type="button" class="navigator"
						id="cancel" name="cancel" value="Cancel Ticket" onclick="" /><br /><br />
				</a></td>
			</tr>

			<tr height="8px"></tr>
			<tr>
				<td height="50px"><a href="ViewTicketInput.html"
					target="NO3_RIGTH"> <input type="button" class="navigator"
						id="viewticket" name="viewticket" value="View Ticket" onclick="" /><br /><br />
				</a></td>
			</tr>

			<tr height="8px"></tr>
			<tr>
				<td height="50px"><a href="PrintTicketInput.html"
					target="NO3_RIGTH"> <input type="button" class="navigator"
						id="print" name="print" value="Print Ticket" onclick=""
						width="100%" /><br /><br />
				</a></td>
			</tr>


			<tr height="8px"></tr>
			<tr>
				<td height="50px"><a href="ChangePassword.html"
					target="NO3_RIGTH"> <input type="button" class="navigator"
						id="print" name="print" value="Change Password" onclick=""
						width="100%" /><br /><br />
				</a></td>
			</tr>
		</table>


	</form>



</body>
</html>