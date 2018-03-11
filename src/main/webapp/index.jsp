<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%><!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>后台模板</title>
		<link rel="stylesheet" href="assets/css/amazeui.css" />
		<link rel="stylesheet" href="assets/css/core.css" />
		<link rel="stylesheet" href="assets/css/menu.css" />
		<link rel="stylesheet" href="assets/css/index.css" />
		<link rel="stylesheet" href="assets/css/admin.css" />
		<link rel="stylesheet" href="assets/css/page/typography.css" />
		<link rel="stylesheet" href="assets/css/page/form.css" />
		<link rel="stylesheet" href="assets/css/component.css" />
	</head>
	
	<body>
		<!-- Begin page -->
		<header class="am-topbar am-topbar-fixed-top">		
			<div class="am-topbar-left am-hide-sm-only">
                <a href="index.jsp" class="logo"><span>${mu.username }<span></span></span><i class="zmdi zmdi-layers"></i></a>
            </div>
	
			
		</header>
		<!-- end page -->
		
		
		<div class="admin">
			<!--<div class="am-g">-->
		<!-- ========== Left Sidebar Start ========== -->
		<!--<div class="left side-menu am-hide-sm-only am-u-md-1 am-padding-0">
			<div class="slimScrollDiv" style="position: relative; overflow: hidden; width: auto; height: 548px;">
				<div class="sidebar-inner slimscrollleft" style="overflow: hidden; width: auto; height: 548px;">-->
                  <!-- sidebar start -->
				  <div class="admin-sidebar am-offcanvas  am-padding-0" id="admin-offcanvas">
				    <div class="am-offcanvas-bar admin-offcanvas-bar">
				    	<!-- User -->
						<div class="user-box am-hide-sm-only">
	                        <div class="user-img">
	                            <img src="assets/img/avatar-1.jpg" alt="user-img" title="Mat Helme" class="img-circle img-thumbnail img-responsive">
	                            <div class="user-status offline"><i class="am-icon-dot-circle-o" aria-hidden="true"></i></div>
	                        </div>
	                        <h5><a href="#">Mrc Home </a> </h5>
	                        <ul class="list-inline">
	                            <li>
	                                <a href="#">
	                                    <i class="fa fa-cog" aria-hidden="true"></i>
	                                </a>
	                            </li>
	
	                            <li>
	                                <a href="#" class="text-custom">
	                                    <i class="fa fa-cog" aria-hidden="true"></i>
	                                </a>
	                            </li>
	                        </ul>
	                    </div>
	                    <!-- End User -->
	            
						 <ul class="am-list admin-sidebar-list">
						    <li><a href="index"><span class="am-icon-home"></span> 首页</a></li>
						    <li class="admin-parent">
						      <a class="am-cf" data-am-collapse="{target: '#collapse-nav1'}"><span class="am-icon-table"></span> 学生信息 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
						      <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav1">
						        
						        <li><a href="list">学生信息</a></li>
						      </ul>
						    </li>
						    <li class="admin-parent">
						      <a class="am-cf" data-am-collapse="{target: '#collapse-nav2'}"><i class="am-icon-line-chart" aria-hidden="true"></i> 统计图表 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
						      <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav2">
						        <li><a href="html/chart_line.html" class="am-cf"> 折线图</span></a></li>
						        <li><a href="html/chart_columnar.html" class="am-cf"> 柱状图</span></a></li>
						        <li><a href="html/chart_pie.html" class="am-cf"> 饼状图</span></a></li>
						      </ul>
						    </li>
						    <li class="admin-parent">
						      <a class="am-cf" data-am-collapse="{target: '#collapse-nav5'}"><span class="am-icon-file"></span> 表单 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
						      <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav5">
						        <li><a href="html/form_basic.html" class="am-cf"> 基本表单</a></li>
						        <li><a href="html/form_validate.html">表单验证</a></li>   
						      </ul>
						    </li>
						  </ul>
				</div>
				  </div>
				  <!-- sidebar end -->
    
				<!--</div>
			</div>
		</div>-->
		<!-- ========== Left Sidebar end ========== -->
		
		
		
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
								<h4 class="header-title m-t-0 m-b-30">总人数</h4>
								<div class="widget-chart-1 am-cf">
                                    <div id="widget-chart-box-1" style="height: 110px;width: 110px;float: left;">
                                    </div>

                                    <div class="widget-detail-1" style="float: right;">
                                        <h2 class="p-t-10 m-b-0"> 2500 </h2>
                                        <p class="text-muted">今日操作数据：100 条</p>
                                    </div>
                                </div>
							</div>
						</div>
						<!-- col end -->
						<div class="am-u-md-3">
							<div class="card-box">
								<h4 class="header-title m-t-0 m-b-30">吐槽板块</h4>
								<div class="widget-box-2">
                                    <div class="widget-detail-2">
                                        <span class="badge  pull-left m-t-20  am-round" style="color: #fff; background: #0e90d2;">3% <i class="zmdi zmdi-trending-up"></i> </span>
                                        <h5 class="m-b-0">新信息： 3 条 </h5>
                                       
                                    </div>
                                    <div class="am-progress am-progress-xs am-margin-bottom-0">
									    <div class="am-progress-bar" style="width: 80%"></div>
									</div>
                                </div>
							</div>
						</div>
						<!-- col end -->
						<div class="am-u-md-3">
							<div class="card-box">
								<h4 class="header-title m-t-0 m-b-30">定位</h4>
								<div class="widget-chart-1 am-cf">
                                    <div id="widget-chart-box-2" style="height: 110px;width: 110px;float: left;">
                                    </div>

                                    <div class="widget-detail-1" style="float: right;">
                                        <h2 class="p-t-10 m-b-0"> 2500 </h2>
                                        <p class="text-muted">已完成定位 ：1500</p>
                                    </div>
                                </div>
							</div>
						</div>
						<!-- col end -->
						<div class="am-u-md-3">
							<div class="card-box">
								<h4 class="header-title m-t-0 m-b-30">今天天气情况</h4>
								<div id="city"></div>
								<div id="weather"></div>
							</div>
						</div>
					<!-- Row end -->
				</div>
				
				<div class="am-g">
					<!-- Row start -->
					<div class="am-u-md-4">
						<div class="card-box">
							<h4 class="header-title m-t-0">环形图</h4>
							<div id="index-pie-1" style="height: 345px;height: 300px;"></div>
						</div>
					</div>
					
					<div class="am-u-md-4">
						<div class="card-box">
							<h4 class="header-title m-t-0">一周的温度</h4>
							<div id="index-bar-1" style="height: 345px;height: 300px;"></div>
						</div>
					</div>
					
					<div class="am-u-md-4">
						<div class="card-box">
							<h4 class="header-title m-t-0">今日温度</h4>
							<div id="index-line-1" style="height: 345px;height: 300px;"></div>
						</div>
					</div>
					<!-- Row end -->
				</div>
				
				
					
					
					
						
					</div>
					
					
				
			
				
			</div>
		</div>
		<!-- end right Content here -->
		<!--</div>-->
		</div>
		</div>
		
		<!-- navbar -->
		<a href="admin-offcanvas" class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}"><!--<i class="fa fa-bars" aria-hidden="true"></i>--></a>
		
		<script type="text/javascript" src="assets/js/jquery-2.1.0.js" ></script>
		<script>
		
		 $.ajax({
             type: "POST",
             url: "${pageContext.request.contextPath}/getWeather",
             data: {},
             dataType: "json",
             success: function(data){ 
            	 $("#city").text("所在位置:"+ data.lives[0].city);
					$("#weather").text("天气 ："+data.lives[0].weather+"; 摄氏度 ："+data.lives[0].temperature+"°c");
            		console.log(city);
                      }
         });
		</script>
		<script type="text/javascript" src="assets/js/amazeui.min.js"></script>
		<script type="text/javascript" src="assets/js/app.js" ></script>
		<script type="text/javascript" src="assets/js/blockUI.js" ></script>
		<script type="text/javascript" src="assets/js/charts/echarts.min.js" ></script>
		<script type="text/javascript" src="assets/js/charts/indexChart.js" ></script>
		
	</body>
	
</html>
