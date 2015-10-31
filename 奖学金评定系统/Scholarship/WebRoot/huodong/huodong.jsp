<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'huodong.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <script src="js/jquery.min.js"></script>
  <body>
    <form action="/Scholarship/Servlet" method="post">
  	<table id="paper">
  		
  		<tr>
  			<td><font color=blue>请选择</font></td>
  			<td><font color=blue>类型：</font><select name="layer" id="fyXq_1" class="ui_select01">
                                <option value="a0">--请选择--</option>
                                <option value="国家">国家</option>
                                <option value="省">省</option>
                                <option value="市">市</option>
								<option value="校">校</option>
                            </select>
                            </td>
                            <td><font color=blue>等级：</font><select name="prize" id="fyXq_2" class="ui_select02">
                                <option value="a0">--请选择--</option>
                                <option value="一等奖">一等奖</option>
                                <option value="二等奖">二等奖</option>
                                <option value="三等奖">三等奖</option>
								<option value="三等奖以下">三等奖以下</option>
                            </select>
                            </td>
							 <td>
										<font color=blue>	具体比赛项目：</font>&nbsp;&nbsp;<input type="text" id="fyZldz_2" name="txt1" style="ui_input_txt01" />
							</td>
  		</tr>
  	</table>
  </form>
      <div id="box_bottom">
							<input type="button" value="新增" class="ui_input_btn01" id="addBtn" onclick="add();" /> 
							<input type="button" value="删除" class="ui_input_btn01" onClick="remove1();" /> 
							<input type="button" value="提交" class="ui_input_btn01" id="importBtn" onclick="submit1();" />
							
						</div>
<script>
	function add(){		       
        //行号是从0开始，最后一行是新增、删除、保存按钮行 故减去2
    var rownum=$("#paper tr").length-1;
    var input_1="具体比赛项目：&nbsp;&nbsp;<input type='text' name='txt1' style='ui_input_txt02' />";
    var sel_1="请选择";
    var sel_2="类型：<select name='layer' class='ui_select01'><option value='a0'>--请选择--</option>"
                      +"<option value='国家'>国家</option><option value='省'>省</option><option value='市'>市</option>"
						+"<option value='校'>校</option>"+"</select>";
	var sel_3="等级：<select name='prize' class='ui_select01'><option value='a0'>--请选择--</option>"
                      +"<option value='一等奖'>一等奖</option><option value='二等奖'>二等奖</option><option value='三等奖'>三等奖</option>"
						+"<option value='三等奖以下'>三等奖以下</option>"+"</select>";
    var row="<tr><td >"+sel_1+"</td><td >"+sel_2+"</td><td >"+sel_3+"</td><td >"+input_1+"</td></tr>";
    $(row).insertAfter($("#paper tr:eq("+rownum+")"));   
	}
	function remove1(){
	 var i=$("#paper tr").length-1; 
     $("#paper tr:eq("+i+")").remove();     
	}
	function submit1(){
		var papername=new Array(),
		    papertype2=new Array(),
			papertype1=new Array();
		$("#paper tr").find("input[name='txt1']").each(function(i){
     		papername.push($(this).val());
    	});
    	$("#paper tr").find("select[name='prize']").each(function(i){
     		papertype2.push($(this).val());
    	});
    	$("#paper tr").find("select[name='layer']").each(function(i){
     		papertype1.push($(this).val());
    	});
    	var strname=encodeURI(encodeURI(papername.join())),
    	    strtype1=encodeURI(encodeURI(papertype1.join())),
    		strtype2=encodeURI(encodeURI(papertype2.join()));
    	location.href="/Scholarship/HuodongServlet?strname="+strname+"&strtype1="+strtype1+"&strtype2="+strtype2;	
    	
    	console.log(strname);
    	console.log(strtype1);
    	console.log(strtype2);
	}
</script>
  </body>
</html>