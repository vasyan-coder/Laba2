package com.vasyancoder.laba2.data.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.vasyancoder.laba2.data.db.entities.HackathonListItem;

import java.util.List;

@Dao
public interface HackathonDao {
    @Query("SELECT * FROM hackathon_table")
    LiveData<List<HackathonListItem>> getHackathonsList();
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(HackathonListItem hackathonListItem);
    @Query("SELECT * FROM hackathon_table WHERE :id LIKE id")
    LiveData<HackathonListItem> getItem(int id);
}
