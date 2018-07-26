<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">

.back {
	background-image: url("image5.jpg");
	background-repeat: no-repeat;
	background-size: 100% 300%;
	
}
a:link {
    color: white;
}
a:visited {
    color: cyan;
}
a:hover {
    color: hotpink;
}
a:active {
    color: red;
}
</style>


<SCRIPT type="text/javascript">
    window.history.forward();
    function noBack() { window.history.forward(); }
</SCRIPT>

</head>



<body class="back" onload="noBack();"
    onpageshow="if (event.persisted) noBack();" onunload="">
	
	<div align="right">
		
		<b>
			<table>
				<tr>
					<td width="80%"></td>
					<td width="10%"><a href="adminhomepage.jsp" target="_top"><u>Home</u></a>
					</td>
					<td width="10%"><a href="logout.html" target="_top"><u>Logout</u></a>
					</td>
				</tr>
			</table>
		</b>
	</div>




</body>
</html>