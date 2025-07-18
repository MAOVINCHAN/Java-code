<%@ page import="com.instance.stusys.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../../components/tag-head.jsp">
    <jsp:param name="title" value="用户列表"/>
</jsp:include>
<style>
    body {
        display: flex;
        justify-content: center;
        align-items: center;
        position: relative;
    }
    form {
        width: 500px;
        border: 1px solid #eee;
        border-radius: 10px;
        background-color: #fff;
        padding: 50px 20px;
    }
</style>
<body>
<%
    User oldUser = (User) request.getAttribute("old_user");
    String c_page = request.getParameter("page");
    String size = request.getParameter("size");
%>
<form action="/stu-sys/users" method="post">
    <input class="form-control" type="hidden" name="user_id" value="<%= oldUser.getUser_id()%>">
    <input class="form-control" type="hidden" name="page" value="<%= c_page%>">
    <input class="form-control" type="hidden" name="size" value="<%= size%>">
    <div class="mb-3">
        <label for="real_name" class="form-label">用户名</label>
        <input class="form-control" type="text" id="real_name" name="real_name" value="<%= oldUser.getReal_name()%>">
    </div>
    <div class="mb-3">
        <label for="password" class="form-label">密码</label>
        <input class="form-control" type="text" id="password" name="password" value="<%= oldUser.getPassword()%>">
    </div>
    <div class="mb-3">
        <label for="email" class="form-label">邮箱</label>
        <input class="form-control" type="email" id="email" name="email" value="<%= oldUser.getEmail()%>">
    </div>
    <div class="mb-3">
        <label for="phone" class="form-label">邮箱</label>
        <input class="form-control" type="text" id="phone" name="phone" value="<%= oldUser.getPhone()%>">
    </div>
    <div class="mb-3">
        <input type="submit" class="btn btn-primary" value="提交">
    </div>
</form>
</body>
</html>
