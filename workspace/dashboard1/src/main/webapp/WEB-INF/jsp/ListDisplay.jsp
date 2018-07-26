<%@page import="com.dashboard.beans.StudentSkillBean"%>
<%@page import="com.dashboard.beans.SkillBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<script>
function myFunction() {
	
	
    
    document.getElementById("mySelect2").innerHTML=document.getElementById("mySelect1").innerHTML;
    var y=document.getElementById("mySelect1");
    var x = document.getElementById("mySelect2");
    x.remove(y.selectedIndex);
    
}

function myFunction1() {
	/* alert('in function1'); */
	
    
    document.getElementById("mySelect3").innerHTML=document.getElementById("mySelect1").innerHTML;
    var y=document.getElementById("mySelect1");
    var a = document.getElementById("mySelect2");
    var x=document.getElementById("mySelect3");
    if(x!="Select the correct option"){
    document.getElementById("mySelect3").innerHTML=document.getElementById("mySelect1").innerHTML;x.remove(y.selectedIndex);
    x.remove(a.selectedIndex);
    return true;
    }
    else
    	return false;
}


function myCheck(){
	
		var y=document.getElementById("mySelect1").value;
	    var a = document.getElementById("mySelect2").value;
	    var x=document.getElementById("mySelect3").value;
		var sq=0
	    
		if(y==="Select the correct option"||x==="Select the correct option"||a==="Select the correct option"){
			sq=1
			document.getElementById("s7").disabled = true;
			}
		else
			document.getElementById("s7").disabled = false;
	
	
}
</script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Array list Wala Jsp</title>
</head>
<body>
<h1>Enter the required skill set</h1>
<h2>${skillBean1}</h2>
<form:form action="showSkill.html" modelAttribute="skillBean1" method="GET" >
<table align="center" cellspacing="2" cellpadding="10">
			<tr>
				<td>Priority 1 :</td>
				

				<td>
					<form:select path="skillName" onclick="return myFunction()" id="mySelect1" >
					<form:option value="Select the correct option" id="priority1" >
								
							</form:option>
						<%
								java.util.ArrayList<SkillBean> s = (java.util.ArrayList<SkillBean>)request.getAttribute("ssb");
														for(int i=0;i<s.size();++i){
															String sn = s.get(i).getSkillName();
							%>

							<form:option value="<%=sn%>" id="priority1" >
								<%=sn%>
							</form:option>

							<%
								}
							%>
					</form:select>
				</td>
				
				<td>Priority 2 :</td>
				
				<td>
					<form:select path="skillName" id="mySelect2" onclick="return myFunction1()" onchange="myCheck()">
						<%
								java.util.ArrayList<SkillBean> s = (java.util.ArrayList<SkillBean>)request.getAttribute("ssb");
														for(int i=0;i<s.size();++i){
															String sn = s.get(i).getSkillName();
							%>

							<form:option value="<%=sn%>">
								<%=sn%>
							</form:option>

							<%
								}
							%>
					</form:select>
				</td>
				
				<td>Priority 3 :</td>
				
				<td>
					<form:select path="skillName" id="mySelect3" onchange="myCheck()">
						<%
								java.util.ArrayList<SkillBean> s = (java.util.ArrayList<SkillBean>)request.getAttribute("ssb");
														for(int i=0;i<s.size();++i){
															String sn = s.get(i).getSkillName();
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
			<tr>
				<td></td>
				<td><input type="submit" id="s7" value="Submit" onmouseover="myCheck()"/></td>
			</tr>
		</table>
		</form:form>
	
</body>
</html>