<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'UpdatePassword.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style>
body {background-color:#97FFFF;}
</style>
  </head>
  
  <body>
  <h3 >&nbsp;&nbsp; 修改用户密码</h3>
 
   <table >
   <tr> <th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; 用户名：</th>
   <td><%=request.getSession().getAttribute("username") %></td>
   </tr>
   <tr> <th>&nbsp;&nbsp;&nbsp; 输入新密码：</th>
   <td><input type="text" name="txt1" id="txt1"/></td>
   </tr>
   <tr> <th>再次输入新密码：</th>
   <td><input type="text" name="txt2" id="txt2"/></td>
 	<td>${tishi}</td>
   </tr>
   <tr>
   <td colspan="2" align="center"><input type="button" value="确定" id="btok"/></td>
   </tr>
  
   </table>
   
   </form>
   <script>
   		var btok=document.getElementById("btok");
   		btok.onclick=function(e){
   			var txt1=document.getElementById("txt1").value,
   				txt2=document.getElementById("txt2").value;
   			if(txt1!=txt2){
   				alert("两次输入的密码不一致 ");
   			}else{
   				location.href="/Scholarship/UpdadePassword?pasword="+txt1;
   			}
   		}
   </script>
  </body>
</html>
