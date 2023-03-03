<%--
  Created by IntelliJ IDEA.
  User: lhwni
  Date: 2022/6/3
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" type="text/css" href="css/login_register.css">
</head>
<body>
<form action="/register" method="post">
    <input type="text" name="name" value="" placeholder="账号：">
    <input type="password" name="pwd" value="" placeholder="密码：">
    <input id="register" type="submit" name="register" value="Register">
</form>
</body>
</html>
