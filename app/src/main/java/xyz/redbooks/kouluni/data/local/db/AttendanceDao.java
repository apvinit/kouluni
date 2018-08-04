package xyz.redbooks.kouluni.data.local.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

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
