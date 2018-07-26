<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Route</title>

<style type="text/css">
table {
	border-collapse: collapse;
	font-family: monotype corsiva;
	font-size: 18px;
	font-weight: bold;
}

body {
	background-image: url("ship4.jpg");
	background-repeat: no-repeat;
	background-size: 100% 200%;
}

#s8 {
	font-family: monotype corsiva;
	font-size: 18px;
	font-weight: bold;
	width: 110px;
	height: 30px;
}

#s8:hover {
	background-color: #50A6C2;
	color: white;
}

.errors {
	color: red;
}
</style>


<script type="text/javascript">
	var places = ["","Maharashtra","Gujrat","Kerala","TaminNadu","West Bengal","AndhraPradesh"];
	/*
	function findDestinations(){
		
		var source = document.getElementById("source").value;
		
		destination = document.getElementById("destination");
		destination.length = 0;
	//	alert("source="+source+" destination"+destination);
		
		for(var i=0;i<places.length;++i){
			
			if(places[i] == source)
				continue;
			
			destination.options[destination.options.length] = new Option(places[i], places[i]);
		}
	}
	
	*/
	
	function test(i){
		var v = document.getElementById(i).value;
		
		v = parseFloat(v);
		
		if(isNaN(v)){
			alert("Entered data is not a number. Enter integer value for fare.")
			return false;
		}
		if(v <= 0){
			alert("Should be greater than 0")
			return false
		}
			
		return true;
	}
	
	
	function testText(i){
		var v = document.getElementById(i).value;
		v = parseFloat(v)
	//	alert(v)
		
		if(!isNaN(v) || v==null || v==""){
			alert("Numbers are not allowed in source and destination")
			return false;
		}
		
		return true;
	}
</script>

</head>



<body>
	<br>
	<br>
	<br>
	<br>
	<form:form action="AddRoute.html" modelAttribute="AddRoute"
		align="center">
		<table align="center" cellspacing="2" cellpadding="10">


			<tr>
				<td colspan="3">Enter Source:</td>
				<td>
					<form:input path="source" name = "source" id="source" onblur = "return testText(this.id)"/>
				
				</td>
				<td><form:errors path="source" class="errors"></form:errors></td>
			</tr>
			
			
			

			<tr>
				<td colspan="3">Enter Destination:</td>
				<td>
					<form:input path="destination" name = "destination" id ="destination" onblur = "return testText(this.id)"/>
					
				</td>
				<td><form:errors path="destination" class="errors"></form:errors></td>
			</tr>




			<tr>
				<td colspan="3">Enter Travel Duration:</td>
				<td><form:input path="travelDuration" id = "1" onblur="return test(this.id)" placeholder  = "Enter duration in hours"/></td>
				<td><form:errors path="travelDuration" class="errors"></form:errors></td>
			</tr>

			<tr>
				<td colspan="3">Enter Fare:</td>
				<td><form:input path="fare" id = "2" onblur="return test(this.id)"/></td>
				<td><form:errors path="fare" class="errors"></form:errors></td>
			</tr>

			<tr>
				<td></td>
				<td colspan="3" align="center"><input type="submit" id="s8"
					value="Add" /></td>
			</tr>

		</table>
	</form:form>
</body>
</html>