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
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
<script
	src="<%=basePath%>resource/js/jquery.mCustomScrollbar.concat.min.js"></script>
	<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
<title>添加角色</title>
<script type="text/javascript">
$("#oldpassword").blur(function(){
    $.ajax({
        url:'<%=basePath%>user/checkpassword.do',
        type:"POST",
        data:$('#oldpassword').serialize() $('#uid').serialize(),
        success: function(data) {
            $("#result").text(data);
        }
    });
});

$().ready(function() {
	// 在键盘按下并释放及提交后验证提交表单
	  $("#signupForm").validate({
	    rules: {
	     /*  firstname: "required",
	      lastname: "required", */
	      user_name: {
	        required: true,
	        minlength: 2
	      },
	      password: {
	        required: true,
	        minlength: 5
	      },
	     
	      
	      checkpassword: {
	        required: true,
	        minlength: 5,
	        equalTo: "#password"
	      },
	    /*   email: {
	        required: true,
	        email: true
	      }, */
	   /*    topic: {
	        required: "#newsletter:checked",
	        minlength: 2
	      },
	      agree: "required"
	    }, */
	    messages: {
	      /* firstname: "请输入您的名字",
	      lastname: "请输入您的姓氏", */
	      user_name: {
	        required: "请输入用户名",
	        minlength: "用户名长度不能小于 2 个字母"
	      },
	      password: {
	        required: "请输入密码",
	        minlength: "密码长度不能小于 5 个字母"
	      },
	      confirm_password: {
	        required: "请输入密码",
	        minlength: "密码长度不能小于 5 个字母",
	        equalTo: "两次密码输入不一致"
	      },
	      /* email: "请输入一个正确的邮箱",
	      agree: "请接受我们的声明",
	      topic: "请选择两个主题" */
	    }
	});

	
	
</script>
</head>
<body>
	<form action="<%=basePath%>user/operation.do" method="post" enctype="multipart/form-data"
		onsubmit="return check()" id="signupForm">
		<input type="hidden" name="operation" value="${operation}">
		<c:if test="${operation=='adduser'}">
			*用户名:<input id="name" name="user_name" type="text" class="textbox"
			placeholder="用户名"/><br />
			*设置密码:<input type="password" name="password" class="password"><br/>
			*确认密码:<input type="password" name="checkpassword" class="checkpassword"><br/>
		</c:if> 
		<c:if test="${operation=='updateuser'}">
			&nbsp;用户名:&nbsp;&nbsp;&nbsp;&nbsp;<input id="name" name="user_name" type="text" class="textbox"
			placeholder="用户名" value="${user.user_name}" disabled="true"/><br /><br/>
			<input type="hidden" value="${user.user_id}" id="uid">
			*设置密码:&nbsp;<input type="password" name="password"class="password"><br/><br/>
			*确认密码:&nbsp;<input type="password" name="checkpassword"class="checkpassword">&nbsp;&nbsp;<br/><br/>
			<textarea id="description" name="description"
							style="width: 350px; height: 160px;" >${user.description}</textarea>
		</c:if> 
		<c:if test="${operation=='audituser'}">
			用户名:<input id="name" name="user_name" type="text" class="textbox"
			placeholder="用户名" value="${user.user_name}" disabled="true"/><br /> <br />		
			角色:<select name="roleid">
				<c:forEach items="${roleList}" var="role">
					<c:set var="command" value="0"/>
					<c:if test="${!empty userstate && role.role_id==userrole.role_id}">
						<c:set var="command" value="1"/>
					</c:if>
					<c:if test="${command==0}">
						<option value="${userrole.role_id}" >${userrole.name}</option>
					</c:if>
					<c:if test="${command==1}">
						<option value="${userrole.role_id}"  selected="selected">${userrole.name}</option>
					</c:if>
					</c:forEach>
				</select>	
			用户状态:<select name="stateid">
				<c:forEach items="${userStateList}" var="state">
					<c:set var="command" value="0"/>
					<c:if test="${ !empty userstate && state.userState_id==userstate.userState_id}">
						<c:set var="command" value="1"/>
					</c:if>
					<c:if test="${command==0}">
						<option value="${state.userState_id}" >${state.userState_name}</option>
					</c:if>
					<c:if test="${command==1}">
						<option value="${state.userState_id}"  selected="selected">${state.userState_name}</option>
					</c:if>
					</c:forEach>
				</select>
				<textarea id="description" name="description"
							style="width: 350px; height: 160px;" >${user.description}</textarea>
				<br/> <br/>
		</c:if>	
		<div id="result"></div>		 
		<span id="msg" style="color: red; font-size: 15px">${message}</span> <input
			type="submit" value="提交">
		<input type="reset" value="重置">	
	</form>
</body>
</html>