<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lhwni
  Date: 2022/6/3
  Time: 23:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cart</title>
</head>
    <style>
        *{margin: 0;padding: 0}
        body{
            display: flex;
            height: 100vh;
            align-items: center;
            justify-content: center;
            transition: 1s;
            background-color: #a7d2bc;
        }
        article{
            width: 650px;
            padding: 20px;
            box-shadow: 4px 4px 6px gray;
            display: flex;
            justify-content: space-around;
            flex-direction: column;
            align-items: center;
            background-color: #fff;
        }
        table{
            width: 600px;
            padding: 20px;
            border-collapse: collapse;
            margin: 20px;
        }
        table tr th{
            padding: 6px;
            margin: 0;
            background-color: #a7d2bc;
            text-align: center;
        }
        table tr td{
            text-align: center;
            border-bottom: 1px solid black;
            padding: 5px;
            margin: 0;
            font-size: 12px;
        }
        button{
            width: 100px;
            height: 30px;
            border: none;
            cursor: pointer;
            background: #a7d2bc;
            font-weight: bold;
            margin: 20px 0;
        }
        article span{
            width: 210px;
            display: flex;
            justify-content: space-around;
            align-items: center;
            margin-right: -400px;
        }
        table tr td a img{width: 15px;height: 15px;}


    </style>
<body>
<article>
    <h2>Cart</h2>
    <table>
        <tr>
            <th>商品名</th>
            <th>购买数量</th>
            <th>总计</th>
            <th></th>
        </tr>
        <c:forEach var="cart" items="${requestScope.cart}" >
        <tr>
            <td>${cart.good}</td>
            <td>${cart.num}</td>
            <td>${cart.price}￥</td>
            <td>
              <a href="/delete?good=${cart.good}">
                  <img src="img/icon/删除.png">
              </a>
            </td>
        </tr>
        </c:forEach>
    </table>
    <span>
        <a href="/display"><button>返回商城</button></a>
        <a href="pay.jsp"><button>前往支付</button></a>
    </span>
</article>
</body>

<script>



</script>
</html>
