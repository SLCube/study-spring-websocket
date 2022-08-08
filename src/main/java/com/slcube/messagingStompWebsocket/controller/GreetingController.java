package com.slcube.messagingStompWebsocket.controller;

import com.slcube.messagingStompWebsocket.domain.ChattingMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public ChattingMessage greeting(ChattingMessage message) throws Exception {

        // 들어온 메세지를 재사용해서 return 해주는 것 문제가 없을까?

        /*지금은 localhost:8080에 접속한 사람이면 누구나 채팅에 참여 할 수 있는데
        1:1 채팅 즉 폐쇄적인 환경으로 채팅환경을 구성 할 수 있는 방법은 뭐가 있을까?

        당장 생각 나는 방법
        1) 채팅방에 고유 key값을 준다. key값을 통해 채팅 방이 구분 된다.*/

        message.setMessage(HtmlUtils.htmlEscape(message.getMessage()));
        return message;
    }

}