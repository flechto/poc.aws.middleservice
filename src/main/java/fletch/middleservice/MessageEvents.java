package fletch.middleservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.NotificationMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageEvents {

    private final NotificationMessagingTemplate snsTemplate;
    private final String topic;

    @Autowired
    public MessageEvents(NotificationMessagingTemplate snsTemplate,
                         @Value("${outgoing.topic}") String topic) {

        this.snsTemplate = snsTemplate;
        this.topic = topic;
    }

    public void emit(Message message) {
        snsTemplate.sendNotification(
                topic,
                message,
                "created");
    }
}
