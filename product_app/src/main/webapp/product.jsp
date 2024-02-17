<%@page import="java.util.Base64"%>
<%@page import="dto.ProductDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Product List</title>

    <!-- Add CSS styles -->
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        th, td {
            padding: 10px;
            border: 1px solid #ddd;
            text-align: left;
        }

        th {
            background-color: #4caf50;
            color: #fff;
        }

        img {
            max-width: 100px;
            max-height: 100px;
        }

        a {
            text-decoration: none;
            padding: 5px 10px;
            background-color: #4caf50;
            color: #fff;
            border-radius: 3px;
        }

        a:hover {
            background-color: #45a049;
        }

        input[type="button"] {
            padding: 5px 10px;
            background-color: #4caf50;
            color: #fff;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }

        input[type="button"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>

    <a href="addproduct.jsp"><input type="button" value="Product Add"></a>
    <br>
    
    <% String message=(String)request.getAttribute("message"); %>
    <% if(message != null) { %>
        <%= message %>
    <% } %>

    <table border="2px">
        <tr>
            <th>id</th>
            <th>Product Name</th>
            <th>Price</th>
            <th>Brand</th>
            <th>Discount</th>
            <th>Image</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>

        <% List<ProductDto> products=(List)request.getAttribute("products"); %>
        <% for(ProductDto p: products) { %>
            <tr>
                <td><%= p.getid() %></td>
                <td><%= p.getProductName() %></td>
                <td><%= p.getprice() %></td>
                <td><%= p.getBrand() %></td>
                <td><%= p.getdiscount() %></td>
                <% String base64image = new String(Base64.getEncoder().encode(p.getimage())); %>
                <td><img src="data:image/jpeg;base64,<%= base64image %>" alt="Product Image"></td>
                <td><a href="edit?id=<%= p.getid() %>">Edit</a></td>
                <td><a href="delete?id=<%= p.getid() %>">Delete</a></td>
            </tr>
        <% } %>
    </table>

    <a href="logout"><input type="button" value="Logout"></a>

</body>
</html>
