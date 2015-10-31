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
<script src="js/jquery.min.js"></script>
<script src="js/jquery.tabify.js" type="text/javascript" charset="utf-8"></script>
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
    <h2>已修课程成绩</h2> 
                    
                    
<table id="rounded-corner">
   
    	<tr class="even">		
            <th align="left">课程编号</th>
			<th align="left"  width="30%" >课程名称</th>
			<th align="left" width="15%">课程学时</th>
			<th align="left" width="15%">课程学分</th>
			<th align="left" width="15%">课程类型</th>
			<th align="left" width="15%">课程成绩</th>
			<th align="left" width="15%">成绩等级</th>
        </tr>
   <c:forEach var="grade" items="${student_grade}">
    	<tr class="odd">   
			<td>${grade.course_id}</td>
  			<td  style="width: 50px; height=10px;">${grade.course_name}</td>
  			<td width="10%">${grade.course_hour}</td> 			
  			<td width="15px">${grade.course_credit}</td>			
  			<td width="15%">${grade.course_character}</td>	
  			<td width="15%">${grade.score}</td>	
  			<td width="15%">${grade.layer }</td>
		</tr>
    	</c:forEach >
     </table>
     </div>
     </div>
     </div>
  </body>
</html>
