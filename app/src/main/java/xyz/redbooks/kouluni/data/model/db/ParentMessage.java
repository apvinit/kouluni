package xyz.redbooks.kouluni.data.model.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by h4rdw1r3 at 1:15 PM on 25/7/18
 */

@Entity(tableName = "parent_message")
public class ParentMessage {

    @PrimaryKey
    @NonNull
    private long id;

    @ColumnInfo(name = "date")
    private String date;

    @ColumnInfo(name = "subject")
    private String subject;

    @ColumnInfo(name = "message")
    private String message;

    @ColumnInfo(name = "from")
    private String from;

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

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }
}
