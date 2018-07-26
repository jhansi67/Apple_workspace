<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import = "java.util.ArrayList"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css"/>
  
  
  <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
  <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>
 
 
 
 
 <!--  --><!--  --><!--  --><!--  --><!--  --><!--  --><!--  --><!--  -->

<!--  --><!--  --><!--  --><!--  --><!--  --><!--  --><!--  --><!--  -->

<script language="javascript" type="text/javascript" src="datetimepicker.js">
	//Date Time Picker script- by TengYong Ng of http://www.rainforestnet.com
	//Script featured on JavaScript Kit (http://www.javascriptkit.com)
	//For this script, visit http://www.javascriptkit.com
</script>
</head>
<body>
	

<!--  --><!--  --><!--  --><!--  --><!--  --><!--  --><!--  --><!--  -->

<!--  --><!--  --><!--  --><!--  --><!--  --><!--  --><!--  --><!--  -->
 
 
 
 
 
 
 
 
  <script>
  $(document).ready(function() {
    $("#sd").datepicker({ maxDate: new Date(2016,12,31), minDate: 0 , changeMonth: true,  
        changeYear: true});
  });
  </script>
  
  
  
<title>Add schedule</title>
<style type="text/css">
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
#s4{
	font-family: monotype corsiva;
	font-size: 18px;
	font-weight: bold;
	width: 110px;
	height: 30px;
	
}
#s4:hover{
	color: white;
}

select{
	background-color: WHITE;
}
</style>
</head>
<body>
<br><br><br><br>
	<form:form action="schedule_add.html" modelAttribute="sb" align="center">
		<table align="center" cellspacing="2" cellpadding="10">
			<tr>
				<td colspan="3">Enter Ship id:</td>
				<td>
					<form:select path="shipID">
						<%
							ArrayList<String> s = (ArrayList<String>)request.getAttribute("shipIds");
													for(int i=0;i<s.size();++i){
														String sourcename = s.get(i);
														System.out.println(sourcename);
						%>
							<form:option value = "<%=sourcename%>"><%=sourcename%></form:option>

						<%
							}
						%>
					</form:select>
				</td>
				<td><form:errors path="shipID"></form:errors></td>
			    
			</tr>
			
			<tr>
				<td colspan="3">Enter Route id:</td>
				<td>
					<form:select path="routeID">
						<%
							ArrayList<String> s2 = (ArrayList<String>)request.getAttribute("routeIds");
													for(int i=0;i<s2.size();++i){
														String sourcename = s2.get(i);
														System.out.println(sourcename);
						%>
							<form:option value = "<%=sourcename%>"><%=sourcename%></form:option>

						<%
							}
						%>
					</form:select>
				</td>
				<td><form:errors path="routeID"></form:errors></td>
				
			</tr>
			<tr>
				<td colspan="3">Enter Start date:</td>
				<td><form:input path="startDate" id="demo1" readonly="true"/></td>
				
				<td>
					<a href="javascript:NewCal('demo1','ddmmmyyyy',true,24)">
						<img src="cal.gif" width="16" height="16" border="0" alt="Pick a date">
					</a>
				</td>	
					
				
				<td><form:errors path="startDate"></form:errors></td>
				
			</tr>
			<tr>
				<td></td>
				<td colspan="3" align="center"><input type="submit" id="s4" value="Add Schedule" /></td>
				
			</tr>
		</table>
	</form:form>

</body>
</html>