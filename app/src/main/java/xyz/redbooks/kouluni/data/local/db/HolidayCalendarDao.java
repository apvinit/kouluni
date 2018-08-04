package xyz.redbooks.kouluni.data.local.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import xyz.redbooks.kouluni.data.model.db.Holiday;

/*
 * Created by h4rdw1r3 at 7:51 PM on 3/8/18
 */
@Dao
public interface HolidayCalendarDao {

    @Query("SELECT * FROM holidays")
    List<Holiday> getAllHolidays();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertHoliday(Holiday holiday);
}
