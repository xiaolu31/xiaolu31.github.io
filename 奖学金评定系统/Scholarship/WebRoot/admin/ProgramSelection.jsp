<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="cn.itcast.web.domain.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>

<link href="../css/css.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="../css/style.css" />
<style>
#input1{
width:40px;
}
#d1{
margin-left:10px;
margin-top:10px;
}
#right_content{
margin-left:20px;
magin-top:30px;
}
#d2{


display:none;
}
#d3{
display:block;
}


.center_content{clear:both; width:99%; padding:0 0 40px 0;}
</style>
</head>
<body>
<br>
<div id="d1">
<form action="/Scholarship/ProgramSelection" method="post">
<table class="table" cellspacing="1" cellpadding="2" width="99%"  height="20%" align="center" 
border="0">
  <tbody>
    <tr>
      <th class="bg_tr" align="left" colspan="2" height="25">填写设置信息
     </th>
    </tr>
    <tr height="10%">
      <td class="td_bg" width="30%" align="center">选择方案
      <select id="planfangan"  name="plan" value="${selection.planoption}">
	  <option value="a0">请选择</option>
	  <option value="方案一"  <c:if test="${'方案一' eq selection.planoption}">selected</c:if> >方案一</option>
	  <option value="方案二" >方案二</option>
	  </select>
	  </td>
	  
	  
      
      
      
      
      
      
      
      
      <td class="td_bg" width="70%" >
      <div id="d3">
      <table>
	  <tr>
	  <td class="td_bg">
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;升一名额
	 
	  <select id="first_counter" name="first_counter" >
	  <option value="a0">请选择</option>
	   
	   <c:forEach var="year" begin="1" end="11">
  						<option value='${year}' ${selection.first_counter==year?'selected':''}>${year}</option>
   		</c:forEach>
		
		
	  </select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	  升二名额
	  <select id="second_counter" name="second_counter">
	  <option value="a0">请选择</option>
	   <c:forEach var="ye" begin="5" end="20">
  						<option value='${ye}' ${selection.second_counter==ye?'selected':''}>${ye}</option>
   		</c:forEach>
	  </select>
	  </td>
	  </tr>
	  <tr>
      <td class="td_bg" width="70%" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	  课程成绩所占比例<input type="text" id="input1" name="input1" value="${selection.input1}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	  论文成绩所占比例<input type="text" id="input1" name="input2" value="${selection.input2}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	  课外活动成绩所占比例<input type="text" id="input1" name="input3" value="${selection.input3}"/>
      </td>
	  </tr>
	  </table>
	  </div>
	  <div id="d2">
	  <table>
	  <tr>
	  <td class="td_bg">
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;升一名额
	 
	  <select id="first_counter" name="first_counter" >
	  <option value="a0">请选择</option>
	   
	   <c:forEach var="year" begin="1" end="11">
  						<option value='${year}' ${selection.first_counter==year?'selected':''}>${year}</option>
   		</c:forEach>
		
		
	  </select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	  升二名额
	  <select id="second_counter" name="second_counter">
	  <option value="a0">请选择</option>
	   <c:forEach var="ye" begin="5" end="20">
  						<option value='${ye}' ${selection.second_counter==ye?'selected':''}>${ye}</option>
   		</c:forEach>
	  </select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;降一名额
	 
	  <select id="three_counter" name="three_counter" >
	  <option value="0">请选择</option>
	   
	   <c:forEach var="vargian3" begin="0" end="5">
  						<option value='${vargian3}' ${selection.three_counter==vargian3?'selected':''}>${vargian3}</option>
   		</c:forEach>
		
		
	  </select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	  降二名额
	  <select id="four_counter" name="four_counter">
	  <option value="0">请选择</option>
	   <c:forEach var="vargian4" begin="0" end="5">
  						<option value='${vargian4}' ${selection.four_counter==vargian4?'selected':''}>${vargian4}</option>
   		</c:forEach>
	  </select>
	  </td>
	  </tr>
	  <tr>
      <td class="td_bg" width="70%" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	  课程成绩所占比例<input type="text" id="input1" name="input1" value="${selection.input1}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	  论文成绩所占比例<input type="text" id="input1" name="input2" value="${selection.input2}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	  课外活动成绩所占比例<input type="text" id="input1" name="input3" value="${selection.input3}"/>
      </td>
	  </tr>
	  </table>
	  
	  </div>
	  </td>
    <tr>
      <td  colspan="2" class="td_bg" align="center"  >
        <input type="submit" value="生成方案"  />
      </td>
     
    </tr>
    <tr> <td>${selection.outcome_admin} </td></tr>

  </tbody>
</table>
</form>
</div>
<div class="center_content">  
 
    <div id="right_content">             
     
                    
            
<table id="rounded-corner" width="80%">
   
<tr class="even" align="left" >
		<th align="left">学号</th>
		<th align="left">课程成绩均分</th>
		<th align="left">课程成绩等级C数</th>
		<th align="left">公益活动成绩</th>
		<th align="left">科研成绩</th>
		<th align="left">文艺活动成绩</th>
		<th align="left">职务成绩</th>
		<th align="left">奖学金原有等级</th>
		<th align="left">奖学金现有等级</th>
		<th align="left">总成绩</th>
</tr>
<c:forEach var="scholar" items="${scholarlist}">

<tr class="odd">
 <td>${scholar.id }</td>
 <td>${scholar.coursegrade }</td>
 <td>${scholar.gradelayer }</td>
 <td>${scholar.xianxue_counter}</td>
 <td>${scholar.sum_keyan}</td>
 <td>${scholar.sum_activity}</td>
 <td>${scholar.sum_position}</td>
 <td>${scholar.scholar_layer_old}</td>
 <td>${scholar.scholar_layer_new}</td>
 <td>${scholar.sum_jiangxuejin}</td>
</tr>
</c:forEach>
</table>
</div>
     </div>
     <script>  
  function showDiv1(){   
    var d3=document.getElementById("d3"); 
    var d2=document.getElementById("d2");  
    d3.style.display = "none";   
    d2.style.display = "block";
 }   
 function showDiv2(){   
    var d3=document.getElementById("d3"); 
    var d2=document.getElementById("d2");  
    d3.style.display = "block";   
    d2.style.display = "none";
 }  
 document.getElementById("planfangan").addEventListener("change",function(){
 	var name=this.options[this.selectedIndex].value;
 	if(name=="方案一"){
 		showDiv2();
 		console.log(name);
 	}else if(name=="方案二"){
 		showDiv1();
 	}
 },false);
 function showDiv3(){   
    var d3=document.getElementById("d5"); 
    
    d5.style.display = "block";   
    
 }    
</script> 
</body>
</html>