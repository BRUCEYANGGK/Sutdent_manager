<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="mybean.CheckMessage" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>审核状态</title>
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
<%CheckMessage ms=(CheckMessage)request.getAttribute("stata"); %>
<div class="div1">
<h3>
<%=ms.getBackNews() %>
</h3>
</div>
</body>
</html>