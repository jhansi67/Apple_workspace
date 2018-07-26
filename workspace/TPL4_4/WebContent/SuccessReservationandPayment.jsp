<%@page import="com.wipro.srs.bean.PassengerBean"%>
<%@page import="com.wipro.srs.bean.ReservationBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reservation Success</title>
<style type="text/css">
p{
	font-family: monotype corsiva;
	font-weight: bold;
	font-size: 20px;
}

#sp {
	font-family: monotype corsiva;
	font-size: 18px;
	font-weight: bold;
	width: 60px;
	height: 30px;
}

#sp:hover {
	background-color: #50A6C2;
	color: white;
}
</style>
</head>
<body>
	<center>
	
		<p>
			Congrats!!! Your reservation was successful<br> Note down your
			reservation id as you will require it to print your ticket.<br>
			You can also print or save your reservation details by clicking the print button at the bottom.<br><br>
			<b>Your Reservation details: </b>
		</p>
		
		<%
			ReservationBean lastReservation = (ReservationBean)request.getAttribute("lastReservation");
				java.util.ArrayList<PassengerBean> plist = (java.util.ArrayList<PassengerBean>)request.getAttribute("plist");
		%>
		<br>
		<table border="1" width="50%">
			<tr>
				<td><b>Reservation Id:</b></td>
				<td colspan = "2" align="center">
					<%
						out.print(lastReservation.getReservationID());
					%>
				</td>
			</tr>

			<tr>
				<td><b>Booking date:</b></td>
				<td colspan = "2" align="center">
					<%
						out.print(lastReservation.getBookingDate());
					%>
				</td>
			</tr>

			<tr>
				<td><b>Journey date:</b></td>
				<td colspan = "2" align="center">
					<%
						out.print(lastReservation.getJourneyDate());
					%>
				</td>
			</tr>

			<tr>
				<td><b>No. of seats:</b></td>
				<td colspan = "2" align="center">
					<%
						out.print(lastReservation.getNoOfSeats());
					%>
				</td>
			</tr>

			<tr>
				<td><b>Total fare:</b></td>
				<td colspan = "2" align="center">
					<%
						out.print(lastReservation.getTotalFare());
					%>
				</td>
			</tr>

			<tr>
				<td><b>Booking status:</b></td>
				<td colspan = "2" align="center">
					<%
						out.print(lastReservation.getBookingStatus());
					%>
				</td>
			</tr>
			
			<th>Name</th>
			<th>Age</th>
			<th>Gender</th>
			
			<% 
				for(int i=0;i<plist.size();++i){
			%>
				<tr>
					<td width = "50%" align="center">	<% out.print(plist.get(i).getName()); %>	</td>
					<td align="center">	<% out.print(plist.get(i).getAge()); %>		</td>
					<td align="center">	<% out.print(plist.get(i).getGender()); %>	</td>
				</tr>
			<%		
				}
			%>
		</table>
		<br>
		<input type="button" value="print" onclick="window.print()" id = "sp">
	</center>
</body>
</html>