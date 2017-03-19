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
	function check() {
		var password = $(".password").val(); //获取表单元素值
		var cpassword = $(".checkpassword").val(); //获取表单元素值
		var name = $(".textbox").val(); //获取表单元素值
		var opassword = $(".oldpassword").val(); //获取表单元素值
		if (name == "") {
			$("#msg").text("用户名不能为空！");
			return false;
		}
		if (cpassword == "") {
			$("#msg").text("确认密码不能为空！");
			return false;
		}
		if (password == "") {
			$("#msg").text("密码不能为空！");
			return false;
		}
		if (opassword == "") {
			$("#msg").text("原密码不能为空！");
			return false;
		}
		if (!password ==cpassword) {
			$("#msg").text("确认密码与设置密码不相同，请重新输入！");
			return false;
		}
		return true;
	}
	function subform(){
	    var form = document.getElementById('myForm');//获取表单dom
	    form.action="<%=basePath%>user/checkpassword.do";//重新设置提交url
	    form.submit();//提交表单
	    window.close();//关闭窗口
	 }
</script>
</head>
<body>
	<form action="#" method="post" enctype="multipart/form-data"
		onsubmit="return check()"  target="showpage" id="myForm">
			&nbsp;用户名:&nbsp;&nbsp;&nbsp;&nbsp;<input id="name" name="user_name" type="text" class="textbox"
			placeholder="用户名" value="${presentUser.user_name}" disabled="true"/><br /><br/>
			*原密码:&nbsp;&nbsp;&nbsp;&nbsp;<input type="password" name="oldpassword" class="oldpassword"id="oldpassword"><br/><br/>
			*设置密码:&nbsp;<input type="password" name="password"class="password"><br/><br/>
			*确认密码:&nbsp;<input type="password" name="checkpassword"class="checkpassword">&nbsp;&nbsp;<br/><br/>
		<div id="result"></div>		 
		<span id="msg" style="color: red; font-size: 15px">${message}</span>
		<input type="button" value="提交" onclick="subform();">
		<input type="reset" value="重置">	
	</form>
</body>
</html>