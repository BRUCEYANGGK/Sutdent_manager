<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@page import="mybean.Teacher" %>
     <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>教师信息显示</title>
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
 position: relative;
 left:2vmin;
 top:10vmin;
}
</style>
<body>
<%Teacher tr=(Teacher)request.getAttribute("academy");
List<Teacher> list =tr.getList();
%>
<div class="div1">
<h3><%=tr.getBackNews() %></h3>
<div class="div2">
<table border="1">
<tr>
<td>教师编号</td><td>教师名</td><td>学院名</td>
</tr>
<%for (Teacher tl:list) {%>
<tr>
<td><%=tl.getTeacherNumber() %></td>
<td><%=tl.getTeacherName() %></td>
<td><%=tl.getAcademyName() %></td>
</tr>
<%} %>
</table>
<a href="show.jsp" target="_top">返回信息页</a>
</div>
</div>
</body>
</html>