<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<frameset rows="12.5%,6.5%,*,5%" name = "fs1">

	<frameset cols="17%,*" >
		<frame name="NO1_LEFT" src="logo.jsp" noresize="noresize"/>
		<frame name="NO1_RIGTH" src="AdminHomePageTitle.jsp" noresize="noresize" scrolling="no"/>
	</frameset>


	<frameset cols="27%,*">
		<frame name="NO2_LEFT" src ="loggeduser.jsp" noresize="noresize"/>
		<frame name="NO2_RIGHT" src="AdminHomeLogout.jsp" noresize="noresize" scrolling="no"/>
	</frameset>


	<frameset cols="22%,*">
		<frame name="NO3_LEFT" src = "adminnavigationlist.jsp" noresize="noresize"/>
		<frame name="NO3_RIGHT"  src="photo.jsp" noresize="noresize" scrolling="yes"/>
	</frameset>


	<frameset cols="100%">
		<frame name="NO4" src = "AdminCopyRight.jsp" noresize="noresize" scrolling="no"/>
	</frameset>



</frameset>

</html>