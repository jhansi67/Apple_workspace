<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

</head>
<body>
 <div align="center">
        <h1>Spring MVC - Hibernate File Upload to Database Demo</h1>
        <form  action="upload.html" enctype="multipart/form-data" method="post">
            <table border="0">
                <tr>
                    <td>Pick file #1:</td>
                    <td><input type="file" name="fileUpload"/></td>
                </tr>
               
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Upload" /></td>
                </tr>
            </table>
        </form>
        <img src="${img}"/>
    </div>


</body>


</html>
    
       