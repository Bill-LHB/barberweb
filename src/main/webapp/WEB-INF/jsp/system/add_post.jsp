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
<title>添加职位</title>
<script type="text/javascript">
	function check() {
		var name = $("#post_name").val(); //获取表单元素值
		var wage = $("#post_wage").val(); //获取表单元素值
		
		if (name == "") {
			$("#msg").text("职位名不能为空！");
			return false;
		}
		if (wage == "") {
			$("#msg").text("职位基本工资不能为空！");
			return false;
		}
		return true;
	}
	function subform(){
	    var form = document.getElementById('myForm');//获取表单dom
	    form.action="<%=basePath%>system/post/operation.do";//重新设置提交url
	    form.submit();//提交表单
	    window.close();//关闭窗口
	 }
</script>
</head>
<body>
	<form action="#" method="post" enctype="multipart/form-data"
		onsubmit="return check()" target="showpage" id="myForm">
		<input type="hidden" name="operation" value="${operation}">
		职位名称:<input id="post_name" name="post_name" type="text" class="textbox"
			placeholder="职位名" value="${post.post_name}"/><br /> <br /> 
			
			
			
		所属部门:
		<c:if test="${!empty post}">	
			<select name="department_id"> 
				<c:forEach items="${allDepartmentList}" var="d">				
					<c:if test="${post.department.department_id==d.department_id}">
						<option value="${d.department_id}" selected="selected">${d.name}</option>
					</c:if>
					<c:if test="${ost.department.department_id!=d.department_id}">
						<option value="${d.department_id}">${d.name}</option> 
					</c:if>
				</c:forEach>
			</select>
		</c:if>	
		<c:if test="${empty post}">
			<select name="department_id"> 
				<c:forEach items="${allDepartmentList}" var="d">
					<option value="${d.department_id}">${d.name}</option> 					
				</c:forEach>
			</select> 
		</c:if>
		
		基本工资:	
			<input id="post_wage" name="post_wage" type="text" class="textbox"
			placeholder="基本工资" value="${post.post_wage}"/><br /> <br />		
		描述：
			<c:if test="${empty post}">
		<textarea id="description" name="description"
			style="width: 200px; height: 80px;" >职位描述</textarea>
			</c:if>
			<c:if test="${!empty post}">
		<textarea id="description" name="description"
			style="width: 200px; height: 80px;" >${post.description}</textarea>			
		<br /> <br />
		</c:if>
	
		<span id="msg" style="color: red; font-size: 15px">${message}</span><input type="button" value="提交" onclick="subform();">
		<input type="reset" value="重置">	
	</form>
</body>
</html>