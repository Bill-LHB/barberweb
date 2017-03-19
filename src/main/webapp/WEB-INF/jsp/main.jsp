<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>后台管理系统</title>
<meta name="author" content="DeathGhost" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>resource/css/style.css" />
<!--[if lt IE 9]>
<script src="js/html5.js"></script>
<![endif]-->
<script src="<%=basePath%>resource/js/jquery.js"></script>
<script
	src="<%=basePath%>resource/js/jquery.mCustomScrollbar.concat.min.js"></script>

<%-- <script type="text/javascript"
	src="<%=basePath%>resource/js/jquery-1.11.1.min.js"></script> --%>


<script type="text/javascript">
	 $(document).ready(function() {
		$('.inactive').click(function() {
			if ($(this).siblings('dl').css('display') == 'none') {
				$(this).parent('dd').siblings('dd').removeClass('inactives');
				$(this).addClass('inactives');
				$(this).siblings('dl').slideDown(100).children('dd');
				if ($(this).parents('dd').siblings('dd').children('dl').css('display') == 'block') {
					$(this).parents('dd').siblings('dd').children('dl').parent('dd').children('a').removeClass('inactives');
					$(this).parents('dd').siblings('dd').children('dl').slideUp(100);
					}
				} else {
					/* <!-- 控制自身变成+号 --> */
					$(this).removeClass('inactives');
					/* 控制自身菜单下子菜单隐藏  */
					$(this).siblings('dl').slideUp(100);
					/* <!-- 控制自身子菜单变成+号 --> */
					$(this).siblings('dl').children('dd').children('dl').parent('dd').children('a').addClass('inactives');
					/* <!-- 控制自身菜单下子菜单隐藏 --> */
					$(this).siblings('dl').children('dd').children('dl').slideUp(100);
					/* <!-- 控制同级菜单只保持一个是展开的（-号显示） --> */
					$(this).siblings('dl').children('dd').children('a').removeClass('inactives');
				}
			})
		}); 

	(function($) {
		$(window).load(function() {
			$("a[rel='load-content']").click(function(e) {
				e.preventDefault();
				var url = $(this).attr("href");
				$.get(url, function(data) {
				$(".content .mCSB_container").append(data); //load new content inside .mCSB_container
				//scroll-to appended content 
				$(".content").mCustomScrollbar("scrollTo","h2:last");
					});
				});
			$(".content").delegate("a[href='top']","click",function(e) {
				e.preventDefault();
				$(".content").mCustomScrollbar("scrollTo",$(this).attr("href"));
			});
		});
	})(jQuery);
	
	function openWin(){
		myWindow=window.open('','','width=200,height=100');
		myWindow.document.write("<p>这是'我的窗口'</p>");
		myWindow.focus();
	}
	    
</script>

</head>
<body>
	<!--header-->
	
	<header>
		<h1 style="height:60px;">
		<br/>
			美发后台管理系统
		</h1>
		<%-- <h1><img src="<%=basePath %>resource/images/admin_logo.png"/></h1> --%>
		<ul class="rt_nav">

			<li><a href="#" class="admin_icon"
				onclick="window.open('<%=basePath%>user/changepassword.do','','width=400,height=400,top='+(screen.height-400)/2+',left='+(screen.width-400)/2 + '');">修改密码</a></li>
			<li><a href="<%=basePath%>welcome/main.do" class="website_icon"
				target="_top">站点首页</a></li>
			<li><a href="<%=basePath%>switchoverUser.do" class="set_icon"
				target="_blank">换班操作</a></li>
			<li><a href="<%=basePath%>user/logout.do" class="quit_icon"
				target="_top">安全退出</a></li>
		</ul>
	</header>
	<!--aside nav-->

	<aside class="lt_aside_nav content mCustomScrollbar"
		style="width: 200px">
		<%-- <h2><a href="<%=basePath%>/jsp/welcome.jsp">起始页</a></h2> --%>
		<ul>
			<li>
				<dl>
					<dt class="inactive">用戶管理</dt>
					<dl style="display: none">
						<!--当前链接则添加class:active-->
						<dd>
							<a href="<%=basePath%>user/alluser.do" class="inactive active"
								target="showpage">用戶列表</a>
						</dd>
					</dl>
				</dl>
			</li>
			<li>
				<dl>
					<dt class="inactive">会员管理</dt>
					<dl style="display: none">
						<!--当前链接则添加class:active-->
						<dd>
							<a href="<%=basePath%>member/addmember.do"
								class="inactive active" target="showpage">添加会员</a>
						</dd>
						<dd>
							<a href="<%=basePath%>member/allmember/1.do"
								class="inactive active" target="showpage">会员列表</a>
						</dd>
					</dl>
				</dl>
			</li>
			<li>
				<dl>
					<dt class="inactive">员工管理</dt>
					<dl style="display: none">
						<!--当前链接则添加class:active-->
						<dd>
							<a href="<%=basePath%>employee/addemployee.do"
								class="inactive active" target="showpage">添加员工</a>
						</dd>
						<dd>
							<a href="<%=basePath%>employee/allemployee/1.do"
								class="inactive active" target="showpage">员工列表</a>
						</dd>
					</dl>
				</dl>
			</li>
			<!--  <li>
   <dl>
    <dt class="inactive">订单管理</dt>
    <dl  style="display: none">
	    当前链接则添加class:active
	    <dd><a href="#" class="inactive active" target="showpage">添加订单</a></dd>
	    <dd><a href="#" class="inactive active" target="showpage">订单列表</a></dd>
    </dl>
   </dl></li> -->
			<!--      <li>
   <dl>
    <dt class="inactive">积分兑换</dt>
    <dl  style="display: none">
	    当前链接则添加class:active
	    <dd><a href="#" class="inactive active" target="showpage">添加商品</a></dd>
	    <dd><a href="#" class="inactive active" target="showpage">商品列表</a></dd>
    </dl>
   </dl></li> -->
			<li><dl>
					<dt class="inactive">系统设置</dt>
					<dl style="display: none">
						<!--当前链接则添加class:active-->
						<dd>
							<a href="<%=basePath%>system/allmodules.do"
								class="inactive active" target="showpage">模块设置</a>
						</dd>
						<dd>
							<a href="<%=basePath%>system/alldepartment.do" class="inactive active"
								target="showpage">部门设置</a>
						</dd>
						<dd>
							<a href="<%=basePath%>system/allrole.do" class="inactive active"
								target="showpage">角色设置</a>
						</dd>
						<dd>
							<a href="<%=basePath%>system/allcategory.do"
								class="inactive active" target="showpage">产品类别设置</a>
						</dd>
						<dd>
							<a href="<%=basePath%>system/allmenmberMode.do"
								class="inactive active" target="showpage">充值套餐设置</a>
						</dd>
					</dl>
				</dl></li>
		</ul>
	</aside>
	<iframe src="<%=basePath%>user/alluser.do" name="showpage" width="300"
		height="500" frameborder="0"
		style="height: 100%; width: 100%; position: relative; left: 200px;"></iframe>
	<!-- <p class="btm_infor">© 美发系统 </p> -->
</body>
</html>