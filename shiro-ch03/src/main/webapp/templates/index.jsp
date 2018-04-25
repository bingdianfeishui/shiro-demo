<%--
  Created by IntelliJ IDEA.
  User: Lee
  Date: 2018/4/17
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        table {
            border-collapse: collapse;
        }

        table, td, th {
            border: 1px solid black;
        }
    </style>
</head>
<body>
hello ${username}
<p/>
<div>显示信息</div>
<div><span style="color: red;">${msg}</span></div>

<a href="/logout">/logout</a>
<div>==============</div>
<table>
    <thead align="center">
    <td>静态资源</td>
    <td>权限</td>
    <td>用户</td>
    <td>角色</td>
    <td>购物车</td>
    <td>订单</td>
    </thead>
    <tr>
        <td>
            <ul>
                <li><a href="/js/test.js">/js/test.js</a> </li>
                <li><a href="/static/test.json">/static/test.json</a> </li>
            </ul>
        </td>
        <td>
            <ul>
                <li><a href="/perm/index">/perm/index</a></li>
                <li><a href="/perm/add">/perm/add</a></li>
                <li><a href="/perm/delete">/perm/delete</a></li>
                <li><a href="/perm/allocation">/perm/allocation</a></li>
                <li><a href="/perm/update">/perm/update</a></li>
            </ul>
        </td>
        <td>
            <ul>
                <li><a href="/member/changeOnline">/member/changeOnline</a></li>
                <li><a href="/member/forbid">/member/forbid</a></li>
                <li><a href="/member/delete">/member/delete</a></li>
                <li><a href="/member/list">/member/list</a></li>
                <li><a href="/member/clearRole">/member/clearRole</a></li>

            </ul>
        </td>
        <td>
            <ul>
                <li><a href="/role/add">/role/changeOnline</a></li>
                <li><a href="/role/delete">/role/forbid</a></li>
                <li><a href="/role/update">/role/delete</a></li>
                <li><a href="/role/index">/role/index</a></li>
                <li><a href="/role/changePermission">/role/changePermission</a></li>
                <li><a href="/role/allocation">/role/allocation</a></li>
                <li><a href="/role/clearPermission">/role/clearPermission</a></li>

            </ul>
        </td>
        <td>
            <ul>
                <li><a href="/cart/add">/cart/add</a></li>
                <li><a href="/cart/remove">/cart/remove</a></li>
                <li><a href="/cart/clear">/cart/clear</a></li>
                <li><a href="/cart/list">/cart/list</a></li>
            </ul>
        </td>
        <td>
            <ul>
                <li><a href="/order/create">/order/create</a></li>
                <li><a href="/order/delete">/order/delete</a></li>
                <li><a href="/order/submit">/order/submit</a></li>
                <li><a href="/order/list">/order/list</a></li>
                <li><a href="/order/detail">/order/detail</a></li>
            </ul>
        </td>
    </tr>

</table>

</body>
</html>
