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
<h1>Update course</h1>
<form action="/course/update/${course.id}" method="post">
    <label>Course name:</label><input value="${course.courseName}" type="text" name="courseName"><br>
    <label>duration:</label><input value="${course.duration}" placeholder="number" type="number" name="duration">
    <br> <input type="submit" value="update">
</form>
</body>
</html>
