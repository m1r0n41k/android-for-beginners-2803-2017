package com.drondon.android9;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.drondon.android9.db.MyDatabase;
import com.facebook.stetho.Stetho;

public class App extends Application {

    private static App app;

    public static App get() {
        return app;
    }

    public MyDatabase db;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        Stetho.initializeWithDefaults(this);
        db = Room.databaseBuilder(getApplicationContext(), MyDatabase.class, "my_room_db.sqlitedb")
                .allowMainThreadQueries()
                .build();
    }
}
