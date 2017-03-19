
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>添加员工</title>
		<script type="text/javascript"
			src="<%=basePath %>resource/js/jquery.js"></script>
		<script type="text/javascript"
			src="<%=basePath %>resource/js/fileUpload.js"></script>
		<script type="text/javascript"
			src="<%=basePath %>resource/js/ajaxfileupload.js"></script>
		<script type="text/javascript">
		function check(){
			var name=$("#employee_name").val(); //获取表单元素值
			var number=$("#employee_number").val(); //获取表单元素值
			var phone=$("#employee_phone").val(); //获取表单元素值
			var identity=$("#employee_identity").val(); //获取表单元素值
			var sex=$("#employee_sex").val(); //获取表单元素值
			var card=$("#employee_card").val(); //获取表单元素值
			var age=$("#employee_age").val(); //获取表单元素值
			var birth=$("#employee_birth").val(); //获取表单元素值
			var entry=$("#employee_entry").val(); //获取表单元素值
			
			
			if (name=="") { 			  
				$("#msg").text("员工姓名不能为空！");
				return false; 
			} 	
			if (number=="") { 			  
				$("#msg").text("员工编号不能为空！");
				return false; 
			} 
			if (phone=="") { 			  
				$("#msg").text("员工电话不能为空！");
				return false; 
			} 
			if (identity=="") { 			  
				$("#msg").text("员工身份证号不能为空！");
				return false; 
			} 
			if (sex=="") { 			  
				$("#msg").text("员工性别不能为空！");
				return false; 
			} 
			if (card=="") { 			  
				$("#msg").text("员工工资卡号不能为空！");
				return false; 
			} 
			
			if (birth=="") { 			  
				$("#msg").text("员工生日不能为空！");
				return false; 
			} 	
			
			if (entry=="") { 	  
				$("#msg").text("注册时间不能为空！");
				return false; 
			} 	
			
			if (!$("#phone").match(/^1[34578]\d{9}$/)) { 		  
				$("#msg").text("手机号码格式不正确！");
				return false; 
			} 
				return true;  	
		}
</script>
	</head>
	<body>
		<form action="<%=basePath %>employee/operate.do" method="post"
			enctype="multipart/form-data" onsubmit="return check()">
	*员工姓名:&nbsp;<input type="text" name="employee_name" id="employee_name">&nbsp;&nbsp;
	*员工编号:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="employee_number">&nbsp;&nbsp;&nbsp;
	&nbsp;
	<img alt="<%=basePath %>resource/upload/timg.jpg" src="<%=basePath %>resource/upload/${headurl}"
		style="position:relative;top:-50px; left:20px;" id="showImg">
	<input id="file" type="file" name="head">&nbsp;&nbsp;<br/><br/>
	<input type="hidden" name="headurl" id="headurl" value="${headurl}">&nbsp;&nbsp;<br/><br/>
	*员工电话:&nbsp;<input type="text" name="employee_phone" id="employee_phone">&nbsp;&nbsp;
	*员工身份证号:<input type="text" name="employee_identity" id="employee_identity"><br/><br/>
	*员工性别:
	<select name="employee_sex">
		<c:forEach items="#">
		</c:forEach>
		<option selected="selected" value="男">男</option>
		<option value="女">女</option>
	</select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;*员工职位:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<select name="p_id">
		<c:forEach items="${postlist}" var="post">
			<option value="${post.post_id}">${post.post_name}</option>
		</c:forEach>
	</select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	*员工工资卡号:<input type="text" name="employee_card" id="employee_card">&nbsp;&nbsp;<br/><br/>
	*员工年龄:&nbsp;<input type="number" id="employee_age" name="employee_age" min="16" max="65">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	
	
	
	&nbsp;*员工出生日期:<input type="date" id="employee_birth" name="employee_birth">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	*员工入职日期:&nbsp;<input type="date"  id="employee_entry" name="employee_entry" id="employee_entry">
	<br/><br/>
	<textarea id="description" name="description"
			style="width: 805px; height: 200px;" >备注</textarea>
	<p style="color: red; font-size: 15px">*表示为必填项</p>
	<span id="msg" style="color: red; font-size: 15px">${message}</span>
	<input type="submit" value="提交" />
		</form>
		
			
		
		
	</body>
</html>