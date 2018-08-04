package xyz.redbooks.kouluni.data.model.db;

/*
 * Created by h4rdw1r3 at 11:46 AM on 4/8/18
 */

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "attendance")
public class Attendance {

    @PrimaryKey
    @NonNull
    private String date;

    private boolean present;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isPresent() {
        return present;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }
}
