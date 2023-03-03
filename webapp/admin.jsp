<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lhwni
  Date: 2022/6/4
  Time: 11:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
    <link rel="stylesheet" type="text/css" href="css/admin.css">
</head>
<body>
    <!-- 导航栏 -->
    <nav>
        <p>Admin view</p>
        <div id="tx">
            <img src="img/user/root.jpg" alt="">
        </div>
        <span class="list">添加商品</span>
        <span class="list">商品管理</span>
        <span class="list">查看用户</span>
         <div id="tc">
            <a href="login.jsp">
                <img src="img/icon/退出.png" alt="">
            </a>
         </div>
    </nav>
    <article>
        <div class="main">
            <!-- 添加商品 -->
        <div class="page">
            <form action="/insert" method="get">
                <input type="text" name="id" value="" placeholder="商品ID" autofocus>
                <input type="text" value="" name="name" placeholder="商品名称">
                <input type="text" name="price" value="" placeholder="商品价格">
                <input type="text" name="num" id="" placeholder="商品数量">
                <textarea name="introduce" placeholder="添加商品说明" id="explain"></textarea>
                <p>
                    <input type="reset" name=""  value="重置信息">
                    <input type="submit" name="insert" value="添加商品">
                </p>
            </form>
        </div>


            <!-- 商品管理 -->
            <div class="page">
                <table>
                    <tr>
                        <th>ID</th>
                        <th>商品名</th>
                        <th>库存</th>
                        <th>零售价￥</th>
                        <th></th>
                    </tr>
                    <c:forEach items="${requestScope.goods}" var="good">
                    <form action="/update" method="get">
                    <tr>
                        <td><input type="text" value="${good.id}" name="id" readonly="readonly" id="id"></td>
                        <td><input type="text"  value="${good.name}" name="name"></td>
                        <td><input type="text" value="${good.num}" name="num" id="num"></td>
                        <td><input type="text" value="${good.price}" name="price"></td>
                        <td>

                            <button id="delete">
                                <a href="/dgood?id=${good.id}">删除</a>
                            </button>

                            <input type="submit"  value="更新" id="update">
                        </td>
                    </tr>
                    </form>
                    </c:forEach>
                </table>
            </div>


            <!-- 用户管理 -->
            <div class="page">
                <table>
                    <tr>
                        <th>用户名</th>
                        <th>密码</th>
                    </tr>
                    <c:forEach var="user" items="${user}">
                    <tr>
                        <td>${user.name}</td>
                        <td>${user.pwd}</td>
                    </tr>
                    </c:forEach>
                </table>
        </div>
        </div>
    </article>
</body>
    <script>
        //页面滚动
        let list = document.querySelectorAll(".list");
        let main = document.querySelector(".main");
        for (let i = 0; i < list.length; i++) {
            list[i].addEventListener("click", () => {
                main.style.left = i * -100 + "%";
            });}
    </script>
</html>
