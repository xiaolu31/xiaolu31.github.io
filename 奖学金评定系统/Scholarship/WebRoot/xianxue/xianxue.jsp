<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'xianxue.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script src="js/jquery.min.js"></script>
  </head>
  <script>
  function submit1(){
		var strtype=new Array();
    	$("#paper tr").find("select[name='xianxue']").each(function(i){
     		strtype.push($(this).val());
    	});
    	var xianxue_counter=encodeURI(encodeURI(strtype.join()));
    		console.log(xianxue_counter);
    	location.href="/Scholarship/XianxueServlet?xianxue_counter="+xianxue_counter;
    
	}
</script>
  <body>
    <table  id="paper">
    	<tr>
    		<td ><font color=blue>选择公益活动次数：</font></td>
    		<td><select name="xianxue" id="fyXq_1" class="ui_select01">
                                <% for(int i=0;i<101;i++){%>
								<option value='<%=i%>'><%=i %></option>
								<%} %>
             </select>
    		</td>
    	</tr>
    
    </table>
    <input style="margin:20px" type="button" value="提交" onclick="submit1()"/>
  </body>
</html>
