<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>欢迎来到学生管理系统</title>
</head>
<style>
.div1{
 width: 50vmin;
 height: 68vmin;
 position:absolute;
 left: 60vmin;
 top:10vmin;
 text-align: center;
 background:#eeeeee;
}
.div1:hover{
background-color:#787878;
}
</style>
<body>
<div class="div1"><b>登 陆 界 面</b>
<form action="login" method="post">
<br>
<br>
<br>
<br>
学号：<input type="text" name="usernumber" autofocus><br>
<br>
名字：<input type="text" name="username" ><br>
<br>
密码：<input type="password" name="password"><br>
<br>
<input type="submit" value="登陆">
</form>
<br>
<br>
<br>
<br>
<a href="register.jsp" target="_top">注册</a>&nbsp&nbsp
<a href="UpdataPassW.jsp" target="_top">修改密码</a>
</div>
</body>
</html>