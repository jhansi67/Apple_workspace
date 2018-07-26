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
	background: #50A6C2;
	color: white;
	font-family: script;
	font-size: 15px;
	font-weight: bold;
}

.navigator:hover {
	background: white;
	color: #50A6C2;
}

.table_dimension {
	height: 100%;
	width: 100%;
}

.back {
	background-image: url("image11.jpg");
	background-repeat: no-repeat;
	background-size: 100% 160%;
}

.wr {
	display: block;
	background: #0dd39d;
	color: #0dd39d;
	border: none;
	padding: 10px 20px;
	-moz-border-radius: 2px;
	border-radius: 2px;
	cursor: pointer;
}
</style>

</head>
<body class="back">

	<form>
		<table class="table_dimension">
			
			<tr height="50px">
				<td><a href="ModifyShip.html" target="NO3_RIGHT"> <input
						type="button" class="navigator" id="modifysh" name="modifysh"
						value="Add Ship Details" onclick="" width="100%" /><br />
				</a></td>
			</tr>
			<tr height="50px">
				<td><a href="ViewAllShips.html" target="NO3_RIGHT"> <input
						type="button" class="navigator" id="viewi" name="view"
						value="View Ship Details" onclick="" width="100%" /><br />
				</a></td>
			</tr>

			<tr height="50px">
				<td><a href="ViewByShipId.html" target="NO3_RIGHT"> <input
						type="button" class="navigator" id="viewsi" name="viewsi"
						value="View Ship By ID" onclick="" /><br />
				</a></td>
			</tr>

			<tr height="50px">
				<td><a href="AddRoute.html" target="NO3_RIGHT"> <input
						type="button" class="navigator" id="addr" name="addr"
						value="Add Route Details" onclick="" width="100%" /><br />
				</a></td>
			</tr>
			
			<tr height="50px">
				<td><a href="route_viewall.html" target="NO3_RIGHT"> <input
						type="button" class="navigator" id="viewr" name="viewr"
						value="View Route Details" onclick="" width="100%" /><br />
				</a></td>
			</tr>
			
			<tr height="50px">
				<td><a href="route_viewbyId.html" target="NO3_RIGHT"> <input
						type="button" class="navigator" id="viewri" name="viewri"
						value="View Route By ID" onclick="" width="100%" /><br />
				</a></td>
			</tr>
			
			<tr height="50px">
				<td><a href="schedule_add.html" target="NO3_RIGHT"> <input
						type="button" class="navigator" id="addsc" name="addsc"
						value="Add Schedule Details" onclick="" width="100%" /><br />
				</a></td>
			</tr>
			<tr height="50px">
				<td><a href="schedule_viewall.html" target="NO3_RIGHT"> <input
						type="button" class="navigator" id="viewsc" name="viewsc"
						value="View Schedule Details" onclick="" width="100%" /><br />
				</a></td>
			</tr>

			<tr height="50px">
				<td><a href="schedule_viewbyId.html" target="NO3_RIGHT"> <input
						type="button" class="navigator" id="viewsci" name="viewsci"
						value="View Schedule By ID" onclick="" width="100%" /><br />
				</a></td>
			</tr>

			
			

			


			<tr height="50px">
				<td><a href="viewpassenger.html" target="NO3_RIGHT"> <input
						type="button" class="navigator" id="viewpi" name="viewpi"
						value="View Passenger By ID" onclick="" width="100%" /><br />
				</a></td>
			</tr>


			<tr>
				<td height="50px"><a href="ChangePassword.html"
					target="NO3_RIGHT"> <input type="button" class="navigator"
						id="print" name="print" value="Change Password" onclick=""
						width="100%" />
				</a></td>
			</tr>
		</table>


	</form>



</body>
</html>