
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Showing</title>
    <link rel="stylesheet" type="text/css" href="css/index.css">
</head>
<body>
<nav>
    <div id="u">
        <div id="h">
            <img src="img/user/lhw.jpg">
        </div>
        ${requestScope.success}
    </div>

    <h1>Gouwu</h1>
    <div id="icon">
        <span>
            <a href="/cart">
                <img src="img/icon/购物车.png" alt="">
            </a>
        </span>
        <span>
            <a href="login.jsp">
                <img src="img/icon/切换用户.png" alt="">
            </a>
        </span>
    </div>
</nav>
<article>
    <div id="all">
    <c:forEach var="good" items="${requestScope.goods}">
        <div class="good">
            <img src="img/good/${good.name}.png" alt="">
            <div id="buy">
                <h3>${good.name}</h3>
                <p>${good.introduce}</p>
                <span>价格：${good.price}￥</span>
                <!-- 加入 -->
                    <a href="/information?name=${good.name}&introduce=${good.introduce}&price=${good.price}&&num=${good.num}">
                        <img src="img/icon/查看.png" alt="">
                    </a>
            </div>
        </div>
    </c:forEach>
    </div>
</article>
</body>
</html>
