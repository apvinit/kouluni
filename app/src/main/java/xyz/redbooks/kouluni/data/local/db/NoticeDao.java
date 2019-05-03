package xyz.redbooks.kouluni.data.local.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import xyz.redbooks.kouluni.data.model.db.Notice;

/*
 * Created by h4rdw1r3 at 7:58 PM on 3/8/18
 */
@Dao
public interface NoticeDao {

    @Query("SELECT * FROM notice")
    List<Notice> getAllNotices();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertNotice(Notice notice);


}
