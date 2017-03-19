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
<title>车辆列表</title>
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
	<h1>车辆列表</h1>
	<div id="dsi">
		
	</div>
	<div>
		<form action="<%=basePath %>vehicle/find.do" method="post">
			<select name="type">
				<option value="plateNumber">车牌号</option>
				<option value="ownerphone">车主电话</option>
				<option value="ownerName">车主姓名</option>
			</select>
			<input type="text" name="keyword"/>
			<input type="submit" value="查询">
		</form>
	</div>
	
	
	
	<table border="1">
		<tr>
			<th>车牌号</th>
			<th>车主姓名</th>
			<th>车主电话</th>
			<th colspan="2">操作</th>
		</tr>
		<c:forEach items="${vehicleList}" var="vehicle">
			<tr>
				<td>${vehicle.plateNumber}</td>
				<td>${vehicle.ownerName }</td>
				<td>${vehicle.ownerphone}</td>
				<td><a href="<%=basePath %>vehicle/delete/${vehicle.plateNumber}.do">删除</a></td>
				<td><a href="<%=basePath %>vehicle/update/${vehicle.plateNumber}.do">修改</a></td>
			</tr>
			
		</c:forEach>
	</table>
	<span id="msg" style="color: red; font-size: 15px">${message}</span>
	
</body>
</html>