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
		String[] allowsOrigins = { "http://localhost:8080" };
		// setAllowedOrigins(String[] domains)
		registry.addHandler(chatRoom(), "/chat.sc").setAllowedOrigins("*").addInterceptors(handshakeInterceptor());
		// ����ͻ���ʹ��SockJS
		// SockJS ��һ������������е� JavaScript �⣬����������֧�� WebSocket���ÿ����ģ��� WebSocket ��֧�֡�
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
