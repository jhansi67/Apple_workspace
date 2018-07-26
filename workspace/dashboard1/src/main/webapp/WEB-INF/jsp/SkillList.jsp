<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Adding skills</title>
</head>
<body>
	 <form:form action="skill.html" method="POST"
			modelAttribute="skillBean" >
                                       
 		Enter the skill:	<form:input path="skillName" ></form:input>
 		Corresponding Id:	<form:input path="skillId" ></form:input>
 			<br>
 			<br>
 			<br>
 		
 			
 			<input type="submit" value="Submit">
			 
	</form:form> 
	
	
</body>
</html>