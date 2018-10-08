package com.yi.websocket.service;

import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.timeout.IdleStateEvent;
import org.springframework.stereotype.Component;
import org.yeauty.annotation.*;
import org.yeauty.pojo.Session;

import java.io.IOException;

/**
 * 服务类
 * @author YI
 * @date 2018-10-8 09:37:05
 */
@ServerEndpoint(prefix = "netty.websocket.tow.service")
@Component
public class WebSocketTowService {
    /**
     * 当有新的WebSocket连接进入时，对该方法进行回调 注入参数的类型:Session、HttpHeaders
     * @param session
     * @param headers
     * @throws IOException
     */
    @OnOpen
    public void onOpen(Session session, HttpHeaders headers) throws IOException {
        System.out.println("新的WebSocket连接进入二号");
    }

    /**
     * 当有WebSocket连接关闭时，对该方法进行回调 注入参数的类型:Session
     * @param session
     * @throws IOException
     */
    @OnClose
    public void onClose(Session session) throws IOException {
        System.out.println("二号WebSocket连接关闭");
    }

    /**
     * 当有WebSocket抛出异常时，对该方法进行回调 注入参数的类型:Session、Throwable
     * @param session
     * @param throwable
     */
    @OnError
    public void onError(Session session, Throwable throwable) {
        throwable.printStackTrace();
    }

    /**
     * 当接收到字符串消息时，对该方法进行回调 注入参数的类型:Session、String
     * @param session
     * @param message
     */
    @OnMessage
    public void OnMessage(Session session, String message) {
        System.out.println(message);
        session.sendText("Hello WebSocket! ---> " + message);
    }

    /**
     * 当接收到二进制消息时，对该方法进行回调 注入参数的类型:Session、byte[]
     * @param session
     * @param bytes
     */
    @OnBinary
    public void OnBinary(Session session, byte[] bytes) {
        for (byte b : bytes) {
            System.out.println(b);
        }
        session.sendBinary(bytes);
    }

    /**
     * 当接收到Netty的事件时，对该方法进行回调 注入参数的类型:Session、Object
     * @param session
     * @param evt
     */
    @OnEvent
    public void onEvent(Session session, Object evt) {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent idleStateEvent = (IdleStateEvent) evt;
            switch (idleStateEvent.state()) {
                case READER_IDLE:
                    System.out.println("二号读操作空闲");
                    break;
                case WRITER_IDLE:
                    System.out.println("二号写操作空闲");
                    break;
                case ALL_IDLE:
                    System.out.println("二号所有操作空闲");
                    break;
                default:
                    break;
            }
        }
    }
}
