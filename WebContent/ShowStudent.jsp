<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="mybean.StudentMessage"%>
    <%@page import="mybean.ShowStudent"%>
     <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查看学生信息</title>
</head>
<style>
.div1{
 width: 120vmin;
 position:absolute;
 left: 30vmin;
 top:10vmin;
 text-align: center;
 background:#eeeeee;
}
</style>
<body>
<div class="div1">
<table border="1">
<tr>
<td>学号</td><td>姓名</td><td>性别</td><td>身份证号</td><td>家庭住址</td>
<td>宿舍号</td><td>学院</td><td>专业</td><td>班级</td>
</tr>
<%
ShowStudent mes=new ShowStudent();
List<StudentMessage> list =mes.read();
for(StudentMessage tl:list){
%>
<tr>
<td><%=tl.getStudentNumber()%></td>
<td><%=tl.getStudentName()%></td>
<td><%=tl.getStudentSex()%></td>
<td><%=tl.getStudentID()%></td>
<td><%=tl.getStudentAddress()%></td>
<td><%=tl.getStudentApartment()%></td>
<td><%=tl.getStudentAcademy()%></td>
<td><%=tl.getStudentMajor()%></td>
<td><%=tl.getStudentClass()%></td>
</tr>
<%} %>
</table>
<div>
<form action="studentcheck" method="post">
<input type="hidden" name="stu" value="china">
<input type="submit" value="确认">
</form>
</div>
</div>
</body>
</html>