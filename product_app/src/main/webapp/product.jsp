<%@page import="java.util.Base64"%>
<%@page import="dto.ProductDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<a href="addproduct.jsp"><input type="button" value="ProductAdd"></a>
<br>
<%String message=(String)request.getAttribute("message"); %>
<%if(message!=null){ %>
<%=message %>
<%} %>







<table border="2px">

<tr>

<th>id</th>
<th>ProductName</th>
<th>price</th>
<th>Brand</th>
<th>discount</th>
<th>image</th>
<th>edit</th>
<th>delete</th>
</tr>


<% List<ProductDto> products=(List)request.getAttribute("products"); %>
<%for(ProductDto p: products){ %>
<tr>
<td><%=p.getid() %></td>
<td><%= p.getProductName()%></td>
<td><%=p.getprice() %></td>
<td><%=p.getBrand() %></td>
<td><%=p.getdiscount() %></td>
<% String base64image=new String(Base64.getEncoder().encode(p.getimage())); %>
<td><img src="data:image/jpeg;base64,<%=base64image %>"height="100px" width="100px" src=""></td>
<td><a href="edit?id=<%=p.getid() %>">edit</a></td>
<td><a href="delete?id=<%=p.getid() %>">delete</a></td>
</tr>
<%}%>

</table>
<a href="logout"><input type="button" value="Logout"></a>

</body>
</html>