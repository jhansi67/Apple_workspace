<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css"/>
<title>Ship Details</title>

<script type="text/javascript">
	var selectedSource;
	var destinations;
	var selectedDestination;
	
	function findDestinations() {
		//		alert('cjb')
		if (window.XMLHttpRequest) {
			req = new XMLHttpRequest();
		} else if (window.ActiveXObject)//for IE
		{
			req = new ActiveXObject("Microsoft.XMLHTTP");
		}
		selectedSource = document.getElementById("select").value;
	//	alert('aa'+selectedSource);
	//	alert(selectedSource);
	
		var url = "findDestnations.html?selectedSource=" + selectedSource;
	//	alert('1');
		req.onreadystatechange = getResponseAllBooks;
	//	alert('2');
		req.open("POST", url, true);//send request to server
	//	alert('3');
		req.send(null);
	//	alert('4');
	}

	function getResponseAllBooks() {
	//	alert('5');
		if (req.readyState == 4) //if request is complete
		{
		//	alert('6');
			if (req.status == 200) //if target page is found
			{
				destinations = req.responseText.toString();
			//	alert(destinations.toString());
				
				destinationSelect = document.getElementById('destination');
				destinationSelect.length=0;
			//	destinationSelect.options[destinationSelect.options.length] = new Option("---Select One---", 'None');
				words = destinations.split(" ");
			//	alert('words prepared...');
				
				for(var i=1;i<words.length;++i){
					destinationSelect.options[destinationSelect.options.length] = new Option(words[i], words[i]);
				}			
			}
		}
	}
	
	function testDestination(){
		destinationSelect = document.getElementById('destination').value;
		//alert(destinationSelect);
		
		if(destinationSelect ==null || destinationSelect == "" || destinationSelect == " ")
		{	alert("Please select your destination");
			return false;
		}
	}
</script>

<style type="text/css">
select {
	font-family: monotype corsiva;
	font-size: 18px;
	font-weight: bold;
	width: 180px;
	height: 20px;
	background-color: #50A6C2;
}

.header {
	font: 20px monotype corsiva;
	color: #4B088A;
	font-weight: bold;
	font-size: 30px;
}

.reserve {
	background-image: url("OCEAN_SHIELD.jpg");
	background-repeat: no-repeat;
	background-size: 100% 340%;
}

#s {
	font-family: monotype corsiva;
	font-size: 18px;
	font-weight: bold;
	width: 70px;
	height: 25px;
}

#s:hover {
	background-color: #50A6C2;
	color: white;
}
select{
	background: url('');
	width: 145px;
	height: 20px;
	align: center;
	text-align: center;
}
table {
	font-family: monotype corsiva;
	font-weight: bold;
	width : 50%;
}
date{
	
	background: url('');
}
</style>
</head>


<body class="reserve">
	<center>
		<font class="header"> <u>Ship Details</u>
		</font> <br /> <br />
		<form:form action="ViewShipScheduleDetails.html"
			modelAttribute="routeBean">
			<table border="1" cellpadding="2">
				<tr>
					<td width="30%">Source:</td>
					<td width="70%"><form:select path="source" onblur="viewAllBooks()" id="select" onchange="findDestinations()">
							<%
								ArrayList<String> s = (ArrayList<String>)request.getAttribute("source");
													for(int i=0;i<s.size();++i){
														String sourcename = s.get(i);
														System.out.println(sourcename);
							%>
							<form:option value = "<%=sourcename%>"><%=sourcename%></form:option>

							<%
								}
							%>
						</form:select>
						<form:errors path="source" color="red"></form:errors>
						</td>
				</tr>

				<tr>
					<td width="30%">Destination</td>
					<td width = "70%">
						<form:select path="destination" name="destination" id = "destination" onfocus="findDestinations()">	
						</form:select>
						<form:errors path="destination"></form:errors>
					</td>
				</tr>

				

				<tr>
					<td></td>

					<td><input type="submit" value="Submit" id="s" onclick=" return testDestination()"/></td>

				</tr>
			</table>

		</form:form>


	</center>
</body>
</html>