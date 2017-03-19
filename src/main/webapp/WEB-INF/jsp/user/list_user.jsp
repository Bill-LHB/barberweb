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
<title>用户列表</title>
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
	<h1></h1>
	<div id="dsi">
		
	</div>
	<div>
	
		<form action="<%=basePath %>system/find.do" method="post" style="display:inline">	
			<input type="text" name="keyword" placeholder="用户名"/>
			<input type="submit" value="查询用户">
		</form>
	</div>
	
	
	<table border="1" style="position:relative; left:-80px;">
		<tr>
			<th>用户名</th>
			<th>角色</th>
			<th>状态</th>
			<th colspan="3">操作</th>
			<th>描述</th>
		</tr>
		<c:forEach items="${userList}" var="user">
			<tr>
				<td>${user.user_name}</td>
				<td>${user.role.name}</td>
				<td><c:if test="${!empty user.state && user.state==1}">审核通过</c:if>			
				<c:if test="${empty user.state || user.state==0}">待审核</c:if></td>	
				<td><a href="#" onclick="window.open('<%=basePath %>user/audituser/${user.user_id}.do','','width=400,height=400,top='+(screen.height-400)/2+',left='+(screen.width-400)/2 + '');">审核</a></td>
				<td><a href="#" onclick="window.open('<%=basePath %>user/updateuser/${user.user_id}.do','','width=400,height=400,top='+(screen.height-400)/2+',left='+(screen.width-400)/2 + '');">重置密码</a></td>
				<td><a href="<%=basePath %>user/deleteuser/${user.user_id}.do"  onclick="if(confirm('删除是不可恢复的，你确认要删除吗？')==false)return false;">删除</a></td>
				<td style="min-width:100px;">${user.description}</td>
			</tr>
			
		</c:forEach>
	</table>
	<span id="msg" style="color: red; font-size: 15px">${message}</span>
	
</body>
</html>