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
	background-size: 100% 320%;
}

#s2 {
	font-family: monotype corsiva;
	font-size: 18px;
	font-weight: bold;
	width: 60px;
	height: 30px;
}

#s2:hover {
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
	<!-- 
	<form:form action="ViewByShipId.html" modelAttribute="ViewByShipId">
		<table align=center cellspacing="2" cellpadding="10">
			<tr>
				<td colspan="2">Enter Ship Id:</td>
				<td><form:input path="shipId" /></td>
			</tr>

			<tr>
				<td></td>
				<td colspan="2" align="center"><input type="submit" id="s2"
					value="View" /></td>
			</tr>
		</table>
	</form:form>
 -->
	<center>
		<form:form action="ViewByShipId.html" modelAttribute="ViewByShipId">
			<table>
				<tr>
					<td width = "40%">Select ShipId:</td>
					<td width ="20%"></td>
					<td width ="50%"><form:select path="shipId">
							<%
								java.util.ArrayList<String> s = (java.util.ArrayList<String>)request.getAttribute("shipidlist");
														for(int i=0;i<s.size();++i){
															String sn = s.get(i);
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
				<tr><td></td></tr>
				<tr><td></td></tr>
				<tr><td></td></tr>
				<tr><td></td></tr>
				<tr><td></td></tr>
				<tr><td></td></tr>
				<tr><td></td></tr>
				<tr width ="30px"></tr>
				<tr>
					<td></td>
					<td></td>
					<td><input type="submit" value="View" id = "s2"/></td>
				</tr>
			</table>
		</form:form>
	</center>
</body>
</html>