<%@page import="java.util.Base64"%>
<%@page import="dto.ProductDto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <title>Edit Product</title>

    <!-- Add your CSS styles here -->
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 300px;
            text-align: left;
        }

        input[type="text"], input[type="file"] {
            width: 100%;
            padding: 10px;
            margin: 8px 0;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        img {
            max-width: 100%;
            height: auto;
            margin-bottom: 10px;
            display: block;
        }

        input[type="submit"] {
            background-color: #4caf50;
            color: #fff;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <%ProductDto p=(ProductDto)request.getAttribute("products"); %>
    <form action="editproduct" method="post" enctype="multipart/form-data">
        ProductId: <input type="text" name="User-Id" value="<%=p.getid()%>" readonly><br>
        ProductName: <input type="text" name="User-Product" value="<%=p.getProductName()%>"><br>
        ProductPrice: <input type="text" name="User-price" value="<%=p.getprice()%>"><br>
        ProductBrand: <input type="text" name="User-Brand" value="<%=p.getBrand()%>"><br>
        ProductDiscount: <input type="text" name="User-Discount" value="<%=p.getdiscount()%>"><br>
        
        <% 
            byte[] imageBytes = p.getimage();
            String base64image = (imageBytes != null) ? Base64.getEncoder().encodeToString(imageBytes) : "";
        %>
        <img src="data:image/jpeg;base64,<%=base64image %>" height="100px" width="100px" alt=""><br>

        ProductImage: <input type="file" name="User-image"><br>
        <input type="submit">
    </form>

</body>
</html>
