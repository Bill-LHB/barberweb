<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="<%=basePath%>resource/js/jquery.js"></script>
<script
	src="<%=basePath%>resource/js/jquery.mCustomScrollbar.concat.min.js"></script>
<title>添加模块</title>
<script type="text/javascript">

 $(document).ready(function() {
	// 在键盘按下并释放及提交后验证提交表单
	   $("#signupForm").validate({	   
		   rules:{
	    	 name:{
	         required:true
	       }
	     },
	     messages:{
	    	 name:{
	         required:"请输入模块名"
	       }
	     }

	});
 });
	function subform(){
	    var form = document.getElementById('signupForm');//获取表单dom
	    form.action="<%=basePath%>system/modules/operation.do";//重新设置提交url
	    form.submit();//提交表单
	    window.close();//关闭窗口
	 }

</script>
<style type="text/css">
.error{
color: Black; font-size: 12px;
}
</style>
</head>
<body>
	<form action="#" method="post" enctype="multipart/form-data" target="showpage" id="signupForm" onsubmit="return check()">	
		<input type="hidden" name="operation" value="${operation}">
		
		模块名:<input id="name" name="name" type="text" class="textbox"
			placeholder="模块名" value="${modules.name}"/><br /> <br /> 
		描述：
		<c:if test="${empty modules}">
			<textarea id="description" name="description"
				style="width: 200px; height: 80px;" >模块描述</textarea>
		</c:if>
		<c:if test="${!empty modules}">
		<input type="hidden" name="modules_id" value="${modules.modules_id}">
		<textarea id="description" name="description"
			style="width: 200px; height: 80px;" >${modules.description}</textarea>
				<br /> <br />
				<c:if test="${!empty modules.functionSet}">
		<table id="treeTable1" style="width: 100%;">
			<caption>功能详情</caption>
			<thead>
				<tr>
					<th style="width: 30%">功能名称</th>
					<th style="width: 20%">功能描述</th>
					<th style="width: 20%">功能代码</th>
					<th colspan="2">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${modules.functionSet}" var="function">
					<tr id="function.function_id">
						<td>${function.name}</td>
						<td>${function.description}</td>
						<td>${function.function_code}</td>
						<td><a href="<%=basePath %>system/deleteFunction/${function.function_id}.do">删除</a></td>
						<td><a href="<%=basePath %>system/updateFunction/${function.function_id}.do">修改</a></td>
						</tr>
				</c:forEach>
			</tbody>

		</table>
		</c:if>
				
		</c:if>			
		<span id="msg" style="color: red; font-size: 15px">${message}</span>
		<input type="button" value="提交" onclick="subform();">
		<!-- <input type="submit" value="提交" > -->
		<input type="reset" value="重置">	
	</form>
</body>
</html>