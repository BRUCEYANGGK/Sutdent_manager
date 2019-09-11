<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="mybean.PasswordUp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改结果页面</title>
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
</style>
<body>
<div class="div1">
<%PasswordUp pd=(PasswordUp)request.getAttribute("password"); %>
<b>
<%=pd.getBackNews() %>
</b>
<a href="show.jsp" target="_top">返回信息页</a>
</div>
</body>
</html>