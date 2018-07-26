<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
table {
	border-collapse: collapse;
	font-family: monotype corsiva;
	font-size: 18px;
	font-weight: bold;
	color: black;
	width: "100%";
	height: 400px;
}

.company {
	background-image: url("logo.jpg");
	background-repeat: no-repeat;
	background-size: 100% 100%;
	position: left top;
	height: 400px;
	display: inline-block;
	width: 350px;
	margin: 0px;
	padding: 0px;
	margin-bottom: 0px;
	padding-bottom: 0px;
}

.ticket {
	height: 400px;
	width: 405px;
	display: inline-block;
	margin-left: -10.6px;
	padding-left: -10px;
	margin-bottom: 0px;
	padding-bottom: 0px;
}

.ticketheader{
	font-family: monotype corsiva;
	font-size: 20px;
	font-weight: bold;
	color: #F7D358;
	
}
.bord{
	width: 755px;
	background-color: #0B173B;
	margin-right: 0px;
	padding-right: 0px;
	padding-top: 5px;
	padding-bottom: 0px;
	margin-bottom: 0px;
}
</style>

</head>




<body>
    <center>
        <h2>Print Ticket</h2></center>

	
	<div class = "bord">
	<center><h3 class = "ticketheader">INTEROCEAN  TICKET</h3></center>
		<div class = "company"></div>
		
		<div class = "ticket">
        <c:forEach items="${pticket}" var="entry">
            <table border="1" width="50%" cellpadding="3">
                <tr>
                    <td bgcolor="yellow"><b>Reservation Id:</b></td>
                    <td align="center" colspan="2"  bgcolor="white">${entry.key.reservationID}</td>
                </tr>

                <tr>
                    <td bgcolor="yellow"><b>Schedule Id</b></td>
                    <td align="center" colspan="2"  bgcolor="white">${entry.key.scheduleID}</td>
                </tr>

                <tr>
                    <td bgcolor="yellow"><b>Booking Date:</b></td>
                    <td align="center" colspan="2"  bgcolor="white">${entry.key.bookingDate}</td>
                </tr>

                <tr>
                    <td bgcolor="yellow"><b>Journey Date: </b></td>
                    <td align="center" colspan="2"  bgcolor="white">${entry.key.journeyDate}</td>
                </tr>

                <tr>
                    <td bgcolor="yellow"><b>Booking Status: </b></td>
                    <td align="center" colspan="2"  bgcolor="white">${entry.key.bookingStatus}</td>
                </tr>

                

                <th  bgcolor="orange">Name:</th>
                <th bgcolor="orange">Age:</th>
                <th bgcolor="orange">Gender:</th>

                <c:forEach var="a" items="${entry.value}">
                    <tr>
                        <td align="center"  bgcolor="white"><c:out value="${a.name}" />
                        <td align="center"  bgcolor="white"><c:out value="${a.age}" />
                        <td align="center"  bgcolor="white"><c:out value="${a.gender}" />
                    </tr>
                </c:forEach>



            </table>
        </c:forEach>
        </div>
	
</div>
       
       
 	<center><br /> <input type="submit" value="print" onClick="window.print()" />
    </center>
</body>
</html>