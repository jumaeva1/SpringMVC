<%--
  Created by IntelliJ IDEA.
  User: Arzan nout
  Date: 21.02.2024
  Time: 2:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        <%@include file="/WEB-INF/views/css/forFind.css" %>
    </style>
</head>
<body>
<table border="1px">
    <thead>
    <tr>
        <th>id</th>
        <th>company name</th>
        <th>locatedCountry</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>${company.id}</td>
        <td>${company.companyName}</td>
        <td>${company.locatedCountry}</td>
    </tr>
    </tbody>
</table>
<a href="/companies">main</a>
</body>
</html>
