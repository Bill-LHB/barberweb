<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<title>后台登录</title>
<meta name="author" content="DeathGhost" />
<link rel="stylesheet" type="text/css" href="<%=basePath %>resource/css/style.css" />
<style>
body{height:100%;background:#16a085;overflow:hidden;}
canvas{z-index:-1;position:absolute;}
</style>
<script src="<%=basePath %>resource/js/jquery.js"></script>
<script src="<%=basePath %>resource/js/verificationNumbers.js"></script>
<script src="<%=basePath %>resource/js/Particleground.js"></script>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
<script>
$(document).ready(function() {
  //粒子背景特效
  $('body').particleground({
    dotColor: '#5cbdaa',
    lineColor: '#5cbdaa'
  });
  //验证码
   createCode();  
  
// 在键盘按下并释放及提交后验证提交表单
   $("#signupForm").validate({
     rules: {
       user_name: {
         required: true,
         minlength: 2
       },
       password: {
         required: true,
         minlength: 5
       },
       J_codetext: {
         required: true,
         minlength: 4
       }
     },
     messages: {
       user_name: {
         required: "请输入用户名",
         minlength: "用户名不能小于 5个字母"
       },
       password: {
         required: "请输入密码",
         minlength: "密码不能小于 5个字母"
       },
       J_codetext: {
         required: "请输入验证码",
         minlength: "验证码不能小于4个字母"
       }
     }

});
});
</script>
<style type="text/css">
.error{
color: Black; font-size: 12px;
}
</style>
</head>
<body>

<form action="<%=basePath%>user/login.do" class="admin_login" onsubmit="return check()" method="post" id="signupForm" style="width:350px">
<h1>
  <strong>美容美发后台管理系统</strong><br/>
  <em>Management System</em>
 </h1>
 <div class="checkcode">
 <canvas class="J_codeimg" id="myCanvas" onclick="createCode()" >对不起，您的浏览器不支持canvas，请下载最新版浏览器!</canvas>
登录账号：<input id="name" type="text" name="user_name" placeholder="登录账号" data-validate="required:请填写账号"  class="login_txtbx"/><br/>
<br/>

  登录密码：<input id="password" type="password" name="password" placeholder="登录密码" data-validate="required:请填写密码" class="login_txtbx"/><br/>
 <br/>
  
 验证码:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" id="J_codetext" placeholder="验证码" maxlength="4" name="J_codetext" class="login_txtbx"><br/>
    
</div>
  
<!-- <input type="button" value="验证码检测" class="ver_btn" onClick="validate();" style="position:relative;right:-250px; top:0px"><br/> -->

	<input type="submit" value="立即登陆" class="submit_btn" style="position:relative;right:-40px; top:30px" />
  	<input type="button" value="立即注册" class="register_btn"  onclick="window.location.href('<%=basePath%>user/adduser.do')" style="position:relative;right:-80px; top:30px"/>
  	<%-- <span id="msg" style="color: Black; font-size: 12px;">${message}</span> --%>
 <br/><br/><br/> <br/><br/>

 <p>© 2017 lhb 版权所有</p>
</form>


 
</body>
</html>
