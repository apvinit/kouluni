package xyz.redbooks.kouluni.data.model.db;

/**
 * Created by h4rdw1r3 at 1:19 PM on 25/7/18
 */

public class HolidayCalendar {
    private long id;
    private String Date;
    private String eventName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
}
