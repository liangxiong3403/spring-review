package org.liangxiong.demo.spring.config;

import org.liangxiong.demo.spring.entity.CustomWebSocketHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * @author liangxiong
 * @Date:2019-06-03
 * @Time:14:29
 * @Description 配置WebSocket服务
 */
@EnableWebSocket
@Configuration
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(customWebSocketHandler(), "/customHandler");
    }

    @Bean
    public WebSocketHandler customWebSocketHandler() {
        return new CustomWebSocketHandler();
    }
}
