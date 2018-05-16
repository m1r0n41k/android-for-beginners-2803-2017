package com.drondon.android9;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.support.annotation.Nullable;

import com.drondon.android9.db.MyDatabase;
import com.facebook.stetho.Stetho;

public class App extends Application {

    private static App app;

    public static App get() {
        return app;
    }

    public MyDatabase db;

    private Object sessionData;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        Stetho.initializeWithDefaults(this);
        db = Room.databaseBuilder(getApplicationContext(), MyDatabase.class, "my_room_db.sqlitedb")
                .allowMainThreadQueries()
                .build();
    }

    @Nullable
    public Object getSessionData() {
        if (sessionData == null) {
            //sessionData = tryReadFromStorage();
        }
        return sessionData;
    }

    public void setSessionData(Object sessionData) {
        this.sessionData = sessionData;
        //saveToStorage(sessionData);
    }
}
