package xyz.redbooks.kouluni.data.local.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import xyz.redbooks.kouluni.data.model.db.ParentMessage;

/*
 * Created by h4rdw1r3 at 7:56 PM on 3/8/18
 */
@Dao
public interface ParentMessageDao {

    @Query("SELECT * FROM parent_message")
    List<ParentMessage> getAllMessages();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMessage(ParentMessage parentMessage);

}
