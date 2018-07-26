<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
body {
	background-image: url("for-login.jpg");
	background-repeat: no-repeat;
	background-size: 100% 160%;
}

table {
	background-color: white;
	font-size: 16px;
}

th {
	background-color: #007FFF;
	color: white;
	font-family: Lato;
	font-weight: bold;
	font-size: 20px;
}

#s16 {
	font-family: Lato;
	font-size: 15px;
	font-weight: bold;
	width: 110px;
	height: 30px;
	background-color: #007FFF;
	color: white;
}

#s16:hover {
	background-color: white;
	color: #007FFF;
}

.box {
	align: center;
	height: 30px;
}

#p {
	color: black;
	font-weight: bold;
}

a:link {
	color: red;
}

a:hover {
	color: white;
	font-family: Lato;
	font-size: 15px;
}
a:VISITED {
	color: pink;
	font-family: Lato;
	font-size: 15px;
}
</style>
</head>
<body>
	<br>
	<br>
	<br>
	<br>
	<br>
	<form action="login.html" target ="_top" method="post">
		<table align="center" cellspacing="2" cellpadding="10" height="60px">
			<tr>
				<th colspan="4">LOGIN</th>
			</tr>
			<tr>
				<td colspan="0" align="center"></td>
				<td align="center"><input name="userID" placeholder="Username"  /></td>
			</tr>
			<tr>
				<td colspan="0" align="center"></td>
				<td align="center"><input type = "Password" name="password" class="box" placeholder="Password" /></td>
			</tr>
			
			<tr>
				<td></td>
				<td><input type="submit" id="s16" value="Login" /></td>
			</tr>

	
		</table>
		
		
	</form>
	<br>
	
	<p align="center" id="p">
		New User?&nbsp;<a href="customerAdd.html" target="_top">Register Here</a>
	</p>
</body>
</html>