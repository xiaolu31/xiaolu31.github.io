<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html >
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
    <h2>个人基本信息</h2> 
                    
                    
<table id="rounded-corner">
    <c:forEach var="student" items="${liststudent}">
    	<tr class="even">
        	
			
            <th>学号</th>
			<td>${student.id }</td>
            
        </tr>
  
    	<tr class="odd">
		    <th>姓名</th>
			<td>${student.name }</td>
        </tr>
    	<tr class="even">
		    <th>性别</th>
			<td>${student.sex}</td>
        	
        </tr>
    	<tr class="odd">
        	<th>出生日期</th>
			<td>${student.birthday}</td>
		</tr>
    	<tr class="even">
        	<th>专业</th>
			<td>${student.major}</td>
		</tr>
    	<tr class="odd">
        	<th>导师</th>
			<td>${student.guide_teacher}</td>
		</tr>
    	</c:forEach >
</table>

	
    
     </div>
     </div><!-- end of right content-->
                     
                    
    <div class="sidebar" id="sidebar">    
    </div>             
    
    
    <div class="clear"></div>
    </div> <!--end of center_content-->

    	
</body>
</html>