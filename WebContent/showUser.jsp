<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="mybean.Register" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册成功</title>
</head>
<style>
.div1{
 width: 60vmin;
 height: 80vmin;
 position:absolute;
 left: 60vmin;
 top:10vmin;
 text-align: center;
 background:#eeeeee;
}
</style>
<body>
<div class="div1">
<%Register rg=(Register)request.getAttribute("register");%>
<h3>欢迎</h3>
<h3>
<%=rg.getStuName() %>
<%=rg.getBackNews() %>
</h3>
<br>
<br>
<a href="index.jsp" target="_top">返回登陆页</a>
</div>
</body>
</html>