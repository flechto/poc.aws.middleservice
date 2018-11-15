package fletch.middleservice;

import org.springframework.beans.factory.annotation.Autowired;

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

    public void handle(Message message) {

        Message saved = messageRepository.save(message);

        messageEvents.emit(saved);
    }


}
