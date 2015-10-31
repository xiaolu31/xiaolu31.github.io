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

function submit_grade(){
var tableElement=document.getElementById("rounded-corner");
var size=tableElement.rows.length;
var ids="";

for(var i=1;i<=size-2;i++){
var checkboxElement=tableElement.rows[i].cells[0].firstElementChild;

if(checkboxElement.checked){
ids+=checkboxElement.value+"_";
}

}
var url="/Scholarship/tijiao_chengji?method=submit_grade&ids="+ids;
window.location.href=url;





}
</script>
</head>
<body>

 <div class="center_content">  
 
    <div id="right_wrap">
    <div id="right_content">             
    <h2>提交课程成绩</h2> 
                    
                    
<table id="rounded-corner">
   
    	<tr class="even">	
    		<th align="left">状态 </th>	
			<th align="left"   >课程名称</th>
			<th align="left" >课程学时</th>
			<th align="left" >课程学分</th>
			<th align="left" >课程类型</th>
			<th align="left" >课程成绩</th>
			<th align="left">成绩等级</th>
        </tr>
   <c:forEach var="grade" items="${student_grade_submit}">
    	<tr class="odd"> 
    		<td>
    			<input type="checkbox" value="${grade.course_id}"/>
    		</td>  
  			<td  >${grade.course_name}</td>
  			<td >${grade.course_hour}</td> 			
  			<td>${grade.course_credit}</td>			
  			<td >${grade.course_character}</td>	
  			<td >${grade.score}</td>	
  			<td >${grade.layer }</td>
		</tr>
    	</c:forEach >
    	<tr>
    	<td colspan="7" align="center">
    		<input type="button" value="提交" onclick="submit_grade()"/>
    	</td>
    	</tr>
     </table>
  </body>
</html>
