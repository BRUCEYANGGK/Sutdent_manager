<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改密码</title>
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
<form action="updatapassword" method="post">
<div class="div1">
<table>
<p><b>修 改 密 码</b></p>
<br>
<br>
<br>
<tr><td>旧密码：</td><td><input type="password" name="oldpassword"></td></tr>
<tr><td>新密码：</td><td><input type="password" name="newpassword"></td></tr>
<tr><td></td><td><input type="submit" value="提交"></td></tr>
</table>
</form>
</div>
</body>
</html>