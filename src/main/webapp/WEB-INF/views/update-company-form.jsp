<%--
  Created by IntelliJ IDEA.
  User: Arzan nout
  Date: 21.02.2024
  Time: 2:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        <%@include file="/WEB-INF/views/css/form.css" %>
    </style>
</head>
<body>
<h1>Update company</h1>
<form action="/real/update/${company.id}" method="post">
    <label>Company name:</label><input value="${company.companyName}" type="text" name="name">
    <label>Country:</label><input value="${company.locatedCountry}" type="text" name="country">
    <br> <input type="submit" value="update">
</form>
</body>
</html>
