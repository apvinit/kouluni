package xyz.redbooks.kouluni.data.model.db;

/**
 * Created by h4rdw1r3 at 1:15 PM on 25/7/18
 */

public class ParentMessage {
    private long id;
    private String subject;
    private String message;
    private String from;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }
}
