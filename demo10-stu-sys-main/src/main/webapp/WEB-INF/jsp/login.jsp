<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="shortcut icon" href="/static/favicon.ico" />
    <link rel="bookmark" href="/static/favicon.ico" />
    <link href="/static/h-ui/css/H-ui.min.css" rel="stylesheet" type="text/css" />
    <link href="/static/h-ui/css/H-ui.login.css" rel="stylesheet" type="text/css" />
    <link href="/static/h-ui/lib/icheck/icheck.css" rel="stylesheet" type="text/css" />
    <link href="/static/h-ui/lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="/static/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/static/easyui/themes/icon.css">
    <script type="text/javascript" src="/static/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="/static/h-ui/js/H-ui.js"></script>
    <script type="text/javascript" src="/static/h-ui/lib/icheck/jquery.icheck.min.js"></script>
    <script type="text/javascript" src="/static/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/axios/1.10.0/axios.min.js"></script>
    <title>登录|学生成绩管理系统</title>
    <meta name="keywords" content="学生成绩管理系统">
</head>

<body>

<div class="header" style="padding: 0;">
    <h2 style="color: white; width: 400px; height: 60px; line-height: 60px; margin: 0 0 0 30px; padding: 0;">stu management system</h2>
</div>
<div class="loginWraper">
    <div id="loginform" class="loginBox">
        <form id="form" class="form form-horizontal" method="post">
            <div class="row cl">
                <label class="form-label col-3"><i class="Hui-iconfont">&#xe60d;</i></label>
                <div class="formControls col-8">
                    <input id="username" name="username" type="text" placeholder="账户" class="input-text size-L">
                </div>
            </div>
            <div class="row cl">
                <label class="form-label col-3"><i class="Hui-iconfont">&#xe60e;</i></label>
                <div class="formControls col-8">
                    <input id="password" name="password" type="password" placeholder="密码" class="input-text size-L">
                </div>
            </div>
            <div class="row cl">
                <div class="formControls col-8 col-offset-3">
                    <input class="input-text size-L" name="vcode" type="text" placeholder="请输入验证码" style="width: 200px;">
                    <img title="点击图片切换验证码" id="vcodeImg" src="/login?action=code">
                </div>
            </div>

            <div class="mt-20 skin-minimal" style="text-align: center;">
                <div class="radio-box">
                    <input type="radio" id="radio-2" name="type" checked value="2" />
                    <label for="radio-1">学生</label>
                </div>
                <div class="radio-box">
                    <input type="radio" id="radio-3" name="type" value="3" />
                    <label for="radio-2">老师</label>
                </div>
                <div class="radio-box">
                    <input type="radio" id="radio-1" name="type" value="1" />
                    <label for="radio-3">管理员</label>
                </div>
            </div>

            <div class="row">
                <div class="formControls col-8 col-offset-3">
                    <input id="submitBtn" type="button" class="btn btn-success radius size-L" value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;">
                </div>
            </div>
        </form>
    </div>
</div>


<script type="text/javascript">
    $(function() {
        //点击图片切换验证码
        $("#vcodeImg").click(function() {
            this.src = "/login?action=code&t=" + new Date().getTime();
        });

        //登录
        $("#submitBtn").click(function() {
            if($("#radio-2").attr("checked") && "${systemInfo.forbidStudent}" == 1) {
                $.messager.alert("消息提醒", "学生暂不能登录系统！", "warning");
                return;
            }
            if($("#radio-3").attr("checked") && "${systemInfo.forbidTeacher}" == 1) {
                $.messager.alert("消息提醒", "教师暂不能登录系统！", "warning");
                return;
            }

            const dataArr = $("#form").serializeArray();
            const data = dataArr.reduce((pre, cur) => {
                pre[cur.name] = cur.value;
                return pre;
            }, {})

            if(!data.username || !data.password) {
                $.messager.alert("消息提醒", "用户名或密码不能为空", "warning");
                return;
            }
            if(!data.vcode) {
                $.messager.alert("消息提醒", "验证码不能为空", "warning");
                return;
            }

            // $.ajax({
            //     type: "post",
            //     url: "/login",
            //     data: data,
            //     dataType: "text", //返回数据类型
                // success: function(msg) {
                    // if("vcodeError" == msg) {
                    //     $.messager.alert("消息提醒", "验证码错误!", "warning");
                    //     $("#vcodeImg").click(); //切换验证码
                    //     $("input[name='vcode']").val(""); //清空验证码输入框
                    // } else if("loginError" == msg) {
                    //     $.messager.alert("消息提醒", "用户名或密码错误!", "warning");
                    //     $("#vcodeImg").click(); //切换验证码
                    //     $("input[name='vcode']").val(""); //清空验证码输入框
                    // } else if("admin" == msg) {
                    //     window.location.href = "SystemServlet?method=toAdminView";
                    // } else if("student" == msg) {
                    //     window.location.href = "SystemServlet?method=toStudentView";
                    // } else if("teacher" == msg) {
                    //     window.location.href = "SystemServlet?method=toTeacherView";
                    // }
                // }
            // });

            console.log("data", data);

            axios({
                url: "/login",
                method: "post",
                headers: {
                    "content-type": "application/x-www-form-urlencoded"
                },
                data,
            }).then(res=> {
                const data = res.data;
                if(data.status != 200) {
                    $.messager.alert("消息提醒", data.message, "warning");
                    $("#vcodeImg").click(); //切换验证码
                    $("#password").val(""); //清空验证码输入框
                    return;
                }
                location.href = "/";
            }).catch(err=>{
                throw new Error(err)
            })
        });

        //设置复选框
        $(".skin-minimal input").iCheck({
            radioClass: 'iradio-blue',
            increaseArea: '25%'
        });
    })
</script>
</body>
</html>