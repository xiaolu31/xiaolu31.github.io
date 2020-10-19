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
<style>
h2{
color:red;
}
</style>
  </head>
  
  
  <body>
    <div class="center_content">  
    <div id="right_wrap">
    <div id="right_content">             
    <h2 style="color:blue">提交的课程成绩</h2>                
<table id="rounded-corner">
        
    	<tr class="even">	
			<th align="left"   >课程名称</th>
			<th align="left" >课程学时</th>
			<th align="left" >课程学分</th>
			<th align="left" >课程类型</th>
			<th align="left" >课程成绩</th>
			<th align="left">成绩等级</th>
        </tr>
   <c:forEach var="grade" items="${gradelist}">
    	<tr class="odd">  
  			<td  >${grade.course_name}</td>
  			<td >${grade.course_hour}</td> 			
  			<td>${grade.course_credit}</td>			
  			<td >${grade.course_character}</td>	
  			<td >${grade.score}</td>	
  			<td >${grade.layer }</td>
		</tr>
    	</c:forEach >
    	
     </table>
	 <h2 style="color:blue">提交的科研成绩</h2>
	 <table id="rounded-corner">
   
    	<tr class="even">	
			<th align="left" >期刊类型</th>
			<th align="left" >期刊名称</th>
			<th align="left" >文章标题</th>
        </tr>
   <c:forEach var="keyan" items="${keyanlist}">
    	<tr class="odd"> 
  			<td  >${keyan.keyantype}</td>
  			<td >${keyan.qikanname}</td> 			
  			<td>${keyan.papertitle}</td>			
  			
		</tr>
    	</c:forEach >
     </table>
	 <h2 style="color:blue">提交的文艺比赛</h2>
	 <table id="rounded-corner">
   
    	<tr class="even">	
			<th align="left" >获奖类型</th>
			<th align="left" >获奖等级</th>
			<th align="left" >比赛项目</th>
        </tr>
   <c:forEach var="activity" items="${activitylist}">
    	<tr class="odd"> 
  			<td  >${activity.activitytype}</td>
  			<td >${activity.activitylayer}</td> 			
  			<td>${activity.activitydetail}</td>			
  			
		</tr>
    	</c:forEach >
     </table>
	 <h2 style="color:blue">提交的职务</h2>
	 <table id="rounded-corner">
   
    	<tr class="even">	
			<th align="left" >职务类型</th>
			<th align="left" >具体职务</th>
			
        </tr>
   <c:forEach var="position" items="${positionlist}">
    	<tr class="odd"> 
  			<td  >${position.positiontype}</td>
  			<td >${position.positiondetail}</td>
  					
		</tr>
    	</c:forEach >
     </table>
     <h2 style="color:blue">提交的公益活动</h2>
     <table id="rounded-corner">
   
    	<tr class="even">	
		 <th align="left" >公益活动加分</th>
     <td ><%=request.getSession().getAttribute("xianxue_counter") %></td>  	
			
			
        </tr>
   
     </table>
    </div>
    </div>
    </div>
  </body>
</html>
