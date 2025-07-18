<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="nav flex-column component-menu">
    <%
        String uri = request.getRequestURI().toString();
    %>
    <span>当前URI：<%= uri %></span>
    <a class="nav-link <%= uri.equals("/stu-sys/") ? "active" : "" %>" aria-current="page" href="/stu-sys/">首页</a>
    <a class="nav-link <%= uri.equals("/stu-sys/WEB-INF/jsp/user-list.jsp") ? "active" : "" %>" aria-current="page" href="/stu-sys/users">用户管理</a>
    <%--<a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>--%>
</nav>
