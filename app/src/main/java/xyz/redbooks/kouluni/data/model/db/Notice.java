package xyz.redbooks.kouluni.data.model.db;

/**
 * Created by h4rdw1r3 at 1:12 PM on 25/7/18
 */

public class Notice {
    private long id;
    private String date;
    private String subject;
    private String message;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
}
