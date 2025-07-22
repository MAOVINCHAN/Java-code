<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2025/7/22
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <form action="/mvc/user">
    <p>用户名：<input type="text" name="username" /></p>
    <p>密码：<input type="password" name="password" /></p>
    <p>
      兴趣爱好：
      <input type="checkbox" name="favorites" value="足球">足球
      <input type="checkbox" name="favorites" value="篮球">篮球
      <input type="checkbox" name="favorites" value="棒球">棒球
    </p>

    <p>
      <input type="submit" value="提交" />
    </p>
  </form>
</body>
</html>
