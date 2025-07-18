<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../components/tag-head.jsp">
  <jsp:param name="title" value="用户注册"/>
</jsp:include>
<%--<%--%>
<%--  ServletContext sc = request.getServletContext();--%>
<%--  Integer count = (Integer) sc.getAttribute("count");--%>
<%--  if(count == null) {--%>
<%--    count = 1;--%>
<%--  }else {--%>
<%--    count ++;--%>
<%--  }--%>
<%--  sc.setAttribute("count", count);--%>
<%--%>--%>
<style>
  body {
    display: flex;
    justify-content: center;
    align-items: center;
    position: relative;
  }
  .form {
    width: 500px;
    border: 1px solid #eee;
    border-radius: 10px;
    background-color: #fff;
    padding: 50px 20px;
  }
  .avatar-container .avatar-uploader {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    overflow: hidden;
    text-align: center;
    display: flex;
    align-items: center;
    justify-content: center;
  }
  .avatar-container .avatar-uploader img {
    width: 178px;
    height: 178px;
    overflow: hidden;
  }
  .avatar-uploader .bi-plus-lg {
    display: block;
    font-size: 28px;
    color: #8c939d;
    width: 178px;
    height: 178px;
  }
  .avatar-uploader .bi-plus-lg:before {
    line-height: 178px;
  }
</style>
<body>
<div class="form">
<%--  <span>被访问次数： <%= request.getServletContext().getAttribute("count") %></span>--%>
  <div class="mb-3">
    <label for="real-name-input" class="form-label">昵称：</label>
    <input type="text" class="form-control" id="real-name-input" placeholder="请输入昵称" name="real_name">
  </div>
  <div class="mb-3">
    <label for="username-input" class="form-label">用户名：</label>
    <div class="input-group">
      <span class="input-group-text" id="inputGroupPrepend2">@</span>
      <input type="text" class="form-control" id="username-input"  aria-describedby="inputGroupPrepend2">
    </div>
  </div>
  <div class="mb-3">
    <label for="password-input" class="form-label">密码：</label>
    <input type="password" class="form-control" id="password-input" placeholder="请输入密码" name="password">
  </div>
  <div class="mb-3">
    <label for="re-password-input" class="form-label">再次输入密码：</label>
    <input type="password" class="form-control" id="re-password-input" placeholder="请再次输入密码" name="password">
  </div>
  <div class="mb-3">
    <label for="email-input" class="form-label">邮箱：</label>
    <input type="email" class="form-control" id="email-input" placeholder="请输入邮箱" name="email">
  </div>
  <div class="mb-3">
    <label for="phone-input" class="form-label">手机号：</label>
    <input type="text" class="form-control" id="phone-input" placeholder="请输入手机号" name="phone">
  </div>

  <div class="mt-10 mb-10 d-flex justify-content-between">
    <a href="login.jsp" class="text-primary">去登录</a>
  </div>

  <div class="d-grid gap-2 mt-10">
    <button class="btn btn-primary" type="submit" id="submit-btn">提交</button>
  </div>
</div>

</body>
<script type="text/javascript">
  const submitBtn = $("#submit-btn");

  submitBtn.on("click", () => {
    const realName = $("#real-name-input").val();
    if(!realName) { alert("昵称不能为空！"); return; }
    // if(!imgData) { alert("头像不能为空！"); return; }
    const username = $("#username-input").val();
    if(!username) { alert("用户名不能为空！"); return; }
    const password = $("#password-input").val();
    if(!password) { alert("密码不能为空！"); return; }
    const rePassword = $("#re-password-input").val();
    if(!rePassword || password != rePassword) { alert("两次密码输入必须一致！"); return; }
    const email = $("#email-input").val();
    if(!email) { alert("邮箱不能为空！"); return; }
    const phone = $("#phone-input").val();
    if(!phone) { alert("手机号不能为空！"); return; }

    const data = {
      real_name: realName,
      username,
      password,
      email,
      phone
    }

    $.ajax("/stu-sys/register", {
      method: "POST",
      data,
      success: (res) => {
        alert(res.message)
      },
      error: () => {
        alert("注册失败，未知错误！")
      }
    })
  })

</script>
</html>
