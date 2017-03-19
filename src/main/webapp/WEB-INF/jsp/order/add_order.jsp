
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
			var phone=$("#ownerphone").val(); //获取表单元素值
			var plateNumber=$("#plateNumber").val(); //获取表单元素值
			var ownerName=$("#ownerName").val(); //获取表单元素值
			
			if (plateNumber=="") { 			  
				$("#msg").text("车牌号不能为空！");
				return false; 
			} 	
			
			if (ownerName=="") { 			  
				$("#msg").text("车主姓名不能为空！");
				return false; 
			} 	
			
			if (phone=="") { 	  
				$("#msg").text("车主手机号码不能为空！");
				return false; 
			} 	
			
			if (!$("#ownerphone").match(/^1[34578]\d{9}$/)) { 		  
				$("#msg").text("手机号码格式不正确！");
				return false; 
			} 
				return true;  	
		}
</script>
	</head>
	<body>
		<form action="<%=basePath %>vehicle/operate.do" method="post"
			enctype="multipart/form-data" onsubmit="return check()">
	*员工姓名:&nbsp;<input type="text" name="Employee_name">&nbsp;&nbsp;
	*员工编号:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="Employee_number">&nbsp;&nbsp;&nbsp;
	&nbsp;
	
	
	
	
	员工头像:&nbsp;<input type="file" name="Employee_headurl">&nbsp;&nbsp;<br/><br/>
	
	
	
	
	
	
	
	
	*员工电话:&nbsp;<input type="text" name="Employee_phone">&nbsp;&nbsp;
	*员工身份证号:<input type="text" name="private String Employee_identity"><br/><br/>
	

	*员工性别:
	<select name="Employee_sex">
		<c:forEach items="#">
		</c:forEach>
		<option selected="selected" value="男">男</option>
		<option value="女">女</option>
	</select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;*员工职位:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<select name="Employee_post">
		<option selected="selected" value="男">男</option>
		<option value="女">女</option>
	</select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	*员工工资卡号:<input type="text" name="Employee_card">&nbsp;&nbsp;<br/><br/>
	*员工年龄:&nbsp;<input type="number" name="Employee_age" min="16" max="65">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	
	
	
	&nbsp;*员工出生日期:<input type="date" name="Employee_birth">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	*员工入职日期:&nbsp;<input type="date" name="Employee_birth">
	<br/><br/>
	<textarea id="description" name="Member_remark"
			style="width: 805px; height: 200px;" >备注</textarea>
			<p style="color: red; font-size: 15px">*表示为必填项</p>
			<span id="msg" style="color: red; font-size: 15px">${message}</span>
			<input type="submit" value="提交" />
		</form>
		<form action="">
			<input id="file" type="file" name="Employee_headurl">&nbsp;&nbsp;<br/><br/>
		</form>
		
	</body>
</html>