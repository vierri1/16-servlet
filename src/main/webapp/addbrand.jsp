<%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 02.10.2018
  Time: 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add New Brand</title>
</head>
<body>
<form action="/brands" method="post">
    Name <input type="text" name="name">
    Country <input type="text" name="country">
    <input type="submit">
</form>
</body>
</html>
