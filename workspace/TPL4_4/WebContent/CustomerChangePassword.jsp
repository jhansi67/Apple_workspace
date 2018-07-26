<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Passowrd</title>


<script type="text/javascript">
	function validateForm() {
		var x = document.f1.newPassword.value;
		var y = document.f1.confirmPassword.value;
		var z = document.f1.password.value;
		if ((x != y) || x == "" || y == "" || z == "") {
			alert("Password, Confirm Password and New Password must be correctly filled");
			return false;
		} else {
			return true;
		}
	}
</script>

<style type="text/css">
.reserve {
	background-image: url("pass.jpg");
	background-repeat: no-repeat;
	background-size: 100% 320%;
}

.he {
	font-family: monotype corsiva;
	font-weight: bold;
}

table {
	font-family: monotype corsiva;
	font-weight: bold;
}
#s{
	font-family: monotype corsiva;
	font-size: 18px;
	font-weight: bold;
	width: 70px;
	height: 25px;
	
}
#s:hover{
	background-color: #50A6C2;
	color: white;
}
</style>
</head>


<body class="reserve">


	<form action="passwordChange.html" method="POST" name="f1"
		onsubmit="return validateForm()">

		<h3 class="he">Change Password:</h3>
		<table cellspacing="4" width="50%">

			<tr>
				<td>Your Old Password</td>

				<td><input type="password" name="password" required></td>
			</tr>

			<tr>
				<td>Your New Password</td>

				<td><input type="password" name="newPassword" required></td>
			</tr>

			<tr>
				<td>Confirm Password</td>

				<td><input type="password" name="confirmPassword" required></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Change" id="s"></td>
			</tr>
		</table>

	</form>








</body>
</html>