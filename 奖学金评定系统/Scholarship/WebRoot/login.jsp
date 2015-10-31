<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String denglu="";
if (session.getAttribute("denglu")!=null){
denglu=session.getAttribute("denglu").toString();
}
session.setAttribute("denglu",null);


%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>login.html</title>
	
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    
    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->
    <link href="images/login.css" rel="stylesheet" type="text/css" />
<script src="images/jquery-1.9.1.min.js" type="text/javascript"></script>
<script type="text/javascript">
 var confirm='<%=denglu%>';
  if ('failure'==confirm){
  alert("用户名或密码错误");
  }
function t(){
$("#username").attr("value","");
$("#userpassword").attr("value","");
}

</script>

  </head>
  
  <body style="text-align:center;">
     <div id="login" >
	
	     <div id="top">
		      <div id="top_left"><img src="images/login_03.jpg" width="431" height="90"/></div>
			  <div id="top_center"></div>
		 </div>
		 <form action="/Scholarship/StudentServlet" method="post">
		 <div id="center">
		      <div id="center_left"></div>
			  <div id="center_middle">
			       <div id="user">用 户
			         <input type="text" name="textfield" id="username" />
			       </div>
				   <div id="password">密   码
				     <input type="password" name="textfield2" id="userpassword"  />
				   </div>
				   <div id="status">
					<input type="radio" name="status" value="0"  checked="checked"/>研究生&nbsp;
					<input type="radio" name="status" value="1"/>管理员
					</div> 
				   <div id="btn" ><input type="submit" value="登录"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				   <input type="reset" value="清空" onclick="t()"/>
				   </div>
			  
			  </div>
			  </form>
			  <div id="center_right"></div>		 
		 </div>
		 <div id="down">
		      <div id="down_left">
			      <div id="inf">
                       <span class="inf_text">版本信息</span>
					   <span class="copyright">学生管理子系统 2014 v2.0</span>
			      </div>
			  </div>
			  <div id="down_center"></div>		 
		 </div>

	</div> 
  </body>
</html>
