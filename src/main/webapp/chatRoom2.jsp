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
	var url = "localhost:8080${pageContext.request.contextPath}";
	var websocket = null;
	if ('WebSocket' in window) {
		websocket = new WebSocket("ws://" + url + "/chat.sc");
	} else {
		websocket = new SockJS("http://" + url + "/sockjs/chat.sc");
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
				+ "CLOSE<br/>";
	}

	function doSend() {
		if (websocket.readyState == 1) { //0-CONNECTING;1-OPEN;2-CLOSING;3-CLOSED
			var msg = document.getElementById("message").value;
			if (msg) {
				websocket.send(msg);
				document.getElementById("message").value = "";
			}
			sendFile(msg);
			document.getElementById("message").value = "";
		} else {
			alert("connect fail!");
		}
	}

	function sendFile(isWithText) {
		var inputElement = document.getElementById("file");
		var fileList = inputElement.files;
		var file = fileList[0];
		if (!file)
			return;
		websocket.send(file.name + ":fileStart");
		var reader = new FileReader();
		//以二进制形式读取文件
		reader.readAsArrayBuffer(file);
		//文件读取完毕后该函数响应
		reader.onload = function loaded(evt) {
			var blob = evt.target.result;
			//发送二进制表示的文件
			websocket.send(blob);
			if (isWithText) {
				websocket.send(file.name + ":fileFinishWithText");
			} else {
				websocket.send(file.name + ":fileFinishSingle");
			}
			console.log("finnish");
		}
		inputElement.outerHTML = inputElement.outerHTML; //清空<input type="file">的值
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
			websocket = new WebSocket("ws://" + url + "/chat.sc");
		} else {
			websocket = new SockJS("http://" + url + "/sockjs/chat.sc");
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
									<div >
										<input id="message"  type="text" placeholder="输入内容" minlength="1"
											maxlength="100" autocomplete="off"></input>
									</div>
									
									<div>
										<button class="am-btn am-btn-secondary" id="send" onclick="doSend()">发送信息</button>
										<button class="am-btn am-btn-secondary" id="clean" onclick="clean()">清屏</button>
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
