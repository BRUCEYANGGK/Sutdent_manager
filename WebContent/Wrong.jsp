<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>错误显示</title>
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
 <jsp:useBean id="register" class="mybean.Register" scope="request"/>
 <div class="div1">
<h1>注册失败！原因是：<br>
<jsp:getProperty property="backNews" name="register"/></h1></center>
</div>
</body>
</html>