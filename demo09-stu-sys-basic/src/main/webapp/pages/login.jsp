<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <jsp:include page="../components/tag-head.jsp">
    <jsp:param name="title" value="欢迎使用，请登录"/>
  </jsp:include>
  <style>
    body {
      display: flex;
      justify-content: center;
      align-items: center;
    }
    .form {
      width: 500px;
      border: 1px solid #eee;
      border-radius: 10px;
      background-color: #fff;
      padding: 50px 20px;
    }
  </style>
<body>
  <div class="form">
    <div class="mb-3">
      <label for="exampleFormControlInput1" class="form-label">用户名：</label>
      <input type="text" class="form-control" id="exampleFormControlInput1" placeholder="请输入用户名" name="username">
    </div>
    <div class="mb-3">
      <label for="exampleFormControlInput2" class="form-label">密码：</label>
      <input type="password" class="form-control" id="exampleFormControlInput2" placeholder="请输入密码" name="password">
    </div>
    <div class="mt-10 mb-10 d-flex justify-content-between">
      <a href="forgot.jsp" class="text-primary">忘记密码?</a>
      <a href="register.jsp" class="text-primary">去注册</a>
    </div>
    <div class="d-grid gap-2 mt-10">
      <button class="btn btn-primary" type="submit">登录</button>
    </div>
  </div>

  <script type="text/javascript">
    $(".btn-primary").on("click", () => {
      const username = $("#exampleFormControlInput1").val();
      const password = $("#exampleFormControlInput2").val();
      if(username == "" || password == "") {
        alert("用户名或密码不能为空！");
        return;
      }

      $.post("/stu-sys/login", {
        username,
        password
      }, (res) => {
        if(res.status == 200) {
          location.href = "/stu-sys/"
        }else {
          alert("登录失败,信息：" + res.message);
        }
      })
    })
  </script>
</body>
</html>
