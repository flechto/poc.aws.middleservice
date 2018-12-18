package fletch.middleservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class MessageHandler {

    private final MessageRepository messageRepository;
    private final MessageEvents messageEvents;

    @Autowired
    public MessageHandler(
            MessageRepository messageRepository,
            MessageEvents messageEvents) {

        this.messageRepository = messageRepository;
        this.messageEvents = messageEvents;
    }

    @MessageMapping("${incoming.name}")
    public void handle(@Payload Message message) {

        Message saved = messageRepository.save(message);

        messageEvents.emit(saved);
    }


}
