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
<title>会员列表</title>
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
<!-- 	<h1>会员列表</h1> -->
	<div id="dsi">
		
	</div>
	<div>
	
		<form action="<%=basePath %>member/findmember.do" method="post" style="display:inline">	
			<input type="text" name="keyword" placeholder="会员卡号/会员电话/会员身份证号/会员名" style="width:280px;"/>
			<input type="submit" value="查询">
		</form>
		<button style="display:inline"><a href="<%=basePath %>member/addmember.do" style="text-decoration:none;">添加会员</a></button>
	</div>
	
	
	<table border="1" style="position:relative;left:-150px;">
		<tr>
			<th style="width:100px;">会员头像</th>
			<th>会员名称</th>
			<th>会员卡号</th>
			<th>会员等级</th>
			<th>卡内余额</th>
			<th>会员状态</th>
			<th colspan="2" style="width:160px;">操作</th>
		</tr>
		<c:forEach items="${memberList}" var="member">
			<tr>
			<td style="height:100px;"><img alt="" src="<%=basePath %>upload/${member.member_portrait}" style="height:90px;width:90px;"></td>
			
			
			<td>${member.name}</td>
			<td>${member.member_number}</td>
			<td>${member.member_grade.menmberGrade_name}</td>
			<td>${member.member_money}</td>
			<c:if test="${member.member_status==0}">
				<td>挂失</td>
			</c:if>
			<c:if test="${member.member_status==0}">
				<td>可用</td>
			</c:if>
				<td><a href="<%=basePath %>system/deletemember/${member.member_id}.do">删除</a></td>
				<td><a href="<%=basePath %>system/updatemember/${member.member_id}.do">修改</a></td>	
			</tr>
			
		</c:forEach>
	</table>
	<span id="msg" style="color: red; font-size: 15px">${message}</span>
	
</body>
</html>