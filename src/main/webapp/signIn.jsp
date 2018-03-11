<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title></title>	
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/core.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/menu.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/amazeui.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/component.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/page/form.css" />
	</head>
	<body>
		<div class="account-pages">
			<div class="wrapper-page">
				<div class="text-center">
	                <a href="index.html" class="logo">宿舍管理系统</a>
	            </div>
	            
	            <div class="m-t-40 card-box">
	            	<div class="text-center">
	                    <h4 class="text-uppercase font-bold m-b-0">注册</h4>
	                </div>
	                <div class="panel-body">
	                	<form class="am-form" method="post" action="zc">
	                		<div class="am-g">
	                			<div class="am-form-group">
							      <input type="text" class="am-radius" name="mu.username" placeholder="Username">
							    </div>
							
							    <div class="am-form-group form-horizontal m-t-20">
							      <input type="password" class="am-radius" name="mu.password"  placeholder="Password">
							    </div>
							    
		                        
		                        <div class="am-form-group ">
		                        	<input type="submit" class="am-btn am-btn-primary am-radius" value="提交" style="width: 100%;height: 100%;">
		                        </div>
		                        
		                        
	                		</div>

	                	</form>
							
	                </div>
	            </div>
			</div>
		</div>
	</body>
</html>
