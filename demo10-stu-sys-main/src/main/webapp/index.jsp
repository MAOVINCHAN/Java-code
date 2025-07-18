<%@ page import="com.project.stusys.utils.Constants" %>
<%@ page import="com.project.stusys.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>STU-SYS</title>
    <link rel="shortcut icon" href="/static/favicon.ico"/>
    <link rel="bookmark" href="/static/favicon.ico"/>
    <link rel="stylesheet" type="text/css" href="/static/easyui/css/default.css" />
    <link rel="stylesheet" type="text/css" href="/static/easyui/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="/static/easyui/themes/icon.css" />
    <script type="text/javascript" src="/static/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="/static/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src='/static/easyui/js/outlook2.js'> </script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/axios/1.10.0/axios.min.js"></script>
    <script type="text/javascript">
        const _menus = {"menus":[
                {"menuid":"1","icon":"","menuname":"成绩统计分析",
                    "menus":[
                        {"menuid":"11","menuname":"考试列表","icon":"icon-exam","url":"/exam?action=page"},
                    ]
                },
                {"menuid":"2","icon":"","menuname":"学生信息管理",
                    "menus":[
                        {"menuid":"21","menuname":"学生列表","icon":"icon-user-student","url":"/student?action=page"},
                    ]
                },
                {"menuid":"3","icon":"","menuname":"教师信息管理",
                    "menus":[
                        {"menuid":"31","menuname":"教师列表","icon":"icon-user-teacher","url":"/teacher?action=page"},
                    ]
                },
                {"menuid":"4","icon":"","menuname":"基础信息管理",
                    "menus":[
                        {"menuid":"41","menuname":"年级列表","icon":"icon-world","url":"/grade?action=page"},
                        {"menuid":"42","menuname":"班级列表","icon":"icon-house","url":"/class?action=page"},
                        {"menuid":"43","menuname":"课程列表","icon":"icon-book-open","url":"/course?action=page"}
                    ]
                },
                {"menuid":"5","icon":"","menuname":"系统管理",
                    "menus":[
                        {"menuid":"51","menuname":"系统设置","icon":"icon-set","url":"/setting?action=page"},
                    ]
                }
            ]};
    </script>

</head>
<%
    User user = (User) request.getSession().getAttribute(Constants.LOGIN_USER);
%>
<body class="easyui-layout" style="overflow-y: hidden"  scroll="no">
<noscript>
    <div style=" position:absolute; z-index:100000; height:2046px;top:0px;left:0px; width:100%; background:white; text-align:center;">
        <img src="#" alt='抱歉，请开启脚本支持！' />
    </div>
</noscript>
<div region="north" split="true" border="false" style="overflow: hidden; height: 30px;
        background-color: #7f99be;
        line-height: 20px;color: #fff; font-family: Verdana, 微软雅黑,黑体">
    <span style="float:right; padding-right:20px;" class="head"><span style="color:red; font-weight:bold;"><%= user != null ? user.getNickname() : "" %>&nbsp;</span>您好&nbsp;&nbsp;&nbsp;<a href="#" id="loginOut">安全退出</a></span>
    <span style="padding-left:10px; font-size: 16px; ">学生信息管理系统</span>
</div>
<div region="south" split="true" style="height: 30px; background: #D2E0F2; ">
    <div class="footer">Copyright &copy; Power By Mryang</div>
</div>
<div region="west" hide="true" split="true" title="导航菜单" style="width:180px;" id="west">
    <div id="nav" class="easyui-accordion" fit="true" border="false">
        <!--  导航内容 -->
    </div>

</div>
<div id="mainPanle" region="center" style="background: #eee; overflow-y:hidden">
    <div id="tabs" class="easyui-tabs"  fit="true" border="false" >
        <div title="欢迎使用" style="padding:20px;overflow:hidden; color:red; ">
        </div>
    </div>
</div>

<script>
    $("#loginOut").click(function (e) {
        console.log("e", e);
        $.messager.confirm("提示", "是否确认注销登录？", (sure) => {
            if(sure) {
                axios.get("/logout").then(res=>{
                    if(res.data.status == 200) {
                        location.href = "/login";
                    }
                }).catch(err => {

                })
            }
        })
    })
</script>
</body>
</html>
