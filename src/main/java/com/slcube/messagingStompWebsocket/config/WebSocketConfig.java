package com.slcube.messagingStompWebsocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration  // 설정 파일임을 나타내기위해 'Configuration Annotation' 선언
@EnableWebSocketMessageBroker   // 'message broker' 가 지원하는 'websocket message' 처리 활성화
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic");
        config.setApplicationDestinationPrefixes("/app");       // @MessageMapping 을 @RequestMapping 해준다 라고 이해 하면 될듯?
                                                                // ex) GreetingController.java 의 @MessageMapping("/hello") 라면
                                                                //     /app/hello 가 되는 것.
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/gs-guide-websocket").withSockJS();
    }
}
