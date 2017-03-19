<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
 <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>功能列表</title>
<link rel="stylesheet" href="<%=basePath%>resource/css/pagination.css" />
<script src="<%=basePath%>resource/js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath%>resource/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="<%=basePath%>resource/js/jquery.pagination.js"></script>
<script type="text/javascript">
$(function(){
	//此demo通过Ajax加载分页元素
	var initPagination = function() {
		var num_entries = $("#hiddenresult div.result").length;
		// 创建分页
		$("#Pagination").pagination(num_entries, {
			num_edge_entries: 1, //边缘页数
			num_display_entries: 4, //主体页数
			callback: pageselectCallback,
			items_per_page: 1, //每页显示1项
			prev_text: "前一页",
			next_text: "后一页"
		});
	 };
	 
	function pageselectCallback(page_index, jq){
		var new_content = $("#hiddenresult div.result:eq("+page_index+")").clone();
		$("#Searchresult").empty().append(new_content); //装载对应分页的内容
		return false;
	}
	//ajax加载
	$("#hiddenresult").load("<%=basePath%>jsp/load.html", null, initPagination);

</script>
<style type="text/css"> 
	h1{
		text-align: center;
	}
	table{width:800px;
		margin: 0 auto;
	} 
	th{background:#FCA;
		padding: 5px; 
	} 
	td{text-align:center;} 
 	#dsi{
 		position:fixed;
		top:100px;
		left:200px
 	}
 	tr:hover {background-color:gray;}  /* 鼠标移动到表格 */
	tr:active {background-color:#c0c0c0;}  /* 鼠标点击时 */
 	td:hover {background-color:green;}  /* 鼠标移动到表格 */
	td:active {background-color:white;}  /* 鼠标点击时 */
</style> 
</head>
<body>



	<div>
	
		<form action="<%=basePath %>system/findfunction.do" method="post" style="display:inline">	
			<input type="text" name="keyword" placeholder="功能名"/>
			<input type="submit" value="查询功能">
			<input type="text" id="totalpages" value="${fn:length(functionList)}">
		</form>
		<a href="#" style="text-decoration:none;" onclick="window.open('<%=basePath %>system/addfunction.do','','width=420,height=240,top='+(screen.height-400)/2+',left='+(screen.width-400)/2 + '');"><button style="display:inline">添加功能</button></a>
	
	</div>
	 

	
	<table border="1" style="position:relative;left:-150px;">
		<tr>
			<th>模块名</th>
			<th>功能名</th>
			<th>功能描述</th>
			<th>功能编码</th>
			
			<th colspan="2">操作</th>
		</tr>
	</table>

		<%-- <c:forEach items="${functionList}" var="function">	
			<div class="result">
				<tr>
					<td>${function.modules.name}</td>
					<td>${function.name}</td>
					<td>${function.description }</td>
					<td>${function.function_code }</td>
					<td><a href="<%=basePath %>system/deletefunction/${function.function_id}.do" onclick="if(confirm('删除是不可恢复的，你确认要删除吗？')==false)return false;">删除</a></td>
					<td><a href="#" onclick="window.open('<%=basePath %>system/updatefunction/${function.function_id}.do','','width=400,height=400,top='+(screen.height-400)/2+',left='+(screen.width-400)/2 + '');">修改</a></td>			
				</tr>
			</div>		
		</c:forEach> --%>

	<span id="msg" style="color: red; font-size: 15px">${message}</span>
	<div id="Pagination" class="pagination"><!-- 这里显示分页 --></div>
	<div id="Searchresult">分页初始化完成后这里的内容会被替换。</div>
	<div id="hiddenresult" style="display:none;">
		<!-- 列表元素 -->
			 <div class="result">1</div>
	 <div class="result">2</div>
	 <div class="result">3</div>
	 <div class="result">4</div>
	 <div class="result">5</div>
	 <div class="result">6</div>
	 <div class="result">8</div>
	</div>
</form>
</body>
</html>