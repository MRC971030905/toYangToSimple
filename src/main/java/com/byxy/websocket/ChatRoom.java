package com.byxy.websocket;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

public class ChatRoom extends AbstractWebSocketHandler {

	public final static List<WebSocketSession> sessionList = Collections
			.synchronizedList(new ArrayList<WebSocketSession>());
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	Logger logger = Logger.getLogger(this.getClass());
	FileOutputStream output; // 建立连接
	int i = 0;

	@Override
	public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {
		i = i + 1;
		System.out.println("i=" + i);
		System.out.println("建立连接Connection established..." + webSocketSession.getRemoteAddress());
		System.out.println("用户： " + webSocketSession.getAttributes().get("user") + " Login");
		webSocketSession.sendMessage(new TextMessage("欢迎：" + (webSocketSession.getAttributes().get("user"))+" 登录聊天室"));
		sessionList.add(webSocketSession);
	}

	// 连接关闭后
	@Override
	public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus status) throws Exception {
		i = i - 1;
		System.out.println("i=" + i);
		System.out.println("连接关闭后Connection closed..." + webSocketSession.getRemoteAddress() + " " + status);
		System.out.println("用户： " + webSocketSession.getAttributes().get("user") + " Logout退出");
		sessionList.remove(webSocketSession);
	}

	// 处理信息
	@Override
	public void handleTextMessage(WebSocketSession websocketsession, TextMessage message) {
		String payload = message.getPayload();
		String textString;
		try {
			if (payload.endsWith(":fileStart")) {
				output = new FileOutputStream(new File("C:\\websocket\\" + payload.split(":")[0]));
			} else if (payload.endsWith(":fileFinishSingle")) {
				output.close();
				String fileName = payload.split(":")[0];
				for (WebSocketSession session : sessionList) {
					if (session.getId().equals(websocketsession.getId())) {
						textString = " 我  (" + format.format(new Date()) + ")<br>";
					} else {
						textString = websocketsession.getAttributes().get("user") + " (" + format.format(new Date())
								+ ")<br>";
					}
					TextMessage textMessage = new TextMessage(textString);
					session.sendMessage(textMessage);
					sendPicture(session, fileName);
					ServletActionContext.getRequest().getSession().setAttribute("i", i);
				}
			} else if (payload.endsWith(":fileFinishWithText")) {
				output.close();
				String fileName = payload.split(":")[0];
				for (WebSocketSession session : sessionList) {
					sendPicture(session, fileName);
				}
			} else {
				for (WebSocketSession session : sessionList) {
					if (session.getId().equals(websocketsession.getId())) {
						textString = " 我 (" + format.format(new Date()) + ")<br>" + payload;
					} else {
						textString = websocketsession.getAttributes().get("user") + " (" + format.format(new Date())
								+ ")<br>" + payload;
					}
					TextMessage textMessage = new TextMessage(textString);
					session.sendMessage(textMessage);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void handleBinaryMessage(WebSocketSession session, BinaryMessage message) {

		ByteBuffer buffer = message.getPayload();
		try {
			output.write(buffer.array());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {
		if (webSocketSession.isOpen()) {
			webSocketSession.close();
		}
		System.out.println(throwable.toString());
		System.out.println("WS connection error,close..." + webSocketSession.getRemoteAddress());
	}

	@Override
	public boolean supportsPartialMessages() {
		return true;
	}

	public void sendPicture(WebSocketSession session, String fileName) {
		FileInputStream input;
		try {
			File file = new File("C:\\websocket\\" + fileName);
			input = new FileInputStream(file);
			byte bytes[] = new byte[(int) file.length()];
			input.read(bytes);
			BinaryMessage byteMessage = new BinaryMessage(bytes);
			session.sendMessage(byteMessage);
			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
