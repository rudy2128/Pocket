package com.anthony.pocket.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.anthony.pocket.dao.ReportDao;
import com.anthony.pocket.entity.Report;

@Database(entities = {Report.class}, version = 5, exportSchema = false)
public abstract class TrxDatabase extends RoomDatabase {
    public abstract ReportDao reportDao();

    private static volatile TrxDatabase INSTANCE;

    public static TrxDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (TrxDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    TrxDatabase.class, "pake_ktp.db")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
