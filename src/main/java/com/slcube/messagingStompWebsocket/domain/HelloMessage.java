package com.slcube.messagingStompWebsocket.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChattingMessage {

    private String message;

    public ChattingMessage(String message) {
        this.message = message;
    }
}
