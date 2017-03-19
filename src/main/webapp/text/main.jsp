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
	$(document)
			.ready(
					function() {
						$('.inactive')
								.click(
										function() {
											if ($(this).siblings('ul').css(
													'display') == 'none') {
												$(this).parent('li').siblings(
														'li').removeClass(
														'inactives');
												$(this).addClass('inactives');
												$(this).siblings('ul')
														.slideDown(100)
														.children('li');
												if ($(this).parents('li')
														.siblings('li')
														.children('ul').css(
																'display') == 'block') {
													$(this)
															.parents('li')
															.siblings('li')
															.children('ul')
															.parent('li')
															.children('a')
															.removeClass(
																	'inactives');
													$(this).parents('li')
															.siblings('li')
															.children('ul')
															.slideUp(100);

												}
											} else {
												/* <!-- 控制自身变成+号 --> */
												$(this)
														.removeClass(
																'inactives');
												/* 控制自身菜单下子菜单隐藏  */
												$(this).siblings('ul').slideUp(
														100);
												/* <!-- 控制自身子菜单变成+号 --> */
												$(this).siblings('ul')
														.children('li')
														.children('ul').parent(
																'li').children(
																'a').addClass(
																'inactives');
												/* <!-- 控制自身菜单下子菜单隐藏 --> */
												$(this).siblings('ul')
														.children('li')
														.children('ul')
														.slideUp(100);

												/* <!-- 控制同级菜单只保持一个是展开的（-号显示） --> */
												$(this).siblings('ul')
														.children('li')
														.children('a')
														.removeClass(
																'inactives');
											}
										})
					});
</script>


<script>
	(function($) {
		$(window).load(
				function() {

					$("a[rel='load-content']").click(
							function(e) {
								e.preventDefault();
								var url = $(this).attr("href");
								$.get(url, function(data) {
									$(".content .mCSB_container").append(data); //load new content inside .mCSB_container
									//scroll-to appended content 
									$(".content").mCustomScrollbar("scrollTo",
											"h2:last");
								});
							});

					$(".content").delegate(
							"a[href='top']",
							"click",
							function(e) {
								e.preventDefault();
								$(".content").mCustomScrollbar("scrollTo",
										$(this).attr("href"));
							});

				});
	})(jQuery);
</script>

</head>
<body>
	<!--header-->
	<header>
		<h1>
			<img src="" />
		</h1>
		<%-- <h1><img src="<%=basePath %>resource/images/admin_logo.png"/></h1> --%>
		<ul class="rt_nav">
			<li><a href="<%=basePath%>/getCurrentUser.do"
				class="admin_icon">当前用户</a></li>
			<li><a href="<%=basePath%>/jsp/welcome.jsp" target="_blank"
				class="website_icon">站点首页</a></li>
			<li><a href="<%=basePath%>switchoverUser.do" class="set_icon">换班操作</a></li>
			<li><a href="<%=basePath%>logout.do" class="quit_icon">安全退出</a></li>
		</ul>
	</header>
	<!--aside nav-->
	<aside class="lt_aside_nav content mCustomScrollbar">
		<div class="list">
			<ul class="yiji">
				<li><a href="index.jsp">起始页</a></li>
				<li><a href="#" class="inactive">订单信息</a>
					<ul style="display: none">
						<li><a href="#" class="inactive active">添加订单</a>
							<ul>
								<li><a href="#">办公室</a></li>
							</ul>
						</li>
						<li class="last"><a href="#">订单列表</a></li>
					</ul></li>
				<li><a href="#" class="inactive">会员管理</a>
					<ul style="display: none">
						<li><a href="#" class="inactive active">添加会员</a>
							<ul>
								<li><a href="#">办公室</a></li>
							</ul></li>
						<li><a href="#" class="inactive active">会员列表</a>
							<ul>
								<li><a href="#">综合部</a></li>
							</ul></li>
					</ul></li>
				<li><a href="#" class="inactive">基础设置</a>
					<ul style="display: none">
						<li><a href="#" class="inactive active">模板管理</a>
							<ul>
								<li><a href="#">办公室</a></li>
							</ul></li>
						<li><a href="#" class="inactive active">营销管理</a>
							<ul>
								<li><a href="#">综合部</a></li>
							</ul></li>
						<li><a href="#" class="inactive active">权限管理</a>
							<ul>
								<li><a href="#">综合部</a></li>
							</ul></li>
						<li><a href="#" class="inactive active">职位管理</a>
							<ul>
								<li><a href="#">综合部</a></li>
							</ul></li>
					</ul></li>
				<li><a href="#" class="inactive">商品信息</a>
					<ul style="display: none">
						<li><a href="#" class="inactive active">商品列表</a>
							<ul>
								<li><a href="#">办公室</a></li>
							</ul></li>
						<li class="last"><a href="#">商品分类</a></li>
					</ul></li>
				<li><a href="#" class="inactive">在线统计</a>
					<ul style="display: none">
						<li><a href="#" class="inactive active">流量统计</a>
							<ul>
								<li><a href="#">办公室</a></li>
							</ul></li>
						<li class="last"><a href="#">销售额统计</a></li>
					</ul></li>
				<li>
					<p class="btm_infor">© 版权所有</p>
				</li>
			</ul>
		</div>
	</aside>
</body>
</html>