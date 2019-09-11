<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="mybean.StudentSelect" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生信息显示</title>
</head>
<style>
.div1{
width: 50vmin;
 height: 10vmin;
 position:absolute;
 top:20vmin;
 text-align: center;
 background:#ff0000;
 font-size:5vmin;
}
.div2{
 position:absolute;
 left: 20vmin;
 top:10vmin;
 text-align: center;
 background:#eeeeee;
}
.div3{
	height: 2vmin;
}
</style>
<body>
<jsp:useBean id="stusel" class="mybean.StudentSelect" scope="request"/>
<%StudentSelect st=(StudentSelect)request.getAttribute("selectstu");%>
<div class="div2">
<div class="div1"><div class=div3></div>查询情况：<%=st.getBackNews() %></div>
<table border="1">
<tr>
<th>学号</th><th>姓名</th><th>性别</th><th>身份证</th><th>家庭住址</th>
<th>宿舍号</th><th>学院</th><th>专业</th><th>班级</th>
</tr>
<tr>
<th><%=st.getStudentNumber() %></th>
<th><%=st.getStudentName() %></th>
<th><%=st.getStudentSex() %></th>
<th><%=st.getStudentID() %></th>
<th><%=st.getStudentAddress() %></th>
<th><%=st.getStudentApartment() %></th>
<th><%=st.getStudentAcademy() %></th>
<th><%=st.getStudentMajor() %></th>
<th><%=st.getStudentClass() %></th>
</tr>
</table>
<a href="show.jsp" target="_top">返回信息页</a>
</div>
</body>
</html>