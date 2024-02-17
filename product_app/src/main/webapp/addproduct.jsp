<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Product Form</title>

    <!-- Add CSS styles -->
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        form {
            width: 50%;
            margin: 20px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        input[type="text"], input[type="file"] {
            width: 100%;
            padding: 8px;
            margin: 8px 0;
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color: #4caf50;
            color: #fff;
            padding: 10px 15px;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>

    <form action="addproduct" method="post" enctype="multipart/form-data">
        ProductId: <input type="text" name="User-Id"><br>
        ProductName: <input type="text" name="User-Product"><br>
        ProductPrice: <input type="text" name="User-price"><br>
        ProductBrand: <input type="text" name="User-Brand"><br>
        ProductDiscount: <input type="text" name="User-Discount"><br>
        ProductImage: <input type="file" name="User-image"><br>
        <input type="submit">
    </form>

</body>
</html>
