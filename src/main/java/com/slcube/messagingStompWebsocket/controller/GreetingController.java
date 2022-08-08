package com.slcube.messagingStompWebsocket.controller;

import com.slcube.messagingStompWebsocket.domain.ChattingMessage;
import com.slcube.messagingStompWebsocket.domain.Greeting;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public ChattingMessage greeting(ChattingMessage message) throws Exception {

        message.setMessage(HtmlUtils.htmlEscape(message.getMessage()));
        return message;
    }

}