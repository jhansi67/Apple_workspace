<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Log out page</title>

<style type="text/css">
.back {
	background: url('log.jpg') no-repeat;
	background-size: cover;
}

div {
	width: 500px;
	color: #818181;
	border: 2px solid #ccc;
	padding-left: 10px;
	padding-right: 10px;
	padding-top: 20px;
	padding-bottom: 5px;
	font-family: Georgia;
	font-size: 14px;
	-moz-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.5);
	-webkit-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.5);
	-moz-border-radius: 15px;
	-webkit-border-radius: 15px;
	color: blue;
	background: url('');
}
</style>

<script type="text/javascript">
	window.history.forward();

	function noBack() {
		window.history.forward();
	}
</script>
</head>




<body onload="noBack();" onpageshow="if (event.persisted) noBack();" onunload="">
	<center>
		<div>
			<h2>You have been successfully logged out</h2>
			<h3>
				Go to<a href="index1.jsp"> Login Page</a>
			</h3>
		</div>
	</center>
</body>
</html>