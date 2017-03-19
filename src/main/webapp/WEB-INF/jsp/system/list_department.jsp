<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>部门管理</title>
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
<script type="text/javascript" src="<%=basePath %>js/jquery.js"></script>
<script type="text/javascript">
	$(function(){
		$("tr td img").mouseenter (function(){
			var url = $(this).attr("src");
			$("#dsi").html("<img id=showImg src="+url+" width='200px' height='200px'>");
			$("#showImg").attr({src:url});
			$("#dsi").show();
		})
		$("tr td img").mouseleave (function(){
			$("#dsi").hide();
		})
	})
	
</script>
</head>
<body>

	<div id="dsi">
		
	</div>
	<div>
	
		<form action="<%=basePath %>system/finddepartment.do" method="post" style="display:inline">	
			<input type="text" name="keyword" placeholder="部门名"/>
			<input type="submit" value="查询部门">
		</form>
		<a href="#" style="text-decoration:none;" onclick="window.open('<%=basePath %>system/adddepartment.do','','width=400,height=180,top='+(screen.height-400)/2+',left='+(screen.width-400)/2 + '');"><button style="display:inline">添加部门</button></a>
	</div>
	
	
	<table border="1" style="position:relative;left:-150px;">
		<tr>
			<th>部门名称</th>
			<th>部门描述</th>
			
			<th colspan="3">操作</th>
		</tr>
		<c:forEach items="${departmentList}" var="department">
			<tr>
				<td>${department.name}</td>
				<td>${department.description }</td>
				<td><a href="<%=basePath %>system/deletedepartment/${department.department_id}.do" onclick="if(confirm('删除是不可恢复的，你确认要删除吗？')==false)return false;">删除</a></td>
				<td><a href="#" onclick="window.open('<%=basePath %>system/updatedepartment/${department.department_id}.do','','width=400,height=400,top='+(screen.height-400)/2+',left='+(screen.width-400)/2 + '');">修改</a></td>
				<td><a href="<%=basePath %>system/allpostbydepartment/${department.department_id}.do" >查看部门职位</a></td>
			</tr>
			
		</c:forEach>
	</table>
	<span id="msg" style="color: red; font-size: 15px">${message}</span>
	
</body>
</html>