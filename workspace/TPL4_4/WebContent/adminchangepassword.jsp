<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function validateForm() {
		var x = document.f1.newpassword.value;
		var y = document.f1.confirmpassword.value;
		var z=  document.f1.password.value;
		if(z.length==0){
			alert("Password must be entered");
			document.f1.password.focus();
			return false;
		}
		if(x.length==0){
			alert("New Password must be entered");
			document.f1.newpassword.focus();
			return false;
		}
		if(y.length==0){
			alert("Password must be confirmed");
			document.f1.confirmpassword.focus();
			return false;
		}
		if(x!=y){
			alert("Confirmed password must be same as new password");
			return false;
		}
		return true;
	}
</script>
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
#s15{
	font-family: monotype corsiva;
	font-size: 18px;
	font-weight: bold;
	width: 140px;
	height: 30px;
	
}
#s15:hover{
	background-color: #50A6C2;
	color: white;
}
</style>

</head>
<body>
<br><br><br>
<form action="Login.jsp" align="center" method="post" name="f1" onsubmit="return validateForm()" target="_top">
<table align="center" cellspacing="2" cellpadding="10">
<tr>
<td colspan="2">Enter old password:</td>
<td ><input type="password" name="password"/> </td>
</tr>
<tr>
<td colspan="2">Enter new password:</td>
<td ><input type="password" name="newpassword"/> </td>
</tr>
<tr>
<td colspan="2">Confirm password:</td>
<td ><input type="password" name="confirmpassword"/> </td>
</tr>
<tr>
   <td></td>
     <td colspan="2" align="center"><input type="submit" id="s15" value="Change Password" target="_top"/></td>
     </tr>
</table>
</form>
</body>
</html>