<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style>
body {
	background: url("res.jpg") no-repeat;
	background-size: cover; 
}

h1 {
	color: blue;
	font-family: Times New Roman;
	font-style: italic;
	font-size: 300%;
}

.registration {
	width: 500px;
	color: #818181;
	border: 2px solid #ccc;
	padding-left: 30px;
	padding-top: 20px;
	padding-bottom:5px;
	font-family: Georgia;
	font-size: 14px;
	-moz-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.5);
	-webkit-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.5);
	-moz-border-radius: 15px;
	-webkit-border-radius: 15px;
	color: white;
	background: black;
	
}
</style>


<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>

<script type="text/javascript">

$(document).ready(function() {
  $("#d").datepicker({ maxDate: new Date(), minDate: new Date(1947, 5, 13) , changeMonth: true,  
      changeYear: true});
});


function sendRequest(value){
	
	if (window.XMLHttpRequest) 
	{
		req = new XMLHttpRequest( );
	}
	else if (window.ActiveXObject)//for IE
	{
		req = new ActiveXObject("Microsoft.XMLHTTP");
	}
			
	var url = "validEmailInfo.html?emailID="+value;
	req.onreadystatechange = getResponse;
	req.open("GET", url, true);//send request to server
	req.send(null);

}


///////////////////////////////////////////////////////////////////////////////////////
///////////////////////////			GET_RESPONSE		//////////////////////////////////
function getResponse()
{
	
	if (req.readyState==4) //if request is complete
	{
		if (req.status == 200) //if target page is found
		{
			//write the response text in the div area
			document.getElementById("1").innerHTML = req.responseText;
		}
		
		
			
	}
}

function emailSubmit(){
	
	var x=document.getElementById("1").innerHTML;
	
	if(x=="VALID")
		return true;
	else{
		
		alert('Enter an unregistered Email');
		return false;
	
	}
}


								/////////Javascript for City and State

								
								
	function viewAllCity(){
	

	stateSelect=document.getElementById('state').value;

	
	
	if(stateSelect=='Lakshwdeep')
		{
		city="Lakshadweep";
		citySelect=document.getElementById('city');
		
		words = city.split(" ");
		//alert(words.length);
		citySelect.length=0;	
			for(var i=0;i<words.length;++i){
				//alert(words[i]);
				citySelect.options[citySelect.options.length] = new Option(words[i], words[i]);
			}
		}
	else
	if(stateSelect=='Karnataka'){
		city="Bagalkot Bangalore Rural Bangalore Urban Mysore Raichur Ramnagara Shimoga Tumkur Udupi Uttara Kannada Yadgir";
		citySelect=document.getElementById('city');
		words = city.split(" ");
		
		//alert(words.length);
		citySelect.length=0;	
			for(var i=0;i<words.length;++i){
				//alert(words[i]);
				citySelect.options[citySelect.options.length] = new Option(words[i], words[i]);
			}
	}else
		if(stateSelect=='WestBengal'){
			city="Kolkata Bankura Birbhum Burdwan CoochBehar Dakshin Dinajpur Darjeeling Hooghly Howrah Jalpaiguri Kolkata	Malda Murshidabad Nadia North 24 Parganas Paschim Medinipur Purba Medinipur Purulia	South 24Parganas UttarDinajpur Haldia";
			citySelect=document.getElementById('city');
			words = city.split(" ");
			//alert(words.length);
			citySelect.length=0;
				for(var i=0;i<words.length;++i){
					//alert(words[i]);
					citySelect.options[citySelect.options.length] = new Option(words[i], words[i]);
				}
		}
		else
			if(stateSelect=="Andman and Nicobar"){
			
			city="Nicobar NorthAndaman MiddleAndaman SouthAndaman";
			citySelect=document.getElementById('city');
			words = city.split(" ");
			//alert(words.length);
			citySelect.length=0;
				
				for(var i=0;i<words.length;++i){
					//alert(words[i]);
					citySelect.options[citySelect.options.length] = new Option(words[i], words[i]);
				}
		}
			 else
				{
					city="Ahmedabad Amreli Anand Aravalli Banaskantha Bharuch Bhavnagar Botad ChhotaUdepur Dahod Dangs Devbhoomi Dwarka Gandhinagar GirSomnath Jamnagar Junagadh Kachchh Kheda Mahisagar Mehsana Morbi Narmada Navsari Panchmahal Patan Porbandar Rajkot";
					citySelect=document.getElementById('city');
					words = city.split(" ");
					//alert("Gujrat");
					citySelect.length=0;
						
						for(var i=0;i<words.length;++i){
							//alert(words[i]);
							citySelect.options[citySelect.options.length] = new Option(words[i], words[i]);
						} 	
					
					
				
	
	
	
	}
}


</script>

</head>

<body>
	<center>
		<h1>Registration Form</h1>

		<form:form action="addInfo.html" method="POST"
			modelAttribute="profileBean" class="registration">
			<table cellspacing="4" width="80%">
				<tr>
					<td>Your First Name:</td>

					<td><form:input path="firstName" /></td>
					<td><form:errors path="firstName"></form:errors></td>
				</tr>

				<tr>
					<td>Your Last Name:</td>

					<td><form:input path="lastName"></form:input></td>
					<td><form:errors path="lastName"></form:errors></td>
				</tr>

				<tr>
					<td>Email Id</td>

					<td><form:input path="emailID" onblur= "return sendRequest(this.value)" id="emailID" /> <div id = "1" ></div> </td>
					<td><form:errors path="emailID"></form:errors></td>
					 
				</tr>

				
				<tr>
					<td>Date of Birth</td>

					<td><form:input path="dateOfBirth" id="d"  placeholder="dd-mm-yyyy"></form:input></td>
					<td><form:errors path="dateOfBirth"></form:errors></td>
				</tr>

				<tr>
					<td>Gender</td>

					<td>Male<form:radiobutton path="gender" value="male"></form:radiobutton>
						Female<form:radiobutton path="gender" value="female"></form:radiobutton>
					</td>

				</tr>


				<tr>
					<td>Mobile Number</td>

					<td><form:input path="mobileNo"></form:input></td>
					<td><form:errors path="mobileNo"></form:errors></td>
				</tr>

				<tr>
					<td>Password</td>

					<td><form:password path="password"></form:password></td>
					<td><form:errors path="password"></form:errors></td>
				</tr>

				<tr>
					<td>Location</td>

					<td><form:input path="location"></form:input></td>
					<td><form:errors path="location"></form:errors></td>
				</tr>

				<tr>
					<td>Pincode</td>

					<td><form:input path="pincode"></form:input></td>
					<td><form:errors path="pincode"></form:errors></td>
				</tr>

				<tr>
					<td>State</td>

					 <td><form:select path="state"  id="state" onchange="viewAllCity()"> 
					 <form:option value="">Select State</form:option>
					<%
					java.util.ArrayList<String> state=new ArrayList();
					
					state.add(0,"Lakshwdeep");
					state.add(1,"Andman and Nicobar");
					state.add(2,"Gujrat");
					state.add(3,"WestBengal");
					state.add(4,"Karnataka");
					
					
					
					for(int i=0;i<state.size();++i){
						String sn = state.get(i);
					%>

					<form:option value="<%=sn%>">
					<%=sn%>
					</form:option>

					<%
					}
					%>

					</form:select></td>
					<td><form:errors path="state"></form:errors></td>
					
					<tr>
					<td>City</td>

					<td><form:select path="city" id="city" name="city" >
					<form:option value="">Select City</form:option>
					</form:select></td>
					<td><form:errors path="city"></form:errors></td>
				</tr>
					
					
				</tr>

				<tr>
					<td>Street</td>

					<td><form:input path="street"></form:input></td>
					<td><form:errors path="street"></form:errors></td>
				</tr>

				<tr>
					<td></td>
					<td><input type="submit" value="submit" onclick="return emailSubmit()" ></td>
				</tr>
			</table>

		</form:form>



	</center>
</body>

</html>