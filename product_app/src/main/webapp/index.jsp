<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <title>Login Page</title>

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
            text-align: center;
        }

        input[type="button"] {
            background-color: #4caf50;
            color: #fff;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            margin: 5px;
        }

        input[type="button"]:hover {
            background-color: #45a049;
        }

        h3 {
            color: #ff0000; /* Customize the color of the error message */
        }
    </style>
</head>
<body>

    <form action="welcome" method="post">

        <a href="login.jsp"><input type="button" value="LOGIN"></a>
        <br>

        <% String message=(String)request.getAttribute("message"); %>
        <% if(message != null) { %>
            <h3><%= message %></h3>
        <% } %>

        <a href="signup.jsp"><input type="button" value="SIGNUP"></a>

    </form>

</body>
</html>
