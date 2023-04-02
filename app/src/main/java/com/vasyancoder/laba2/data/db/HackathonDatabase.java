package com.vasyancoder.laba2.data.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.vasyancoder.laba2.data.db.dao.HackathonDao;
import com.vasyancoder.laba2.data.db.entities.HackathonListItem;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {HackathonListItem.class}, version = 1, exportSchema = false)
public abstract class HackathonDatabase extends RoomDatabase {

    private static volatile HackathonDatabase INSTANCE;

    public abstract HackathonDao hackathonDao();

    public static HackathonDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (HackathonDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    HackathonDatabase.class, "hackathon_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
