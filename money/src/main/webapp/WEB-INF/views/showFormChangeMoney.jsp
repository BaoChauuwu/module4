<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 9/12/2025
  Time: 9:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/money" method="post">
        <input name="money" placeholder="moi ban nhap so tien can chuyen doi " value="${tien}">
        <button>chuyen doi</button>
    </form>

    <h1> ${tien} </h1>
</body>
</html>
