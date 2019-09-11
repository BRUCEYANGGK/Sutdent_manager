<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查询个人信息</title>
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
.div2{
 position:relative;
 height: 24vmin;
}
</style>
<body>
<div class="div1">
<form action="stuselect" method="get">
<div class="div2">
<h3>查询学生个人信息</h3>
</div>
<table>
<tr><th>学号：</th><th><input type="text" name="StuNumber"></th></tr>
<tr><th>姓名：</th><th><input type="text" name="StuName"></th></tr>
<tr><th></th><th><input type="submit" value="查询"></th></tr>
</table>
</form>
</div>
</body>
</html>