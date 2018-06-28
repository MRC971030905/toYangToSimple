<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>宿舍管理系统</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/amazeui.css" />
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/core.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/menu.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/index.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/admin.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/page/typography.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/page/form.css" />
</head>

<body>
	<div class="admin">
		<!--<div class="am-g">-->
		<!-- ========== Left Sidebar Start ========== -->
		<!--<div class="left side-menu am-hide-sm-only am-u-md-1 am-padding-0">
			<div class="slimScrollDiv" style="position: relative; overflow: hidden; width: auto; height: 548px;">
				<div class="sidebar-inner slimscrollleft" style="overflow: hidden; width: auto; height: 548px;">-->
		<!-- sidebar start -->



		<!--	<div class="am-g">-->
		<!-- ============================================================== -->
		<!-- Start right Content here -->
		<div class="content-page">
			<!-- Start content -->
			<div class="content">
				<div class="am-g">
					<!-- Row start -->
					<div class="am-u-sm-12">
						<div class="card-box">
							<form action="studentZC" class="am-form" method="post"
								data-am-validator>
								<fieldset>
									<legend>学生注册</legend><span>${sessionScope.alreadyExist}</span>
									<div class="am-form-group">
										<label for="doc-vld-name-2">账号：</label> <input type="text"
											id="doc-vld-name-2" name="mu.name" minlength="1"
											placeholder="输入用户名（至少 1 个字符）" required />
									</div>
									<div class="am-form-group">
										<label for="doc-vld-name-2">用户名：</label> <input type="text"
											id="doc-vld-name-2" name="mu.nickName" minlength="1"
											placeholder="输入用户名（至少 1 个字符）" required />
									</div>
									<div class="am-form-group">
										<label for="doc-vld-email-2">密码</label> <input type="password"
											name="mu.password" id="doc-vld-email-2" minlength="1"
											placeholder="（至少 1个字符）密码" required />
									</div>
									<div class="am-form-group">
										<label for="doc-vld-age-2">年龄：</label> <input type="number"
											name="mu.age" id="doc-vld-age-2" placeholder="输入年龄  11-120"
											min="1" max="120" required />
									</div>

									<div class="am-form-group">
										<label>性别： </label> <label class="am-radio-inline"> <input
											type="radio" value="true" name="mu.sex" required> 男
										</label> <label class="am-radio-inline"> <input type="radio"
											value="false" name="mu.sex"> 女
										</label>

									</div>

									<div class="am-form-group">
										<label for="doc-select-1">楼层</label> <select id="doc-select-1"
											name="mu.floor" required>
											<option value="C1">C1</option>
											<option value="C2">C2</option>
											<option value="C3">C3</option>
											<option value="C4">C4</option>
											<option value="C5">C5</option>
											<option value="C6">C6</option>
											<option value="C7">C7</option>
											<option value="C8">C8</option>
											<option value="C9">C9</option>
											<option value="C10">C10</option>
											<option value="C11">C11</option>
											<option value="C12">C12</option>
											<option value="C13">C13</option>
											<option value="C14">C14</option>
											<option value="C15">C15</option>
											<option value="C16">C16</option>
											<option value="C17">C17</option>
											<option value="C18">C18</option>

										</select> <span class="am-form-caret"></span>
									</div>
									<div class="am-form-group">
										<label for="doc-select-1">宿舍</label> <select id="doc-select-1"
											name="mu.dorm" required>
											<option value="101">101</option>
											<option value="102">102</option>
											<option value="201">201</option>
											<option value="202">202</option>
											<option value="301">301</option>
											<option value="302">302</option>
											<option value="401">401</option>
											<option value="402">402</option>
											<option value="501">501</option>
											<option value="502">502</option>
											<option value="601">601</option>
											<option value="602">602</option>
										</select>
									</div>
									<button class="am-btn am-btn-secondary" type="submit">提交</button>
								</fieldset>
							</form>


						</div>
					</div>
					<!-- Row end -->
				</div>




			</div>
		</div>
		<!-- end right Content here -->
		<!--</div>-->
	</div>
	</div>

	<!-- navbar -->
	<a href="admin-offcanvas"
		class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu"
		data-am-offcanvas="{target: '#admin-offcanvas'}"> <!--<i class="fa fa-bars" aria-hidden="true"></i>-->
	</a>

	<script type="text/javascript"
		src="${pageContext.request.contextPath}/assets/js/jquery-2.1.0.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/assets/js/amazeui.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/assets/js/app.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/assets/js/blockUI.js"></script>
</body>

</html>
