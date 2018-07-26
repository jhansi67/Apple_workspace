<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JAHA marks Chahiye wala JSP</title>
</head>
<body>
<h2>Failed</h2>
				
				<form action="ScheduleInterview.html" method="post">
						<table>
							<c:forEach items="${studList}" var="entry">
								<tr>
									<td>${entry.key}</td>
									<td>${entry.value}</td>
									<td><input type="checkbox" name="stinlist" value="${entry.key}"></td>
								</tr>
							
							</c:forEach>
					</table>		
							
				<input type="submit">
				</form>
				



</body>
</html>