<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生信息页面</title>
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
.div2{
 position: relative;
 left:7vmin;
 top:-2vmin;
 width: 50vmin;
 text-align: center;
 background:#eeeeee;
}
.div3{
 width:50vmin;
 position: relative;
 top:0vmin;
 left:5vmin;
 text-align: left;
 background:#eeeeee;
}
</style>
<body>
<div class="div1">
 <jsp:useBean id="login" class="mybean.Login" scope="session"/>
 <h1>
<jsp:getProperty property="backNews" name="login"/>
</h1>
<div class="div2">
<table>
<tr>
<td><a href="UpdataPassW.jsp" target="_top">修改密码</a></td>
<td><a href="InsertStudent.jsp" target="_top">填写新生信息</a></td>
<td><a href="StuSelect.jsp" target="_top">查询个人信息</a></td>
</tr>
<tr>
<td><a href="TeacherSelect.jsp" target="_top">老师信息</a></td>
<td><a href="ClassMates.jsp" target="_top">查看同班同学</a></td>
<td><a href="Mangers.jsp" target="_top">围合管理人员</a></td>
</tr>
</table>
</div>
<div class="div3">
使用说明：<br>本系统班级号一律采用四位如："0001";
<br>学号使用13位
<br>如："2016141462060";
<br>身份证号18位，如："522501163008240321";
<br>宿舍号2位
<br>如："01";
<br>教师编号4位
<br>如："0001";
<br>学院编号2位
<br>如："01";
<br>围合号2位
<br>如："01"。
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<a href="index.jsp" target="_top">返回登陆页</a>
</div>
</div>
</body>
</html>