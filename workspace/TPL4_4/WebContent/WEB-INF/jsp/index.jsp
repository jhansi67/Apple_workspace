<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Main page</title>
</head>
<frameset rows="10%,10%,70%,10%">
     <frameset cols="10%,90%">
       <frame src="logo.jsp" name="logo" frameborder="0"/>
       <frame src="header.jsp" name="header" frameborder="0"/>
      </frameset>
      <frameset>
       <frame src="about.jsp" name="footer" frameborder="0"/>
  </frameset>
        <frameset cols="50%,50%">
        <frame src="info.jsp" name="info" frameborder="0"/>
        <frame src="Login.jsp" name="login" frameborder="0"/>
      </frameset>
       <frame src="footer.jsp" name="footer" frameborder="0"/>
  </frameset>
</html>