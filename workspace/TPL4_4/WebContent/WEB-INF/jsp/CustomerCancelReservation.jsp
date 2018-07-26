<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
.header {
	font: 20px Georgia, sans-serif;
	color: red;
	font-weight: bold;
}

.reserve {
	background-image: url("cn.jpg");
	background-repeat: no-repeat;
	background-size: 100% 300%;
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

<script type="text/javascript">
	function validateForm() {
		var x = document.f1.reservationId.value;
		if (x == null || x == "") {
			alert("Reservation ID must be filled out amd x is " + x);
			return false;
		} else {
			return true;
		}
	}
	
	
</script>

</head>


<body class="reserve">
	<center>
		<h2 class="header">Cancel Reservation</h2>
		<h4 >Enter the Reservation ID</h4>
		
		
		
		<form:form action="confirmCancelTicket.html" method="POST" onsubmit="return validateForm()" name = "f1" modelAttribute="rb">
			<form:select path="reservationID" >
							<%
								java.util.ArrayList<String> s = (java.util.ArrayList<String>)request.getAttribute("rids");
													for(int i=0;i<s.size();++i){
														String sourcename = s.get(i);
														System.out.println(sourcename);
							%>
							<form:option value = "<%=sourcename%>"><%=sourcename%></form:option>

							<%
								}
							%>
						</form:select>
			<br>
			<br> 
			<input type="submit" name="submit" id = "s"/>


		</form:form>

	</center>
</body>
</html>