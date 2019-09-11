<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@page import="mybean.InsertStudent" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>提交信息审核页面</title>
</head>
<style>
.div1{
 position:absolute;
 left: 24vmin;
 top:10vmin;
 text-align: center;
 background:#eeeeee;
}
</style>
<body>
<%InsertStudent mesg = (InsertStudent)request.getAttribute("InsertMess"); %>
<div class="div1">
<div>提交结果：<%=mesg.getBackNews()%></div>
<div>
<table border="1">
<tr>
<th>学号</th><th>姓名</th><th>性别</th><th>身份证</th><th>家庭住址</th>
<th>宿舍号</th><th>学院</th><th>专业</th><th>班级</th>
</tr>
<tr>
<th><%=mesg.getStudentNumber() %></th>
<th><%=mesg.getStudentName() %></th>
<th><%=mesg.getStudentSex() %></th>
<th><%=mesg.getStudentID() %></th>
<th><%=mesg.getStudentAddress() %></th>
<th><%=mesg.getStudentApartment() %></th>
<th><%=mesg.getStudentAcademy() %></th>
<th><%=mesg.getStudentMajor() %></th>
<th><%=mesg.getStudentClass() %></th>
</tr>
</table>
</div>
<a href="show.jsp" target="_top">返回信息页</a>
</div>
</body>
</html>