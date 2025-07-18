<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test</title>
</head>
<body>
    <div>传递过来的数据： </div>
    <div>用户名: ${user.getUsername()}</div>
    <div>年龄: ${user.age}</div>

    <div>
        <span>你的IP地址是：</span>

        <%--
            脚本程序: 可以包含任意量的Java语句、变量、方法或表达式，只要它们在脚本中是正确的代码
            就好比 java中的 public class className{ 内容… }
            语法： <% 代码 %>
        --%>
        <%
            // Java代码,在控制台输出
            System.out.println(request.getRemoteAddr());

            // 在页面输出
            out.println(request.getRemoteAddr());
        %>

        <%--
            JSP声明: 一个声明语句可以声明一个或多个变量、方法，供后面的Java代码使用。在JSP文件中，您必须先声明这些变量和方法然后才能使用它们。
            就好比 java中 类里声明成员变量
            语法： <%! 变量 %>
        --%>
        <div>
            <%! Integer num1 = 0; %>
            <%! Integer num2 = 10; %>
            <%! Integer num3 = 100; %>
            <%
                out.println("num1 is: " + num1);
                out.println("num2 is: " + num2);
                out.println("num3 is: " + num3);
            %>
        </div>

        <%--
            JSP表达式:
            语法： <%= 表达式 %>
        --%>
        <div>
            Today's date: <%= (new java.util.Date()).toLocaleString()%>
        </div>
    </div>
</body>
</html>
