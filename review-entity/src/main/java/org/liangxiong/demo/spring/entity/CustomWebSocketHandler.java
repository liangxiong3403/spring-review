package org.liangxiong.demo.spring.entity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * @author liangxiong
 * @Date:2019-06-03
 * @Time:14:26
 * @Description 自定义websocket服务器
 */
@Slf4j
public class CustomWebSocketHandler extends TextWebSocketHandler {

    /**
     * 建立连接
     *
     * @param session
     * @throws Exception
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        log.info("WebSocket connection established");
    }

    /**
     * 处理消息
     *
     * @param session
     * @param message
     * @throws Exception
     */
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        log.info("sessionId: {}, message: {}", session.getId(), message);
        session.sendMessage(new TextMessage("server receive message success!"));
    }

    /**
     * 连接关闭
     *
     * @param session
     * @param status
     * @throws Exception
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        log.info("WebSocket connection closed");
    }
}
