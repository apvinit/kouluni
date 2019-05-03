package xyz.redbooks.kouluni.data.local.db;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;

import xyz.redbooks.kouluni.data.model.db.Attendance;
import xyz.redbooks.kouluni.data.model.db.Holiday;
import xyz.redbooks.kouluni.data.model.db.Notice;
import xyz.redbooks.kouluni.data.model.db.ParentMessage;
import xyz.redbooks.kouluni.utils.AppConstants;

/*
 * Created by h4rdw1r3 at 11:55 AM on 4/8/18
 */

@Database(entities = {Attendance.class, Holiday.class, Notice.class, ParentMessage.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public abstract AttendanceDao attendanceDao();

    public abstract HolidayCalendarDao holidayCalendarDao();

    public abstract NoticeDao noticeDao();

    public abstract ParentMessageDao parentMessageDao();

    private static final Object sLock = new Object();

    public static AppDatabase getInstance(Context context){
        synchronized (sLock) {
            if(INSTANCE == null){
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        AppDatabase.class, AppConstants.DATABASE_NAME).build();
            }
        }
        return INSTANCE;
    }
}
