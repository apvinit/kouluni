package xyz.redbooks.kouluni.data.local.db;

import android.content.Context;

import java.util.List;

import xyz.redbooks.kouluni.data.model.db.Attendance;
import xyz.redbooks.kouluni.data.model.db.Holiday;
import xyz.redbooks.kouluni.data.model.db.Notice;
import xyz.redbooks.kouluni.data.model.db.ParentMessage;

/*
 * Created by h4rdw1r3 at 1:59 PM on 4/8/18
 */
public class AppDbHelper implements DbHelper {

    private static AppDbHelper INSTANCE;

    private NoticeDao noticeDao;
    private HolidayCalendarDao holidayCalendarDao;
    private ParentMessageDao parentMessageDao;
    private AttendanceDao attendanceDao;

    private AppDbHelper(Context context){
        noticeDao = AppDatabase.getInstance(context).noticeDao();
        holidayCalendarDao = AppDatabase.getInstance(context).holidayCalendarDao();
        parentMessageDao = AppDatabase.getInstance(context).parentMessageDao();
        attendanceDao = AppDatabase.getInstance(context).attendanceDao();
    }

    public static AppDbHelper getInstance(Context context) {
        if(INSTANCE == null)
            INSTANCE = new AppDbHelper(context);

        return INSTANCE;
    }

    @Override
    public List<Notice> getAllNotices() {
        return noticeDao.getAllNotices();
    }

    @Override
    public void insertNotice(Notice notice) {
        noticeDao.insertNotice(notice);
    }

    @Override
    public List<Holiday> getAllHolidays() {
        return holidayCalendarDao.getAllHolidays();
    }

    @Override
    public void insertHoliday(Holiday holiday) {
        holidayCalendarDao.insertHoliday(holiday);
    }

    @Override
    public List<ParentMessage> getAllMessages() {
        return parentMessageDao.getAllMessages();
    }

    @Override
    public void insertMessage(ParentMessage message) {
        parentMessageDao.insertMessage(message);
    }

    @Override
    public List<Attendance> getAllAttendances() {
        return attendanceDao.getAllAttendance();
    }

    @Override
    public void insertAttendance(Attendance attendance) {
        attendanceDao.insertAttendance(attendance);
    }
}
