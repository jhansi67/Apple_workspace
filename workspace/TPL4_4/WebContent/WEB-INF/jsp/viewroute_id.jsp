<%@page import="java.util.ArrayList"%>
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
	background-size: 100% 350%;
}

#s10 {
	font-family: monotype corsiva;
	font-size: 18px;
	font-weight: bold;
	width: 100px;
	height: 30px;
}

#s10:hover {
	background-color: #50A6C2;
	color: white;
}

a:hover {
	color: #50A6C2;
}
</style>
</head>
<body>
	<br>
	<br>
	<br>
	<br>
	<br>
	<form:form action="route_viewbyId.html" modelAttribute="rb"
		align="center">
		<table align="center">
				<tr>
					<td width = "40%">Select RouteID:</td>
					<td width ="20%"></td>
					<td width ="50%"><form:select path="routeID">
							<%
								java.util.ArrayList<String> s = (java.util.ArrayList<String>)request.getAttribute("rids");
														for(int i=0;i<s.size();++i){
															String sn = s.get(i);
															System.out.println(sn);
							%>

							<form:option value="<%=sn%>">
								<%=sn%>
							</form:option>

							<%
								}
							%>
						</form:select></td>
				</tr>
				<tr><td></td></tr>
				<tr><td></td></tr>
				<tr><td></td></tr>
				<tr><td></td></tr>
				<tr><td></td></tr>
				<tr><td></td></tr>
				<tr><td></td></tr>
				<tr><td></td></tr>
				<tr><td></td></tr>
				<tr><td></td></tr>
				<tr><td></td></tr>
				<tr><td></td></tr>
				<tr><td></td></tr>
				<tr><td></td></tr>
				
				<tr width ="10px"></tr>
				<tr>
					<td></td>
					<td></td>
										
					<td><input type="submit" value="View" id = "s10"/></td>
				</tr>
			</table>
		</form:form>
	</center>
</body>
</html>