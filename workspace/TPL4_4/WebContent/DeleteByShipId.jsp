<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form:form action="DeleteByShipId.html" modelAttribute="DeleteByShipId">
<table align=center>
  <tr>
    <td>Enter Ship Id whose details are to be deleted
   </tr>
   
   <tr>
     <td><form:input path="shipId"/></td>
   </tr>
   
   <tr>
     <td><input type="submit" value="Delete"/></td>
     </tr>
   </table>
   </form:form>
</body>
</html>