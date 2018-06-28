<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%><!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>宿舍管理系统</title>
<link rel="stylesheet" href="assets/css/amazeui.css" />
<link rel="stylesheet" href="assets/css/core.css" />
<link rel="stylesheet" href="assets/css/menu.css" />
<link rel="stylesheet" href="assets/css/index.css" />
<link rel="stylesheet" href="assets/css/admin.css" />
<link rel="stylesheet" href="assets/css/page/typography.css" />
<link rel="stylesheet" href="assets/css/page/form.css" />
<link rel="stylesheet" href="assets/css/component.css" />
<style>
.pacong {
	display: flex;
	flex-wrap: wrap;
	margin: 5px;
}

.pacong li {
	display: flex;
	margin-left: 10px;
	
}

.tit {
	font-size: 14px;
	font-weight: 700;
	height: 40px;
	margin-top: 5%;
	width: 300px;
}

.time {
	font-size: 17px;
	margin: 2% 0;
	color: #8e8e8e;
}
</style>
</head>

<body>
	<div class="admin">
		<!--<div class="am-g">-->
		<!-- ========== Left Sidebar Start ========== -->
		<!--<div class="left side-menu am-hide-sm-only am-u-md-1 am-padding-0">
			<div class="slimScrollDiv" style="position: relative; overflow: hidden; width: auto; height: 548px;">
				<div class="sidebar-inner slimscrollleft" style="overflow: hidden; width: auto; height: 548px;">-->
		<!-- sidebar start -->
		<div class="admin-sidebar am-offcanvas  am-padding-0"
			id="admin-offcanvas">
			<div class="am-offcanvas-bar admin-offcanvas-bar">
				<!-- User -->
				<div class="user-box am-hide-sm-only">
					<div class="user-img">
						<a href="#"><img src="assets/img/123.png" alt="user-img"
							class="img-circle img-thumbnail img-responsive"></a>
						<div class="user-status offline">
							<i class="am-icon-dot-circle-o" aria-hidden="true"></i>
						</div>
					</div>
					<div name="${name}">${name }</div>
				</div>
				<!-- End User -->

				<ul class="am-list admin-sidebar-list">
					<li><a href="index"><span class="am-icon-home"></span> 首页</a></li>
					<li class="admin-parent"><a class="am-cf"
						data-am-collapse="{target: '#collapse-nav1'}"><span
							class="am-icon-table"></span> 学生信息 <span
							class="am-icon-angle-right am-fr am-margin-right"></span></a>
						<ul class="am-list am-collapse admin-sidebar-sub"
							id="collapse-nav1">
							<li><a href="list">学生信息</a></li>
						</ul></li>
						<li class="admin-parent"><a class="am-cf"
						data-am-collapse="{target: '#collapse-nav2'}"><span
							class="am-icon-table"></span> 天气情况 <span
							class="am-icon-angle-right am-fr am-margin-right"></span></a>
						<ul class="am-list am-collapse admin-sidebar-sub"
							id="collapse-nav2">
							<li><a href="index">天气情况</a></li>
						</ul></li>
						<li class="admin-parent"><a class="am-cf"
						data-am-collapse="{target: '#collapse-nav3'}"><span
							class="am-icon-table"></span> 聊天室 <span
							class="am-icon-angle-right am-fr am-margin-right"></span></a>
						<ul class="am-list am-collapse admin-sidebar-sub"
							id="collapse-nav3">
							<li><a href="chatRoom">聊天室</a></li>
						</ul></li>
						<li class="admin-parent"><a class="am-cf"
						data-am-collapse="{target: '#collapse-nav4'}"><span
							class="am-icon-table"></span> 位置定位 <span
							class="am-icon-angle-right am-fr am-margin-right"></span></a>
						<ul class="am-list am-collapse admin-sidebar-sub"
							id="collapse-nav4">
							<li><a href="html/location.html">位置定位</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
		<!-- sidebar end -->

		<!--	<div class="am-g">-->
		<!-- ============================================================== -->
		<!-- Start right Content here -->
		<div class="content-page">
			<!-- Start content -->
			<div class="content">
				<div class="am-g">
					<!-- Row start -->
					<div class="am-u-md-3">
						<div class="card-box">
							<h4 class="header-title m-t-0 m-b-30">今天天气情况</h4>
							<div id="city"></div>
							<div id="weather"></div>
						</div>
					</div>
					<!-- col end -->
					<div class="am-u-md-3">
						<div class="card-box">
							<h4 class="header-title m-t-0 m-b-30">聊天室</h4>
							<div class="widget-box-2">
								<div class="widget-detail-2">
									<a href="chatRoom">进入聊天室</a>
								</div>
							</div>
						</div>
					</div>
					<!-- col end -->
					<div class="am-u-md-3">
						<div class="card-box">
							<h4 class="header-title m-t-0 m-b-30">位置定位</h4>
							<div class="widget-chart-1 am-cf">
								<a href="html/location.html">单击定位</a>
							</div>
						</div>
					</div>
					<!-- col end -->
					<div class="am-u-md-3">
						<div class="card-box">
							<h4 class="header-title m-t-0 m-b-30">操作日志</h4>
							<div class="widget-chart-1 am-cf">
								<div id="user"></div> <div id="time"></div> <div
									id="content"></div>
							</div>
						</div>

					</div>
					<!-- Row end -->
				</div>

				<div class="am-g">
					<!-- Row start -->

					<div class="card-box">
						<h4 class="header-title m-t-0">校园最新信息</h4>
						<hr/>
						<ul class="pacong">${ht}
						</ul>
					</div>
					<!-- Row end -->
				</div>
			</div>

		</div>
	</div>
	<!-- end right Content here -->

	<a href="admin-offcanvas"
		class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu"
		data-am-offcanvas="{target: '#admin-offcanvas'}"> <!--<i class="fa fa-bars" aria-hidden="true"></i>-->
	</a>

	<script type="text/javascript" src="assets/js/jquery-2.1.0.js"></script>
	<script>
		$.ajax({
			type : "POST",
			url : "${pageContext.request.contextPath}/getWeather",
			data : {},
			dataType : "json",
			success : function(data) {
				$("#city").text("所在位置:" + data.lives[0].city);
				$("#weather").text(
						"天气 ：" + data.lives[0].weather + "; 摄氏度 ："
								+ data.lives[0].temperature + "°c");
			}
		});
		$(function() {
			document.getElementById("time").innerHTML = "${time}";
			document.getElementById("user").innerHTML = "用户：${name} ,在";
			document.getElementById("content").innerHTML = "访问了：${log.name} 方法";
		})
	</script>
	<script type="text/javascript" src="assets/js/amazeui.min.js"></script>
	<script type="text/javascript" src="assets/js/app.js"></script>
	<script type="text/javascript" src="assets/js/blockUI.js"></script>
	<script type="text/javascript" src="assets/js/charts/echarts.min.js"></script>
	<script type="text/javascript" src="assets/js/charts/indexChart.js"></script>

</body>

</html>
