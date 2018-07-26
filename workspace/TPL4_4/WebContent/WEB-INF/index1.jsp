<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Main page</title>
</head>
<frameset rows="12.5%,6.5%,*,5%">
     <frameset cols="17%%,*">
       <frame src="logo.jsp" name="logo" noresize="noresize" scrolling="no"/>
       <frame src="AdminHomePageTitle.jsp" name="header" noresize="noresize" scrolling="no"/>
      </frameset>
      <frameset>
       <frame src="about.jsp" name="footer" noresize="noresize" scrolling="no"/>
  </frameset>
        <frameset cols="50%,50%">
        <frame src="info.jsp" name="info" noresize="noresize" scrolling="no"/>
        <frame src="Login.jsp" name="login" noresize="noresize" scrolling="no"/>
      </frameset>
       <frame src="AdminCopyRight.jsp" name="footer" noresize="noresize" scrolling="no"/>
  </frameset>
</html>