
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
		<title>添加会员</title>
		<script type="text/javascript"
			src="<%=basePath %>resource/js/jquery.js"></script>
					<script type="text/javascript"
			src="<%=basePath %>resource/js/fileUpload.js"></script>
		<script type="text/javascript"
			src="<%=basePath %>resource/js/ajaxfileupload.js"></script>
		<script type="text/javascript">
		
	
		
		
		function check(){
			var name=$("#member_name").val(); //获取表单元素值
			var number=$("#member_number").val(); //获取表单元素值
			var phone=$("#member_phone").val(); //获取表单元素值
			var money=$("#member_money").val(); //获取表单元素值
			
			var identity=$("#member_identity").val(); //获取表单元素值
			var sex=$("#member_sex").val(); //获取表单元素值
			var password=$("#member_password").val(); //获取表单元素值
			var pa=$("#password").val(); //获取表单元素值
			var register=$("#member_register").val(); //获取表单元素值
			
			if (name=="") { 			  
				$("#msg").text("会员姓名不能为空！");
				return false; 
			} 	
			if (number=="") { 			  
				$("#msg").text("会员卡号不能为空！");
				return false; 
			} 	
			if (phone=="") { 			  
				$("#msg").text("会员手机号不能为空！");
				return false; 
			} 	
			if (money=="") { 			  
				$("#msg").text("充值金额不能为空！");
				return false; 
			} 	
			if (identity=="") { 			  
				$("#msg").text("会员身份证不能为空！");
				return false; 
			} 	
			if (sex=="") { 			  
				$("#msg").text("会员性别不能为空！");
				return false; 
			} 	
			if (password=="") { 			  
				$("#msg").text("密码不能为空！");
				return false; 
			} 	
			if (pa=="") { 			  
				$("#msg").text("确认密码不能为空！");
				return false; 
			} 	
			if (register=="") { 			  
				$("#msg").text("注册时间不能为空！");
				return false; 
			} 	
			
			if (!password==pa) { 		  
				$("#msg").text("确认密码与设置密码不同，请重新填写！");
				return false; 
			}	
			
			if (!$("#member_phone").match(/^1[34578]\d{9}$/)) { 		  
				$("#msg").text("手机号码格式不正确！");
				return false; 
			} 
				return true;  	
		}
</script>
	</head>
	<body>
		<form action="<%=basePath %>member/operate.do" method="post"
			enctype="multipart/form-data" onsubmit="return check()">
	
	*会员姓名:<input type="text" name="member_name" id="member_name">&nbsp;&nbsp;
	*会员卡号:<input type="text" name="member_number" id="member_number">&nbsp;&nbsp;&nbsp;
	&nbsp;
	<img alt="<%=basePath %>resource/upload/timg.jpg" src="<%=basePath %>resource/upload/${headurl}"
		style="position:relative;top:-50px; left:20px;" id="showImg">
	<input id="file" type="file" name="head">&nbsp;&nbsp;<br/><br/>
	<input type="hidden" name="headurl" id="headurl" value="${headurl}">&nbsp;&nbsp;<br/><br/>
	
	*会员电话:<input type="text" name="member_phone" id="member_phone">&nbsp;&nbsp;
	*充值金额:<input type="text" name="member_money" id="member_money">&nbsp;&nbsp;
	*会员身份证号:<input type="text" name="member_identity" id="member_identity"><br/><br/>
	*会员性别:
	<select name="member_sex" id="member_sex">
		<option selected="selected" value="男">男</option>
		<option value="女">女</option>
	</select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	*设置密码:<input type="password" name="member_password" id="member_password">&nbsp;&nbsp;
	*确认密码:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="password" name="password" id="password">&nbsp;&nbsp;<br/><br/>
	&nbsp;会员住址:<input type="text" name="member_address" style="width: 710px;"><br/><br/>
	&nbsp;会员生日:<input type="date" name="member_birthday">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

	*注册时间:<input type="date" name="member_register" id="member_register"><br/><br/>
	<textarea id="description" name="member_remark"
			style="width: 780px; height: 200px;" >备注</textarea>
			<p style="color: red; font-size: 15px">*表示为必填项</p>
			<span id="msg" style="color: red; font-size: 15px">${message}</span>
			<input type="submit" value="提交" />
		</form>
		
	</body>
</html>