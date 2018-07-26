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
	background-size: 100%;
}
</style>
</head>
<body class="back">
	<font color="white"><b><i> Logged with UserID: <%
		HttpSession httpsession = request.getSession();
		out.print("   " + httpsession.getAttribute("userID"));
	%>
		</i></b></font>
</body>
</html>