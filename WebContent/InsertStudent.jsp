<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>填写学生信息</title>
</head>
<style>
.div1{
 width: 80vmin;
 height: 90vmin;
 position:absolute;
 left: 60vmin;
 top:10vmin;
 background:#eeeeee;
}
.div2{
 position: relative;
 left:8vmin;
 top:4vmin;
}
</style>
<body>
<div class=div1>
<h1 style="text-align:center">请填写以下信息</h1>
<div class="div2">
<form action="message" method="post">
<table>
<tr>
<td>学号:</td><td><input type="text" name="studentNumber">*</td>
</tr>
<tr>
<td>姓名:</td><td><input type="text" name="studentName">*</td>
</tr>
<tr>
<td>性别:</td><td><input type="text" name="studentSex">*</td>
</tr>
<tr>
<td>身份证号:</td><td><input type="text" name="studentID">*</td>
</tr>
<tr>
<td>家庭住址:</td><td><input type="text" name="studentAddress"></td>
</tr>
<tr>
<td>宿舍号:</td><td><input type="text" name="studentApartment"></td>
</tr>
<tr>
<td>学院:</td><td><input type="text" name="studentAcademy"></td>
</tr>
<tr>
<td>专业:</td><td><input type="text" name="studentMajor"></td>
</tr>
<tr>
<td>班级:</td><td><input type="text" name="studentClass"></td>
</tr>
</table>
<input type="submit" value="提交">
</form>
</div>
</div>
</body>
</html>