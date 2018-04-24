<%--
  Created by IntelliJ IDEA.
  User: Lee
  Date: 2018/4/17
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<span style="color:red">${msg}</span>
<p/>
<form action="/login" method="post">

    用户名<input type="text" name="username" id="username"/>
    <p/>
    密 &nbsp;&nbsp;码 <input type="password" name="password" id="password">
    <p/>
    <input type="submit" name="提交">
</form>
</body>
</html>
