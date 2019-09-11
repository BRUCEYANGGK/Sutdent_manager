<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>未登录</title>
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
<jsp:useBean id="login" class="mybean.Login" scope="session"/>
<div class="div1">
<h1>
<jsp:getProperty property="backNews" name="login"/>
</h1>
</div>
</body>
</html>