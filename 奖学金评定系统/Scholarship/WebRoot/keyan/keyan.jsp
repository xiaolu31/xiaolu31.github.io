<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'keyan.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script src="js/jquery.min.js"></script>
	
	<style>
	.select{
	width:160px;
	height:22px;
	
	}
	#td{
	color:blue;
	fontsize:14px;
	}
	#d1{
	margin-left:30px;
	margin-top:30px;
	}
	</style>
  </head>
 
  <body >
    <form action="/Scholarship/KeyanServlet" method="post">
    <div id="d1">
  	<table id="paper">
  		
  		<tr>
  			<td id="td">请选择论文等级：</td>
  			<td>
  				<select name="academic" id="fyXq" class="select">
                                <option value="a0">--请选择--</option>
                                <option value="国际Top期刊">国际Top期刊</option>
                                <option value="国际A类期刊">国际A类期刊</option>
                                <option value="国际B类期刊">国际B类期刊</option>
								<option value="国际C类期刊、国内TOP期刊">国际C类期刊、国内TOP期刊</option>
								<option value="全国百优案例、专著">全国百优案例、专著</option>
								<option value="国内A类期刊">国内A类期刊</option>
								<option value="国内B类期刊">国内B类期刊</option>
								<option value="国内C类期刊">国内C类期刊</option>
								<option value="其他">其他</option>
                            </select>
                            </td>
                            <td id="td">
											刊载期刊：&nbsp;&nbsp;<input type="text" id="fyZldz_1" name="txt1" style="ui_input_txt02" />
							</td>
							 <td id="td">
											刊载文章标题：&nbsp;&nbsp;<input type="text" id="fyZldz_2" name="txt2" style="ui_input_txt02" />
							</td>
							<td id="td">文章第几作者：</td>
							<td>
							<select name="paperauthor" id="fyXq" class="select">
                                <option value="a0">--请选择--</option>
                                <option value="第一作者">第一作者</option>
                                <option value="第二作者">第二作者</option>
                                 <option value="第三作者">第三作者</option>
                                 </select>
							</td>
  		</tr>
  	</table>
  	</div>
  </form>
      <div id="d1">
							<input type="button" value="新增" class="ui_input_btn01" id="addBtn" onclick="add();" /> 
							<input type="button" value="删除" class="ui_input_btn01" onClick="remove1();" /> 
							<input type="button" value="提交" class="ui_input_btn01" id="importBtn" onclick="submit1();" />
							
						</div>
<script>
	function add(){		       
        //行号是从0开始，最后一行是新增、删除、保存按钮行 故减去2
    var rownum=$("#paper tr").length-1;
    var input_1="刊载期刊：&nbsp;&nbsp;<input type='text' name='txt1' style='ui_input_txt02' />";
    var input_2="刊载文章标题：&nbsp;&nbsp;<input type='text' id='fyZldz_2' name='txt2' style='ui_input_txt02' />";
    var sel_1="请选择论文等级:";
    var sel_2="<select name='academic' class='select'><option value='a0'>--请选择--</option>"
                      +"<option value='国际Top期刊'>国际Top期刊</option><option value='国际A类期刊'>国际A类期刊</option><option value='国际B类期刊'>国际B类期刊</option>"
						+"<option value='国际C类期刊、国内TOP期刊'>国际C类期刊、国内TOP期刊</option><option value='全国百优案例、专著'>全国百优案例、专著</option><option value='国内A类期刊'>国内A类期刊</option>"
							+"<option value='国内B类期刊'>国内B类期刊</option><option value='国内C类期刊'>国内C类期刊</option><option value='其他'>其他</option>"
                           +"</select>";
    var sel_3="文章第几作者：";                      
    var sel_4="<select name='paperauthor' id='fyXq' class='select'> <option value='a0'>--请选择--</option>"
    					+"<option value='第一作者'>第一作者</option>"
    					+"<option value='第二作者'>第二作者</option>"
    					+"<option value='第三作者'>第三作者</option>"
    					+"</select>";
                               
    var row="<tr><td id='td'>"+sel_1+"</td><td id='td' >"+sel_2+"</td><td id='td'>"+input_1+"</td><td id='td' >"+input_2+"</td><td id='td'>"+sel_3+"</td><td id='td'>"+sel_4+"</td></tr>";
    $(row).insertAfter($("#paper tr:eq("+rownum+")"));   
	}
	function remove1(){
	 var i=$("#paper tr").length-1; 
     $("#paper tr:eq("+i+")").remove();     
	}
	function submit1(){
		var papername1=new Array(),
		    papername2=new Array(),
		    papername3=new Array();
			papertypes=new Array();
		$("#paper tr").find("input[name='txt1']").each(function(i){
     		papername1.push($(this).val());
    	});
    	$("#paper tr").find("input[name='txt2']").each(function(i){
     		papername2.push($(this).val());
    	});
    	$("#paper tr").find("select[name='paperauthor']").each(function(i){
     		papername3.push($(this).val());
    	});
    	$("#paper tr").find("select[name='academic']").each(function(i){
     		papertypes.push($(this).val());
    	});
    	var strname1=encodeURI(encodeURI(papername1.join())),
    	    strname2=encodeURI(encodeURI(papername2.join())),
    	    strtype1=encodeURI(encodeURI(papername3.join())),
    		strtype2=encodeURI(encodeURI(papertypes.join()));
    	location.href="/Scholarship/KeyanServlet?strname1="+strname1+"&strname2="+strname2+"&strtype1="+strtype1+"&strtype2="+strtype2;	
    	
    	console.log(strname1);
    	console.log(strname2);
    	console.log(strtype1);
    	console.log(strtype2);
	}
</script>
  </body>
</html>
