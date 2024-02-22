<%--
  Created by IntelliJ IDEA.
  User: Arzan nout
  Date: 21.02.2024
  Time: 2:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        <%@include file="/WEB-INF/views/css/form.css"%>
    </style>
    <%--   <link rel="stylesheet" href="css/form.css">--%>
</head>
<body>
<div class="box">
    <h1>Save company</h1>
    <form action="/saveCompany" method="post">
        <div class="input-box">
            <input type="text" name="name" placeholder="Company name:">
            <!-- <span>Company name:</span>-->
            <i></i>
        </div>
        <div class="input-box">
            <input type="text" name="located" id="locatedCountry" placeholder="Country:" required="required">
            <!--            <span for="locatedCountry">Country:</span>-->
            <i></i>
        </div>
        <input type="submit" value="save">
    </form>
</div>
</body>
</html>
