<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="login" method="post">

<%String message=(String)request.getAttribute("message"); %>
<%if(message!=null){ %>
<%= message %>
<%} %>
<br>
Email:<input type="text" name="User-Email">
<br>
Password:<input type="text" name="User-Password">
<br>
<input type="submit">

</form>

</body>
</html>