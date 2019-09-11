<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查询同班同学</title>
</head>
<style>
.div1{
 width: 50vmin;
 height: 68vmin;
 position:absolute;
  text-align: center;
 left: 60vmin;
 top:10vmin;
 background:#eeeeee;
}
.div2{
 text-align: left;
height:15vmin;
}
</style>
<body>
<div class="div1">
<h2>查询同班同学</h2>
<div class="div2"></div>
<form action="mates" method="post">
<table>
<tr>
<td>输入班级号：</td><td><input type="text" name="classNumber"></td>
</tr>
</table>
<input type="submit" value="查询">
</form>
</div>
</body>
</html>