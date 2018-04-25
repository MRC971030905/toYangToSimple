package com.byxy.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration // ������
@EnableWebSocket // ����֧��websocket
public class WebSocketConfig implements WebSocketConfigurer {

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		// setAllowedOrigins(String[] domains),允许指定的域名或IP(含端口号)建立长连接，默认只有本地。
		// 如果不限时使用"*"号，如果指定了域名，则必须要以http或https开头。
		// addInterceptors，顾名思义就是为handler添加拦截器，可以在调用handler前后加入自定义的逻辑代码。
		registry.addHandler(chatRoom(), "/chat.sc").setAllowedOrigins("*").addInterceptors(handshakeInterceptor());
		// 允许客户端使用SockJS
		// SockJS 是一个浏览器上运行的 JavaScript 库，如果浏览器不支持 WebSocket，该库可以模拟对 WebSocket 的支持。
		registry.addHandler(chatRoom(), "/sockjs/chat.sc").addInterceptors(handshakeInterceptor()).withSockJS();
	}

	@Bean
	public HandshakeInterceptor handshakeInterceptor() {
		return new HandshakeInterceptor();
	}

	@Bean
	public ChatRoom chatRoom() {
		return new ChatRoom();
	}
}
