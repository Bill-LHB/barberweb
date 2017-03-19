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
<title>添加角色</title>
<script type="text/javascript">
	function check() {
		var name = $("#name").val(); //获取表单元素值
		if (name == "") {
			$("#msg").text("角色名不能为空！");
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	<form action="<%=basePath%>system/role/operation.do" method="post"
		enctype="multipart/form-data" onsubmit="return check()">
		<input type="hidden" name="operation" value="${operation}"> <input
			type="hidden" name="allModulesList" value="${allModulesList}"
			id="allModulesList"> <input type="hidden" name="optfunction"
			value="${optfunction}" id="optfunction"> 角色名:<input id="name"
			name="name" type="text" class="textbox" placeholder="角色名"
			value="${role.name}" /><br /> <br />
		<table>
			<tr>
				<th style="width: 3%"></th>
				<th style="width: 30%">模块名称</th>
				<th style="width: 20%">功能名称</th>
				<th style="width: 20%">功能描述</th>
				<th style="width: 20%">功能代码</th>
			</tr>
			<c:if test="${!empty allFunctionList}">
				<c:forEach items="${allFunctionList.}" var="function">
					<c:set var="selection" value="0" />
					<c:if test="${!empty optFunctionList}">
						<c:forEach items="optFunctionList" var="optfunction">
							<c:if test="${optfunction.function_id==function.function_id}">
								<c:set var="selection" value="1" />
							</c:if>
						</c:forEach>
					</c:if>
					<tr id="${function.function_id}">
						<td>${function.modules.name}</td>
						<c:if test="${selection==1}">
							<td><input type="checkbox" name="functionid"
								class="tree_node_child_checkbox"
								value="${function.function_id} " checked="checked" />${function.modules.name}</td>
						</c:if>
						<c:if test="${selection==0}">
							<td><input type="checkbox" name="functionid"
								class="tree_node_child_checkbox" value="${function.function_id}" />${function.modules.name}</td>
						</c:if>
						<td class="center">${function.name}</td>
						<td class="center">${function.description}</td>
						<td class="center">${function.function_code}</td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
		描述：
		<c:if test="${empty role}">
			<textarea id="description" name="description"
				style="width: 200px; height: 80px;">模块描述</textarea>
		</c:if>
		<c:if test="${!empty role}">
			<textarea id="description" name="description"
				style="width: 1200px; height: 200px;">${role.description}</textarea>
		</c:if>
		<br /> <br /> <span id="msg" style="color: red; font-size: 15px">${message}</span>
		<input type="submit" value="提交"> <input type="reset"
			value="重置">
	</form>
</body>
</html>