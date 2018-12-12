package fletch.middleservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.core.NotificationMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageEvents {

    private final NotificationMessagingTemplate snsTemplate;

    @Autowired
    public MessageEvents(NotificationMessagingTemplate snsTemplate) {
        this.snsTemplate = snsTemplate;
    }

    public void emit(Message message) {
//        snsTemplate.sendNotification(message, "created");
        snsTemplate.sendNotification(
                "created",
                message,
                "created");
    }
}
