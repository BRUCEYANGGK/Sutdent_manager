<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册</title>
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
</style>
<body>
<div class="div1">
<br>
<br>
<br>
<form action="register" method="post">
学号：<input type="text" name="usernumber" >*<br>
<br>
名字：<input type="text" name="username" ><br>
<br>
密码：<input type="password" name="password"><br>
<br>
<input type="submit" value="注册">
</form>
</div>
</body>
</html>