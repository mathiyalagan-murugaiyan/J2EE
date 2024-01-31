<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="welcome" method="post">

<a href="login.jsp" ><input type="button" value="LOGIN"></a>
<br>

<%String message=(String)request.getAttribute("message"); %>
<%if(message!=null){ %>
<h3><%= message %></h3>
<%} %>
<a href="signup.jsp"><input type="button" value="SIGNUP"> </a>

</form>

</body>
</html>