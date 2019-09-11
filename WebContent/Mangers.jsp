<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>围合管理员查询</title>
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
<form action="mangers" method="post">
<table>
<tr>
<td>围合号：</td>
<td><input type="text" name="apartment"></td>
</tr>
<tr>
<td></td>
<td><input type="submit" value="查询"></td>
</tr>
</table>
</form>
</div>
</body>
</html>