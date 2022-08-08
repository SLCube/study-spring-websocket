# study-spring-websocket
chatting application 구현을 위한 spring websocket 학습

---

spring.io의 spring websocket 가이드 문서 예제를 통한 학습 입니다.

reference : https://spring.io/guides/gs/messaging-stomp-websocket/

--- 

인자가 없는 생성자를 안 만들어주면  
com.fasterxml.jackson.databind.exc.MismatchedInputException 예외가 나온다.  

왜일까?  

nested exception is com.fasterxml.jackson.databind.exc.MismatchedInputException: Cannot construct instance of `com.slcube.messagingStompWebsocket.domain.ChattingMessage` (although at least one Creator exists): cannot deserialize from Object value (no delegate- or property-based Creator)  

조금 더 공부 해야 할 듯 하다.  

--- 

```java

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public ChattingMessage greeting(ChattingMessage message) throws Exception {

        message.setMessage(HtmlUtils.htmlEscape(message.getMessage()));
        return message;
    }
```

위 코드 처럼 들어온 message 객체를 다시 재 활용 하는 방식으로 코드를 짜 보았다.  
input 객체를 다시 재활용 하는 것이 문제가 있을까?  

문제가 있다면 어떤 문제를 야기 할까? 