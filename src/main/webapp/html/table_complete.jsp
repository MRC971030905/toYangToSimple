<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>后台模板</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/amazeui.css" />
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/core.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/menu.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/index.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/page/typography.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/page/form.css" />
	</head>
	<body>
		<!-- Begin page -->
		<header class="am-topbar am-topbar-fixed-top">		
			<div class="am-topbar-left am-hide-sm-only">
                <a href="index.jsp" class="logo"><span>${mu.username }<span></span></span><i class="zmdi zmdi-layers"></i></a>
            </div>
	
			<div class="contain">
				<ul class="am-nav am-navbar-nav am-navbar-left">

					<li><h4 class="page-title">基本表格</h4></li>
				</ul>
				
				<ul class="am-nav am-navbar-nav am-navbar-right">
					<li class="inform"><i class="am-icon-bell-o" aria-hidden="true"></i></li>
					<li class="hidden-xs am-hide-sm-only">
                        <form role="search" class="app-search">
                            <input type="text" placeholder="Search..." class="form-control">
                            <a href=""><img src="${pageContext.request.contextPath}/assets/img/search.png"></a>
                        </form>
                    </li>
				</ul>
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
	                            <img src="${pageContext.request.contextPath}/assets/img/avatar-1.jpg" alt="user-img" title="Mat Helme" class="img-circle img-thumbnail img-responsive">
	                            <div class="user-status offline"><i class="am-icon-dot-circle-o" aria-hidden="true"></i></div>
	                        </div>
	                        <h5><a href="#">Mrc</a> </h5>
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
						        <li><a href="chart_line.jsp" class="am-cf"> 折线图</span></a></li>
						        <li><a href="chart_columnar.jsp" class="am-cf"> 柱状图</span></a></li>
						        <li><a href="chart_pie.jsp" class="am-cf"> 饼状图</span></a></li>
						      </ul>
						    </li>
						    <li class="admin-parent">
						      <a class="am-cf" data-am-collapse="{target: '#collapse-nav5'}"><span class="am-icon-file"></span> 表单 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
						      <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav5">
						        <li><a href="form_basic.jsp" class="am-cf"> 基本表单</a></li>
						        <li><a href="form_validate.jsp">表单验证</a></li>   
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
				<div class="card-box">
					<!-- Row start -->
					<div class="am-g">
						<div class="am-u-sm-12 am-u-md-6">
				          <div class="am-btn-toolbar">
				            <div class="am-btn-group am-btn-group-xs">
				              <button type="button" class="am-btn am-btn-default"><span class="am-icon-plus"></span><a href="add">新增</a></button>
				              <button type="button" class="am-btn am-btn-default"><span class="am-icon-save"></span> 保存</button>
				              <button type="button" class="am-btn am-btn-default"><span class="am-icon-archive"></span> 审核</button>
				              <button type="button" class="am-btn am-btn-default"><span class="am-icon-trash-o"></span> 删除</button>
				            </div>
				          </div>
				        </div>	
				        
						<div class="am-u-sm-12 am-u-md-3">
				          <div class="am-input-group am-input-group-sm">
				            <input type="text" class="am-form-field">
				          <span class="am-input-group-btn">
				            <button class="am-btn am-btn-default" type="button">搜索</button>
				          </span>
				          </div>
				        </div>
				      </div>
					  <!-- Row end -->
					  
					  <!-- Row start -->
					  	<div class="am-g">
        <div class="am-u-sm-12">
          <form class="am-form">
            <table class="am-table am-table-striped am-table-hover table-main">
              <thead>
              <tr>
                <th class="table-id">ID</th>
                <th class="table-title">姓名</th>
                <th class="table-type">系级</th>
                <th class="table-author am-hide-sm-only">班级</th>
                <th class="table-date am-hide-sm-only">联系方式</th>
                <th class="table-set">qq</th>
                <th class="table-set">微信</th>
                <th class="table-set">所在区域</th>
                <th class="table-set">所在宿舍</th>
                <th class="table-set">身高</th>
                <th class="table-set">体重</th>
                <th class="table-set">操作</th>
              </tr>
              </thead>
              <tbody>
              <c:forEach var="d" items="${list}">
              	<tr>
              		<td>${d.dId }</td>
              		<td>${d.name}</td>
              		<td>${d.departmentName}</td>
              		<td>${d.className}</td>
              		<td>${d.phone}</td>
              		<td>${d.tim}</td>
              		<td>${d.weChat}</td>
              		<td>${d.area}</td>
              		<td>${d.dormitory}</td>
              		<td>${d.height}</td>
              		<td>${d.weight}</td>
              		<td>
	                  <div class="am-btn-toolbar">
	                    <div class="am-btn-group am-btn-group-xs">
	                      <button class="am-btn am-btn-default am-btn-xs am-text-secondary"><span class="am-icon-pencil-square-o"></span> <a href="update?d.dId=${d.dId}">编辑</a></button>
	                      <button class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only"><span class="am-icon-trash-o"></span><a href="delete?d.dId=${d.dId}"> 删除</a></button>
	                    </div>
                  </div></td>
              	</tr>
              </c:forEach>
              </tbody>
            </table>
            <div class="am-cf">
              共 ${count } 条记录
              <div class="am-fr">
                <ul class="am-pagination">
                  <li class="am-disabled"><a href="#">«</a></li>
                  <li class="am-active"><a href="#">1</a></li>
                  <li><a href="#">2</a></li>
                  <li><a href="#">3</a></li>
                  <li><a href="#">4</a></li>
                  <li><a href="#">5</a></li>
                  <li><a href="#">»</a></li>
                </ul>
              </div>
            </div>
            <hr />
            <p>注：.....</p>
          </form>
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
		
		<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery-2.1.0.js" ></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/amazeui.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/app.js" ></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/blockUI.js" ></script>
	</body>
	
</html>