package com.byxy.websocket;

import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

public class HandshakeInterceptor extends HttpSessionHandshakeInterceptor {
	@Override
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler handler,
			Map<String, Object> attributes) throws Exception {
		attributes.put("user", getName());
		return super.beforeHandshake(request, response, handler, attributes);
	}

	@Override
	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Exception ex) {
		super.afterHandshake(request, response, wsHandler, ex);
	}

	public String getName() {
		String name = (String) ServletActionContext.getRequest().getSession().getAttribute("name");
		return name;
	}

}
