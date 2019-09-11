<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="mybean.ClassMates" %>
     <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>同班同学</title>
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
<%ClassMates tu = (ClassMates)request.getAttribute("classmates");
List<ClassMates> list =tu.getList();
%>
<div class="div1">
<h3>查询结果：<%=tu.getBackNews()%></h3>
<div class="div2">
<table border="1">
<tr>
<td>学号</td><td>姓名</td>
</tr>
<%
for (ClassMates ss:list){%>
<tr>
<td><%=ss.getStudentNumber() %></td>
<td><%=ss.getStudentName() %></td>
</tr>
<%} %>
</table>
<a href="show.jsp" target="_top">返回信息页</a>
</div>
</div>
</body>
</html>