<%@page import="java.util.Base64"%>

<%@page import="dto.ProductDto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<%ProductDto p=(ProductDto)request.getAttribute("products"); %>

<form  action="editproduct" method="post" enctype="multipart/form-data">

ProductId:<input type="text" name="User-Id" value="<%=p.getid()%>"readonly="true"><br>


ProductName:<input type="text" name="User-Product" value="<%=p.getProductName()%>"><br>

ProductPrice:<input type="text" name="User-price" value="<%=p.getprice()%>"><br>

ProductBrand:<input type="text" name="User-Brand" value="<%=p.getBrand()%>"><br>

ProductDiscount:<input type="text" name="User-Discount" value="<%=p.getdiscount()%>"><br>


<% String base64image=new String(Base64.getEncoder().encode(p.getimage())); %>
<img src="data:image/jpeg;base64,<%=base64image %>"height="100px" width="100px" src=""><br>

ProductImage:<input type="file" name="User-image"><br>

<input type="submit">

</form>

</body>
</html>