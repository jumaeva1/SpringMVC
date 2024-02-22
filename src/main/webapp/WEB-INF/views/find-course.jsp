<%--
  Created by IntelliJ IDEA.
  User: Arzan nout
  Date: 21.02.2024
  Time: 2:22
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
<table border="1px;color : red">
    <thead>
    <tr>
        <th>id</th>
        <th>course name</th>
        <th>duration</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>${course.id}</td>
        <td>${course.courseName}</td>
        <td>${course.duration}</td>
    </tr>
    </tbody>
</table>
<div style="margin: auto">
    <button><a href="/courses">roll-back</a></button>
    <button><a href="/companies">main</a></button>
</div>
</body>
</html>
