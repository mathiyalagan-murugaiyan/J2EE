<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<form  action="addproduct" method="post" enctype="multipart/form-data">

ProductId:<input type="text" name="User-Id"><br>


ProductName:<input type="text" name="User-Product"><br>

ProductPrice:<input type="text" name="User-price"><br>

ProductBrand:<input type="text" name="User-Brand"><br>

ProductDiscount:<input type="text" name="User-Discount"><br>

ProductImage:<input type="file" name="User-image"><br>

<input type="submit">



</form>
</body>
</html>