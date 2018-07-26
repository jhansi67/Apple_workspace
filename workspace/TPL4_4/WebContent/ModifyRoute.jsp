<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
table{
	border-collapse: collapse;
	
	font-family: monotype corsiva;
	font-size: 18px;
	font-weight: bold; 

}
body{
background-image: url("ship4.jpg");
background-repeat: no-repeat;
background-size: 100% 200%;
}
#s14{
	font-family: monotype corsiva;
	font-size: 18px;
	font-weight: bold;
	width: 70px;
	height: 30px;
	
}
#s14:hover{
	background-color: #50A6C2;
	color: white;
}
</style>
</head>
<body>
<br><br><br>
<form:form action="ModifyRoute.html" modelAttribute="ModifyRoute">
<table align=center cellspacing="2" cellpadding="10">

   
   <tr>
    <td colspan="2">Enter RouteId</td>
    <td><form:input path="routeID" value='<%= request.getParameter("value") %>' readOnly="true"/></td>
   </tr>
   
    <tr>
    <td colspan="2">Enter Source</td>
     <td><form:input path="source" value='<%= request.getParameter("value1") %>'/></td>
   </tr>
   
    <tr>
    <td colspan="2">Enter Destination</td>
    <td><form:input path="destination" value='<%= request.getParameter("value2") %>'/></td>
   </tr>
  
   <tr>
    <td colspan="2">Enter Travel Duration</td>
    <td><form:input path="travelDuration" value='<%= request.getParameter("value3") %>'/></td>
   </tr>
  
   <tr>
    <td colspan="2">Enter Fare</td>
     <td><form:input path="fare"  value='<%= request.getParameter("value4") %>'/></td>
    
   </tr>
 
   <tr>
   <td></td>
     <td colspan="2" align="center"><input type="submit" id="s14" value="Modify"/></td>
     </tr>
   
   </table>
   </form:form>
</body>
</html>