<%@page import="com.wipro.srs.bean.PassengerBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.wipro.srs.bean.ReservationBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirm Cancellation</title>
<style type="text/css">
.tab{
	border: 1;
	border-color: grey;
}

div{
	background : url('');
	width: 50%;
	padding-left: 0;
}

body{
	background: url('cn.jpg') no-repeat;	
	background-size: 100% 120%;
	background:rgba(255,255,255,0.5);
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
</head>
<body>

		<center>
		<div>
		<h2>Ticket Details:</h2>
		<table border="1">
		<%
			ReservationBean rbdetails = (ReservationBean)request.getAttribute("rbdetails");
			ArrayList<PassengerBean> pblistdetails =  (ArrayList<PassengerBean>)request.getAttribute("pblistdetails");
		%>
	
		<tr >
			<td width="50%"><b>Reservation Id: </b></td>
			<td colspan="2"> <% out.println(rbdetails.getReservationID()); %> </td>
		</tr>
	
		<tr>
			<td width="50%"><b>Total Fare : </b></td>
			<td colspan="2"> <% out.println(rbdetails.getTotalFare()); %> </td>
		</tr>
	
		<tr>
			<td width="50%"><b>Booking Status : </b></td>
			<td colspan="2"> <% out.println(rbdetails.getBookingStatus()); %> </td>
		</tr>
	
		<tr>
			<td  width="50%"><b>No. of seats: </b></td>
			<td colspan="2"> <% out.println(rbdetails.getNoOfSeats()); %> </td>
		</tr>
	
		<tr>
			<td width="50%"><b>Booking Date: </b></td>
			<td colspan="2"> <% out.println(rbdetails.getBookingDate()); %> </td>
		</tr>
	
		<tr>
			<td width="50%"><b>Journey Date: </b></td>
			<td colspan="2"> <% out.println(rbdetails.getJourneyDate()); %> </td>
		</tr>
		
		
		<th>Name</th>	
		<th>Age</th>	
		<th>Gender</th>	
		
		<%	
			for(int i=0;i<pblistdetails.size();++i){
		%>
		<tr>
			<td align="center">	<%out.print(pblistdetails.get(i).getName()); %>		</td>
			<td align="center">	<%out.print(pblistdetails.get(i).getAge()); %>		</td>
			<td align="center">	<%out.print(pblistdetails.get(i).getGender()); %>	</td>
		</tr>		
		<%	
			}
		%>
		</table>
	</div>
	
	<div >
	<br><br><b>
		Total Refundable amount = <% out.print(rbdetails.getTotalFare());%><br>
	<br>	
		Are you sure sure you want to cancel the ticket? <br>
		
		<form action = "cancelTicket.html">
		<table border="0" width="67%">
		<tr>
			<td><input type="radio" name = "confirmoption" value = "Yes" required/>Yes</td>
			<td><input type="radio" name = "confirmoption" value = "No" required/>No</td>
			<td><input type="submit" name = "submit" value = "Submit" id="s"/></td>
		</tr>
		</table>
		</form>
	</div>
	</font></b>
	</center>
</body>
</html>