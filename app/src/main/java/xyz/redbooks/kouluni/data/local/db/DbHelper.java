package xyz.redbooks.kouluni.data.local.db;

import java.util.List;

import xyz.redbooks.kouluni.data.model.db.Attendance;
import xyz.redbooks.kouluni.data.model.db.Holiday;
import xyz.redbooks.kouluni.data.model.db.Notice;
import xyz.redbooks.kouluni.data.model.db.ParentMessage;

/*
 * Created by h4rdw1r3 at 1:49 PM on 4/8/18
 */
public interface DbHelper {

    List<Notice> getAllNotices();

    void insertNotice(final Notice notice);

    List<Holiday> getAllHolidays();

    void insertHoliday(final Holiday holiday);

    List<ParentMessage> getAllMessages();

    void insertMessage(final ParentMessage message);

    List<Attendance> getAllAttendances();

    void insertAttendance(final Attendance attendance);
}
