<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>主页</title>
    <link rel="icon" href="favicon.ico">
    <style>
        body {
            /*background-color: aqua;*/
        }
    </style>
</head>
<body>
<br/>

<div><a href="test?id=1">查找用户1</a></div>
<div><a href="test">查找所有用户并返回json数据</a></div>
<div>
    <form action="/demo08_servlet1_war_exploded/test?login=1" method="post">
        <div>
            <label for="username">用户名</label>
            <input type="text" id="username" name="username">
        </div>
        <div>
            <label for="password">密码</label>
            <input type="password" id="password" name="password">
        </div>
        <div>
            <button type="submit">登录</button>
        </div>
    </form>
</div>
</body>
</html>