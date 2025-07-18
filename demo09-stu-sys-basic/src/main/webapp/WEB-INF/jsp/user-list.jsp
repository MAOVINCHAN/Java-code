<%@ page import="java.util.List" %>
<%@ page import="com.instance.stusys.model.User" %>
<%@ page import="com.instance.stusys.model.Pagination" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../../components/tag-head.jsp">
  <jsp:param name="title" value="用户列表"/>
</jsp:include>
<style>
  .pagination a {
    margin-left: 5px;
    margin-right: 5px;
  }
  .user-page {
    width: 100%;
    height: 100%;
    display: flex;
  }
  .user-page .page-main {
    width: calc(100% - 260px);
    height: 100%;
    display: flex;
    flex-direction: column;
  }
  .user-page .page-main .table {
    max-height: calc(100% - 18px);
    overflow: hidden;
  }
</style>
<body>
<div class="user-page">
  <jsp:include page="../../components/tag-menu.jsp"></jsp:include>
  <div class="page-main">
    <table class="table table-bordered">
      <thead>
        <tr>
          <td>用户编号</td>
          <td>用户名</td>
          <td>用户昵称</td>
          <td>用户邮箱</td>
          <td>用户电话</td>
          <td>操作</td>
        </tr>
      </thead>
      <tbody>
      <%
        // 直接获取所有数据
        // List<User> users = (List<User>) request.getAttribute("users");

        // 通过分页功能获取数据
        Pagination pagination = (Pagination) request.getAttribute("pagination");
        List<User> users = pagination.getData();
        for (int i = 0; i < users.size(); i++) {
          User user = users.get(i);
          Integer id = user.getUser_id();
          String username = user.getUsername();
          String realName = user.getReal_name();
          String email = user.getEmail();
          String phone = user.getPhone();
      %>
      <tr>
        <td><%= id %></td>
        <td><%= username %></td>
        <td><%= realName %></td>
        <td><%= email %></td>
        <td><%= phone %></td>
        <td>
          <button
            type="button"
            class="btn btn-primary btn-sm"
            data-id="<%= id%>"
            data-page="<%= pagination.getCurrent()%>"
            data-size="<%= pagination.getLimit()%>"
            onclick="editUser()">
            编辑
          </button>
          <button
            type="button"
            class="btn btn-danger btn-sm"
            data-id="<%= id%>"
            data-page="<%= pagination.getCurrent()%>"
            data-size="<%= pagination.getLimit()%>"
            onclick="deleteUser()">
            删除
          </button>
        </td>
      </tr>
      <%
        }
      %>
      </tbody>
    </table>
    <div class="pagination" style="display: flex;justify-content: flex-end;">
      <span>总条数：<%= pagination.getTotal() %></span>
      <span>总页数：<%= pagination.getPage_count() %></span>
      <span>当前页：<%= pagination.getCurrent() %></span>

      <%
        if(!pagination.isFirst()) {
      %>
      <a href="<%= pagination.getFirst_url()%>">首页</a>
      <%
        }
      %>


      <%
        if(pagination.getCurrent() != 1) {
      %>
      <a href="<%= pagination.getPre_url()%>">上一页</a>
      <%
        }
      %>

      <%
        if(pagination.getCurrent() != pagination.getPage_count()) {
      %>
      <a href="<%= pagination.getNext_url()%>">下一页</a>
      <%
        }
      %>


      <%
        if(!pagination.isLast()) {
      %>
      <a href="<%= pagination.getLast_url()%>">最后一页</a>
      <%
        }
      %>
    </div>
  </div>
</div>

<script type="text/javascript">
  const createTagA = (e, action = "delete") => {
    const el = e.target;
    const id = el.getAttribute("data-id");
    const page = el.getAttribute("data-page");
    const size = el.getAttribute("data-size");
    const a = document.createElement("a");
    const path = location.origin + location.pathname;
    const url = path + "?action=" + action + "&user_id=" + id +"&page=" + page +"&size=" + size;
    a.href = url;
    return a;
  }
  const deleteUser = () => {
    const e = window.event;
    const sure = confirm(`是否确认删除该用户？删除后不可恢复！`);
    if(!sure) return;
    const a = createTagA(e);
    a.click();
  }

  const editUser = () => {
    const e = window.event;
    const a = createTagA(e, "edit");
    a.click();
  }
</script>
</body>
</html>
