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
<script src="<%=basePath%>resource/js/jquery.js"></script>
<script
	src="<%=basePath%>resource/js/jqPaginator.js"></script>
<script type="text/javascript" src="<%=basePath %>js/jquery.js"></script>
<script type="text/javascript">
$.jqPaginator('#pagination1', {
    totalPages: 100,
    visiblePages: 10,
    currentPage: 3,
    onPageChange: function (num, type) {
        $('#p1').text(type + '：' + num);
    }
});
$.jqPaginator('#pagination2', {
    totalPages: 100,
    visiblePages: 10,
    currentPage: 3,
    prev: '<li class="prev"><a href="javascript:;">Previous</a></li>',
    next: '<li class="next"><a href="javascript:;">Next</a></li>',
    page: '<li class="page"><a href="javascript:;">{{page}}</a></li>',
    onPageChange: function (num, type) {
        $('#p2').text(type + '：' + num);
    }
});

	/* $(function(){
		
		 var totalpages=$("#totalpages").val();
		
		$('#id').jqPaginator({
			  
				totalPages: totalpages,
			    visiblePages: 15,
			    currentPage: 1,
			    onPageChange: function (num, type) {
			        $('#text').html('当前第' + num + '页');
			    }
			});	
	}); */
	/* 	$("tr td img").mouseenter (function(){
			var url = $(this).attr("src");
			$("#dsi").html("<img id=showImg src="+url+" width='200px' height='200px'>");
			$("#showImg").attr({src:url});
			$("#dsi").show();
		})
		$("tr td img").mouseleave (function(){
			$("#dsi").hide();
		}) */
	
	
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
	   <p id="p1">hjgfj</p>
    <ul class="pagination" id="pagination1"></ul>
    <p id="p2">3532545</p>
    <ul class="pagination" id="pagination2"></ul>
	<div id="dsi">
		
	</div>
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
		<c:forEach items="${functionList}" var="function">
			<tr>
				<td>${function.modules.name}</td>
				<td>${function.name}</td>
				<td>${function.description }</td>
				<td>${function.function_code }</td>
				<td><a href="<%=basePath %>system/deletefunction/${function.function_id}.do" onclick="if(confirm('删除是不可恢复的，你确认要删除吗？')==false)return false;">删除</a></td>
				<td><a href="#" onclick="window.open('<%=basePath %>system/updatefunction/${function.function_id}.do','','width=400,height=400,top='+(screen.height-400)/2+',left='+(screen.width-400)/2 + '');">修改</a></td>
				
			</tr>
			
		</c:forEach>
	</table>
	<span id="msg" style="color: red; font-size: 15px">${message}</span>
	
</body>
</html>