<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2024/10/31
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  // 获取请求参数或从数据库中获取标题
  String pageTitle = request.getParameter("title");
  if (pageTitle == null || pageTitle.isEmpty()) {
    pageTitle = "默认标题";
  }
%>

<html>
  <head>
    <title><%= pageTitle %></title>
  </head>
  <body>
    hello servlet!
  </body>
</html>
