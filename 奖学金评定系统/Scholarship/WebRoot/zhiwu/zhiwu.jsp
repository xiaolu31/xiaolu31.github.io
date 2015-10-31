<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'zhiwu.jsp' starting page</title>
    
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
 
  <body>
    <form action="/Scholarship/KeyanServlet" method="post">
  	<table id="paper">
  		
  		<tr>
  			<td><font color=blue>请选择职务对应类型：</font></td>
  			<td>
  				<select name="layer" id="fyXq_1" class="ui_select01">
                                <option value="a0">--请选择--</option>
                                <option value="校研究生会主席、研究生工作部主任、团委书记、辅导员">校研究生会主席、研究生工作部主任、团委书记、辅导员</option>
                                <option value="校研究生会副主席，学部研究生会主席，学部研究生工作部主任">校研究生会副主席，学部研究生会主席，学部研究生工作部主任</option>
                                <option value="学部研究生会副主席、团委副书记、各班班长、党支书、团支书">学部研究生会副主席、团委副书记、各班班长、党支书、团支书</option>
								<option value="学部研究生会办公室主任、部长、校研究生会各部部长">学部研究生会办公室主任、部长、校研究生会各部部长</option>
								<option value="其他干部">其他干部</option>
                            </select>
                            </td>
                            <td><font color=blue>具体职务名称:</font><input type="text" id="fyZldz_2" name="txt1" style="ui_input_txt01" /></td>
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
    var sel_1="请选择:";
    var sel_2="<select name='layer' class='ui_select01'><option value='a0'>--请选择--</option>"
                      +"<option value='校研究生会主席、研究生工作部主任、团委书记、辅导员'>校研究生会主席、研究生工作部主任、团委书记、辅导员</option><option value='校研究生会副主席，学部研究生会主席，学部研究生工作部主任'>校研究生会副主席，学部研究生会主席，学部研究生工作部主任</option><option value='学部研究生会副主席、团委副书记、各班班长、党支书、团支书'>学部研究生会副主席、团委副书记、各班班长、党支书、团支书</option>"
						+"<option value='学部研究生会办公室主任、部长、校研究生会各部部长'>学部研究生会办公室主任、部长、校研究生会各部部长</option>"+"<option value='其他干部'>其他干部</option>"+"</select>";
	var input_1="具体职务名称:<input type='text' id='fyZldz_2' name='txt1' style='ui_input_txt01'/>";
    var row="<tr><td >"+sel_1+"</td><td >"+sel_2+"</td><td>"+input_1+"</td></tr>";
    $(row).insertAfter($("#paper tr:eq("+rownum+")"));   
	}
	function remove1(){
	 var i=$("#paper tr").length-1; 
     $("#paper tr:eq("+i+")").remove();     
	}
	function submit1(){
		var strtype=new Array();
		var strdetail=new Array();
    	$("#paper tr").find("select[name='layer']").each(function(i){
     		strtype.push($(this).val());
    	});
    	$("#paper tr").find("input[name='txt1']").each(function(i){
     		strdetail.push($(this).val());
    	});
    	var positionType=encodeURI(encodeURI(strtype.join()));
    	var strname=encodeURI(encodeURI(strdetail.join()));
    	location.href="/Scholarship/ZhiwuServlet?positionType="+positionType+"&strname="+strname;
    	
    	
    	console.log(positionType);
    	
	}
</script>
  </body>
</html>
