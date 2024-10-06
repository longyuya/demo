package com.example.apptext;

import android.app.Application;

import androidx.room.Room;

import com.example.apptext.dao.AppDatabase;
public class RoomActivity2 extends  Application {
    private static AppDatabase db;
    private static final Object LOCK = new Object();

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public static AppDatabase getDatabase(Application application) {
        if (db == null) {
            // 使用同步锁确保单例
            synchronized (LOCK) {
                if (db == null) {
                    // 使用Application context来避免内存泄漏
                    db = Room.databaseBuilder(application.getApplicationContext(),
                            AppDatabase.class, "my-database").build();
                }
            }
        }
        return db;
    }
}