<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'fail.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <script type="text/javascript">
  function resubmit(){
  var url="/Scholarship/tijiao_chengji";
window.location.href=url;
  }
  </script>
  <body>
    <h2 >你的成绩提交失败，请注意提交符合规则的成绩，要求如下<bold>公共必修课必须全部提交，大类基础课和专业基础课选出4门成绩上交，专业选修课选出两门课成绩上交!!!</bold></h2>
 <br>
<input type="button" value="重新提交" onclick="resubmit()"/>
  </body>
</html>
