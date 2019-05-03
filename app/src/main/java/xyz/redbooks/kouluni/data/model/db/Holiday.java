package xyz.redbooks.kouluni.data.model.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

/*
 * Created by h4rdw1r3 at 1:19 PM on 25/7/18
 */
@Entity(tableName = "holidays")
public class Holiday {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "date")
    private String date;

    @ColumnInfo(name = "event_name")
    private String eventName;


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
}
