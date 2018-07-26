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
	background-size: 100% 450%;
}

#s2 {
	font-family: monotype corsiva;
	font-size: 18px;
	font-weight: bold;
	width: 60px;
	height: 25px;
}

#s2:hover {
	background-color: #50A6C2;
	color: white;
}
</style>
</head>


<body class="reserve">
	<center>
		<h3>View Your Ticket</h3>


		<form:form action="ViewTicketInput2.html" modelAttribute="rb">
			<table border="0">
				<tr>
					<td>ReservationId:</td>

					<td>
						
						

							<form:select path="reservationID">

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
				
					</td>
				</tr>

				<tr><td></td>
					<td colspan="2" align="center"><input type="submit"
						name="Submit" value="Submit" id="s2"/></td>
				</tr>
			</table>
		</form:form>

	</center>
</body>
</html>