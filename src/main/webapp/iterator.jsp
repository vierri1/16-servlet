<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Rikki
  Date: 01.10.2018
  Time: 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    List<Integer> list = (List<Integer>) request.getAttribute("myAttr");
    for (Integer integer : list) {
%>
<%=integer%>
<%
    }
%>
</body>
</html>
