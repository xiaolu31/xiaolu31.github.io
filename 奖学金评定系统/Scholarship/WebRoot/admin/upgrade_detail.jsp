<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Panelo - Free Admin Template</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />

<!-- jQuery file -->
<script src="../js/jquery.min.js"></script>
<script src="../js/jquery.tabify.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
var $ = jQuery.noConflict();
$(function() {
$('#tabsmenu').tabify();
$(".toggle_container").hide(); 
$(".trigger").click(function(){
	$(this).toggleClass("active").next().slideToggle("slow");
	return false;
});
});
</script>
</head>
<body>

 <div class="center_content">  
 
    <div id="right_wrap">
    <div id="right_content">             
    <h2>奖学金升档学生信息</h2> 
                    
                    
<table id="rounded-corner">
   
    	<tr class="even">		
            <th align="left">学生学号</th>
			<th align="left"  >课程成绩均分</th>
			<th align="left" >课程等级C数</th>
			<th align="left" >公益活动成绩</th>
			<th align="left" >科研成绩</th>
			<th align="left" >文艺活动成绩</th>
			<th align="left">职务成绩</th>
			<th align="left" >奖学金评比前等级</th>
			<th align="left" >奖学金评比后等级</th>
			<th align="left" >总成绩得分</th>
        </tr>
   <c:forEach var="upgrade_detail" items="${upgrade_id_detail}">
    	<tr class="odd">   
			<td>${upgrade_detail.id}</td>
  			<td >${upgrade_detail.coursegrade}</td>
  			<td >${upgrade_detail.gradelayer}</td> 			
  			<td >${upgrade_detail.xianxue_counter}</td>			
  			<td >${upgrade_detail.sum_keyan}</td>	
  			<td >${upgrade_detail.sum_activity}</td>	
  			<td >${upgrade_detail.sum_position}</td>
			<td >${upgrade_detail.scholar_layer_old}</td>
			<td >${upgrade_detail.scholar_layer_new}</td>
			<td >${upgrade_detail.sum_jiangxuejin}</td>
		</tr>
    	</c:forEach >
     </table>
     </div>
     </div>
     </div>
  </body>
</html>