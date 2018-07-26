<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.reserve {
	background-image: url("1.jpg");
	background-repeat: no-repeat;
	background-size: cover;
	background-size: 100% 500%;
}
#s15{
	font-family: monotype corsiva;
	font-size: 18px;
	font-weight: bold;
	width: 80px;
	height: 25px;
	
}
#s15:hover{
	background-color: #50A6C2;
	color: white;
}
</style>
</head>
<body class="reserve">

	<center>
		<h3>Print Your Ticket</h3>
		<form:form action="PrintTicketInput2.html" modelAttribute="rb">
			<table border="0" width="30%">
				<tr>
					<td width="35%">ReservationId:</td>
					<td width="5%"></td>
					<td><form:select path="reservationID">

							<%
								java.util.ArrayList<String> s = (java.util.ArrayList<String>)request.getAttribute("rids");
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

				<tr>
					<td width="35%"></td>
					<td width="15%"></td>
					<td><input type="submit" name="Submit" value="Submit" id="s15"/></td>
				</tr>
			</table>
		</form:form>
	</center>
</body>
</html>