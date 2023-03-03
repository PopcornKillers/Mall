<%--
  Created by IntelliJ IDEA.
  User: lhwni
  Date: 2022/6/6
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Good</title>
    <link rel="stylesheet" type="text/css" href="css/good.css">
</head>
<body>

    <div id="goodimg">
        <img src="img/good/${requestScope.good.name}.png" alt="">
    </div>

    <form action="/addcart" method="get">
        <!-- 商品名称 -->
        <input name="good" type="text" readonly="readonly" value="${requestScope.good.name}" id="name">
        <!-- 商品说明 -->
        <p>${requestScope.good.introduce}</p>
        <span>
        <!-- 商品数量 -->
        <input oninput="change()" id="num" type="number" value="1" min="1" name="num" max="${requestScope.good.num}">
        <!-- 价格显示 -->
        <input type="text" name="price" readonly="readonly" id="price" value="${requestScope.good.price}">
         </span>
        <!-- 加入购物车 -->
        <input type="submit" name="add" value="加入购物车" id="add">
    </form>
</body>
<script>
    var num;
    var price = ${requestScope.good.price};
</script>
<script>
    change = function (){
        document.getElementById("price").value = ${requestScope.good.price} * document.getElementById("num").value
    }
</script>
</html>
