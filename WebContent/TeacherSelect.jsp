<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>教师查询</title>
</head>
<style>
.div1{
 width: 50vmin;
 height: 68vmin;
 position:absolute;
 left: 60vmin;
 top:10vmin;
 background:#eeeeee;
}
.div2{
height:20vmin;
}
</style>
<body>
<div class="div1">
<div class="div2"></div>
<form action="teachers" method="post">
<table>
<tr>
<td>院系号：</td><td><input type="text" name="academyNumber"></td>
</tr>
<tr>
<td></td>
<td><input type="submit" value="提交"></td>
</tr>
</table>
</form>
</div>
</body>
</html>