<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@page import="mybean.Apartment" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>围合管理员信息</title>
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
 left:13vmin;
 top:10vmin;
}
</style>
<body>
<%Apartment ar=(Apartment)request.getAttribute("apartment"); %>
<div class="div1">
<h3><%=ar.getBackNews() %></h3>
<div class="div2">
<table border="1">
<tr>
<td>围合号</td><td>管理员</td>
</tr>
<tr>
<td><%=ar.getApartment() %></td>
<td><%=ar.getManger() %></td>
</tr>
</table>
<a href="show.jsp" target="_top">返回信息页</a>
</div>
</div>
</body>
</html>