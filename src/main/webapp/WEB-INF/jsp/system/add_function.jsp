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
<title>添加功能</title>
<script type="text/javascript">
	function check() {
		var name = $("#name").val(); //获取表单元素值
		if (name == "") {
			$("#msg").text("功能名不能为空！");
			return false;
		}
		return true;
	}

	function subform(){
	    var form = document.getElementById('myForm');//获取表单dom
	    form.action="<%=basePath%>system/fun/operation.do";//重新设置提交url
	    form.submit();//提交表单
	    window.close();//关闭窗口
	 }

</script>
</head>
<body>
	<form action="#" method="post" enctype="multipart/form-data"
		onsubmit="return check()" target="showpage" id="myForm">
		<input type="hidden" name="operation" value="${operation}"> 
		功能名:<input id="name" name="name" type="text" class="textbox"
			placeholder="功能名" value="${function.name}"/><br /><br />
		所属模块:
		<c:if test="${!empty function}">
			<input type="hidden" name="function_id" value="${function.function_id}">
			<select name="m_id" style="width:20"> 
				<c:forEach items="${allModulesList}" var="modules">				
					<c:if test="${function.modules.modules_id==modules.modules_id}">
						<option value="${modules.modules_id}" selected="selected">${modules.name}</option>
					</c:if>
					<c:if test="${function.modules.modules_id!=modules.modules_id}">
						<option value="${modules.modules_id}">${modules.name}</option> 
					</c:if>
				</c:forEach>
			</select>
		</c:if>	
		<c:if test="${empty function}">
			<select name="m_id" style="width:20"> 
				<c:forEach items="${allModulesList}" var="modules">
					<option value="${modules.modules_id}">${modules.name}</option> 					
				</c:forEach>
			</select> 
		</c:if><br /> <br />
		功能代码:	
			<input id="function_code" name="function_code" type="text" class="textbox"
			placeholder="功能代码" value="${function.function_code}"/><br /> <br />		
		描述：
			<c:if test="${empty function}">
		<textarea id="description" name="description"
			style="width: 200px; height: 80px;" >功能描述</textarea>
			</c:if>
			<c:if test="${!empty function}">
		<textarea id="description" name="description"
			style="width: 200px; height: 80px;" >${function.description}</textarea>			
	
		</c:if>
	
		<span id="msg" style="color: red; font-size: 15px">${message}</span>
		<input type="button" value="提交" onclick="subform();">
<!-- 		<input type="submit"> -->
		<input type="reset" value="重置">	
	</form>
</body>
</html>