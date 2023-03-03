<%--
  Created by IntelliJ IDEA.
  User: lhwni
  Date: 2022/6/3
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="css/login_register.css">
</head>
<body>
    <form action="/login" method="post">
        <input type="text"  name="name" value="" placeholder="账号：" autofocus>
        <input type="password" name="pwd" value="" placeholder="密码：">
        <a href="register.jsp">没有账号？点此注册</a>
        <input id="login" type="submit" name="login" value="Login">
    </form>
</body>
</html>
