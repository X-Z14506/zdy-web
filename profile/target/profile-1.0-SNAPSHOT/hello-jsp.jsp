<%--
  Created by IntelliJ IDEA.
  User: 123
  Date: 2020/12/10
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%!
    //这段代码是类级别的
    private int count;
%>
<%
    //这段代码是doGet方法的
    count++;
    request.setCharacterEncoding("utf-8");
    String name =request.getParameter("name");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>个人名片</title>
    <link href="./css/app.css" rel="stylesheet">
    <style>
        h2.hello {
            color: cornflowerblue;
        }
        h2.hello:hover{
            color: cyan;
        }
        ul.hobby{
            color: blueviolet;
        }
        ul.hobby:hover {
            color: lawngreen;
        }
        ol.hobby{
            color: salmon;
        }
        ol.hobby:hover{
            color: red;
        }
    </style>
</head>
<body>
<div>
    访问次数<%=count%>
</div>
<div>
    <h1 content="text/html" class="center">个人简历</h1>
    <h1 class="center"><%=name%></h1>
    <h5 class="center">西安工程大学</h5>
    <h5 class="center">机械电子工程</h5>
    <p style="color: blueviolet">JSP</p>
</div>
<div>
    <h2 class="hello">我的爱好</h2>
    <ul class="hobby">
        <li>打游戏</li>
        <li>睡觉</li>
        <li>打麻将</li>
        <li>
            <a href="https://blog.csdn.net/weixin_49786076?spm=1010.2135.3001.5113">CSDN</a>
        </li>
    </ul>
</div>
<div>
    <h2 class="hello">我的工作经历</h2>
    <ol class="hobby">
        <li>2017-2020西安工程大学</li>
        <li>
            <a href="https://www.baidu.com/">百度</a>
        </li>
        <li>
            <a href="https://news.qq.com/">腾讯</a>
        </li>
        <li>阿里</li>
    </ol>
</div>
<img src="./image/huyan3.jpg" alt="这是我的桌面背景" width="500" height="200">
</body>
</html></html>