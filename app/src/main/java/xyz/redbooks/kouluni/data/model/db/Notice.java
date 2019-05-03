package xyz.redbooks.kouluni.data.model.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

/**
 * Created by h4rdw1r3 at 1:12 PM on 25/7/18
 */

@Entity(tableName = "notice")
public class Notice {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    private long id;

    @ColumnInfo(name = "date")
    private String date;

    @ColumnInfo(name = "subject")
    private String subject;

    @ColumnInfo(name = "message")
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
