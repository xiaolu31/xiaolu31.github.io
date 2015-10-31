<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML><HEAD>
<META http-equiv=Content-Type content="text/html; charset=gb2312">
<LINK href="css/admin.css" type="text/css" rel="stylesheet">
</HEAD>
<script type="text/javascript">
/**获得当前日期**/
		function  getDate01(){
			var time = new Date();
			var myYear = time.getFullYear();
			var myMonth = time.getMonth()+1;
			var myDay = time.getDate();
			if(myMonth < 10){
				myMonth = "0" + myMonth;
			}
			if(myDay < 10){
				myDay = "0" + myDay;
			}
			document.getElementById("day_day").innerHTML = myYear+"-"+myMonth+"-"+myDay;
		}
		window.onload=function (){
		var time = new Date();
			var myYear = time.getFullYear();
			var myMonth = time.getMonth()+1;
			var myDay = time.getDate();
			if(myMonth < 10){
				myMonth = "0" + myMonth;
			}
			//document.getElementById("yue_fen").innerHTML =  myYear + "." + myMonth;
			document.getElementById("day_day").innerHTML = myMonth;
		};
		</script>
<BODY onload=getDate01()>
<TABLE cellSpacing=0 cellPadding=0 width="90%" align=center border=0>
  <TR height=100>
    <TD align=middle width=100><IMG height="210" src="images/admin_p.jpg" 
      width="212"></TD>
    <TD width=60>&nbsp;</TD>
    <TD>
      <TABLE height=100 cellSpacing=0 cellPadding=0 width="475" border=0>
        
        <TR>
          <TD><strong><font size="4">当前时间：</font><span id="day_day"></span></strong></TD></TR>
        <TR>
          <TD style="FONT-WEIGHT: bold; FONT-SIZE: 16px"></TD></TR>
        <TR>
          <TD><font size="4"><strong>欢迎登陆大连理工大学管经学部奖学金管理系统！</strong></font></TD></TR></TABLE></TD></TR>
  <TR>
    <TD colSpan=3 height=10></TD></TR></TABLE>
</BODY></HTML>