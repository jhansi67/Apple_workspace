<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<title>Ship Reservation</title>
<style type="text/css">
.header {
	font: 28px Georgia, sans-serif;
	font-family: monotype corsiva;
	font-weight: bold;
	color: #3B0B2E;
}

.reserve {
	background-image: url("sr.jpg");
	background-repeat: no-repeat;
	background-size: 100% 250%;
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

table{
	border-collapse: collapse;
	font-family: monotype corsiva;
	font-size: 18px;
	font-weight: bold; 
	color: #3B0B2E;
}
</style>


<script type="text/javascript">
	function test(){
		var v = document.getElementById("seats").value;
		
		if(v.indexOf(".")>=0)
		{
			alert("Invalid no")
			return false;
		}
		v = parseInt(v);
		
		if(isNaN(v)){
			alert("Entered data is not a number. Enter integer value for no. of seats required.")
			return false;
		}
		if(v <= 0){
			alert("seat no should be greater than 0")
			return false
		}
			
		return true;
	}
</script>
</head>


<body class="reserve">
	<center>
		<h2 class="header">Ship Reservation</h2>
		<center>
			<form:form action="CustomerReserveShip.html" modelAttribute="reservationBean">
				<table border="0" width="30%" cellpadding="4">

					<tr height="10px">
						<td align = "left">Schedule Id:</td>
						
						<td>
							<form:select path="scheduleID" >
							<%
								java.util.ArrayList<String> s = (java.util.ArrayList<String>)request.getAttribute("scheduleIdList");
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
					<tr height = "8px"></tr>
					<tr height="30px">
						<td  align = "left">No. of seats:</td>
						<td><form:input path="noOfSeats" id = "seats"/></td>
					</tr>
					<tr height = "8px"></tr>
					<tr>
						<td></td>
						<td><input type="submit" value="Submit" id = "s" onclick="return test()"/></td>
					</tr>
					
				</table>
				
				</td>
			</form:form>

		</center>
	</center>
</body>
</html>