package fletch.middleservice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Message {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private final String title;
    private final String text;

    public Message(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public Long getId() {
        return id;
    }
}
