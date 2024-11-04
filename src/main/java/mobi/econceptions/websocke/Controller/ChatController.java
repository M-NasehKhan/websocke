package mobi.econceptions.websocke.Controller;

import mobi.econceptions.websocke.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller

public class ChatController {
    @MessageMapping("/chat.send")
    @SendTo("/topic/public")
    public Message sendMessage(@Payload Message message) {
        return message;
    }

    @MessageMapping("/chat.join")
    @SendTo("/topic/public")
    public Message joinChat(@Payload Message message) {
        message.setContent(message.getSender() + " joined the chat");
        message.setType(Message.MessageType.JOIN);
        return message;
    }
}
