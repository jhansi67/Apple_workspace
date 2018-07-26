<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
	width: 130px;
	height: 30px;
}

#s7:hover {
	background-color: #50A6C2;
	color: white;
}
</style>
</head>
<body>
	<br>
	<br>
	<br>
	<br>
	<form:form action="viewpassenger.html" modelAttribute="sb3">
		<table align="center" cellspacing="2" cellpadding="10">
			<tr>
				<td>Schedule id:</td>
				

				<td>
					<form:select path="scheduleID" >
						<%
								java.util.ArrayList<String> s = (java.util.ArrayList<String>)request.getAttribute("sidList");
														for(int i=0;i<s.size();++i){
															String sn = s.get(i);
							%>

							<form:option value="<%=sn%>">
								<%=sn%>
							</form:option>

							<%
								}
							%>
					</form:select>
				</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" id="s7" value="View Passengers" /></td>
			</tr>
		</table>

	</form:form>
</body>
</html>