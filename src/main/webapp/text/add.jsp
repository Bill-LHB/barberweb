
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
		<title>添加车辆</title>
		<script type="text/javascript"
			src="<%=basePath %>resource/js/jquery.js"></script>
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
			<c:if test="${operate eq 'update'}">
		
				<input id="id" type="hidden" name="id" value="${vehicle.id}"/>
			</c:if>
			<c:if test="${operate eq 'add'}">
			
				<input id="id" type="hidden" name="id" value="0"/>
			</c:if>
			
			<input id="operate" type="hidden" name="operate" value="${operate}"/>
			车牌号：
			<input id="plateNumber" type="text" name="plateNumber" value="${vehicle.plateNumber}"/>
			<br />
			<br />
			车主姓名：
			<input id="ownerName" type="text" name="ownerName" value="${vehicle.ownerName}"/>
			<br />
			<br />
			车主电话：
			<input id="ownerphone" type="text" name="ownerphone" value="${vehicle.ownerphone}"/> 
			<br />
			<br />
			<span id="msg" style="color: red; font-size: 15px">${message}</span>
			<input type="submit" value="提交" />
		</form>
	</body>
</html>