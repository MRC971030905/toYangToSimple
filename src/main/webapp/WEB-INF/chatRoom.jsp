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

<script type="text/javascript">
	var url = "www.mrcjb.com";
	var websocket = null;
	if ('WebSocket' in window) {
		websocket = new WebSocket("wss://" + url + "/chat.sc");
		console.log(websocket);
	} else {
		websocket = new SockJS("https://" + url + "/sockjs/chat.sc");
	}
	websocket.onopen = onOpen;
	websocket.onmessage = onMessage;
	websocket.onerror = onError;
	websocket.onclose = onClose;

	function onOpen(openEvent) {
		document.getElementById("plane").innerHTML = document
				.getElementById("plane").innerHTML
				+ "连接成功<br/>";
	}

	function onMessage(event) {
		if (typeof event.data == 'string') {
			var element = document.createElement("p");
			element.innerHTML = event.data;
			document.getElementById("plane").appendChild(element);
		} else {
			var reader = new FileReader();
			reader.onload = function(eve) {
				if (eve.target.readyState == FileReader.DONE) {
					var img = document.createElement("img");
					img.src = this.result;
					document.getElementById("plane").appendChild(img);
				}
			};
			reader.readAsDataURL(event.data);
		}
	}
	function onError() {
	}
	function onClose(event) {
		console.log(event.reason)
		document.getElementById("plane").innerHTML = document
				.getElementById("plane").innerHTML
				+ "连接失败<br/>";
	}

	function doSend() {
		if (websocket.readyState == 1) { //0-CONNECTING;1-OPEN;2-CLOSING;3-CLOSED
			var msg = document.getElementById("message").value;
			if (msg) {
				websocket.send(msg);
				document.getElementById("message").value = "";
			}

			document.getElementById("message").value = "";
		} else {
			alert("连接没成功");
			alert(websocket.readyState);
		}
	}

	function disconnect() {
		if (websocket != null) {
			websocket.close();
			websocket = null;
		}
	}

	function reconnect() {
		if (websocket != null) {
			websocket.close();
			websocket = null;
		}
		if ('WebSocket' in window) {
			websocket = new WebSocket("wss://" + url + "/chat.sc");
		} else {
			websocket = new SockJS("https://" + url + "/sockjs/chat.sc");
		}
		websocket.onopen = onOpen;
		websocket.onmessage = onMessage;
		websocket.onerror = onError;
		websocket.onclose = onClose;
	}
	function clean() {
		document.getElementById("plane").innerHTML = "";
	}
</script>
</head>

<body>



	<div class="admin">
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
					<h5>${name}</h5>
				</div>
				<ul class="am-list admin-sidebar-list">
					<li><a href="sindex"><span class="am-icon-home"></span> 首页</a></li>
					<li class="admin-parent"><a class="am-cf"
						data-am-collapse="{target: '#collapse-nav1'}"><span
							class="am-icon-table"></span> 功能模块 <span
							class="am-icon-angle-right am-fr am-margin-right"></span></a>
						<ul class="am-list am-collapse admin-sidebar-sub"
							id="collapse-nav1">
							<li><a href="sindex">天气查询</a></li>
							<li><a href="chatRoom2.jsp">吐槽室</a></li>
							<li><a href="html/location.html">定位</a></li>
						</ul></li>


				</ul>
			</div>

		</div>
		<!-- Start right Content here -->
		<div class="content-page">
			<!-- Start content -->
			<div class="content">
				<div class="am-g">
					<!-- Row start -->
					<div class="am-u-sm-12">
						<div class="card-box">
							<div class="am-form" data-am-validator>


								<fieldset>
									<legend>吐槽室</legend>
									<div id="plane"></div>
									<div>
										<input id="message" type="text" placeholder="输入内容"
											minlength="1" maxlength="100"></input>
									</div>
									<div>
										<button class="am-btn am-btn-secondary" id="send"
											onclick="doSend()">发送信息</button>
										<button class="am-btn am-btn-secondary" id="clean"
											onclick="clean()">清屏</button>
									</div>
								</fieldset>
							</div>


						</div>
					</div>
					<!-- Row end -->
				</div>
			</div>
		</div>
		<!-- end right Content here -->
	</div>

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
