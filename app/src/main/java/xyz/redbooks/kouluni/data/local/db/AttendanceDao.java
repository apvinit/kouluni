package xyz.redbooks.kouluni.data.local.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import xyz.redbooks.kouluni.data.model.db.Attendance;

/*
 * Created by h4rdw1r3 at 11:49 AM on 4/8/18
 */
@Dao
public interface AttendanceDao {

    @Query("SELECT * FROM attendance")
    List<Attendance> getAllAttendance();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAttendance(Attendance attendance);

}
