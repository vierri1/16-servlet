<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<%if (request.getParameter("err_code") != null) {%>
    <p style="color:#FF0000">Ошибка регистрации</p>
<%}%>
<form action="/login" method="post">
    <input type="text" name="login">
    <input type="password" name="password">
    <input type="submit">
</form>
<%@include file="sidebar.jsp"%>
<%@include file="footer.jsp"%>