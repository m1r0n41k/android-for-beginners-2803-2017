package com.drondon.android9;

import android.app.Application;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.arch.lifecycle.ProcessLifecycleOwner;
import android.arch.persistence.room.Room;
import android.support.annotation.Nullable;
import android.util.Log;

import com.drondon.android9.db.MyDatabase;
import com.facebook.stetho.Stetho;

public class App extends Application {

    private static final String TAG = "App_";

    private static App app;

    public static App get() {
        return app;
    }

    public MyDatabase db;

    private Object sessionData;

    private boolean inForeground;

    private LifecycleObserver appLifecycleObserver = new LifecycleObserver() {

        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        public void onForeground() {
            Log.d(TAG, "App in foreground");
            inForeground = true;
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
        public void onBackground() {
            Log.d(TAG, "App in background");
            inForeground = false;
        }

    };

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        Stetho.initializeWithDefaults(this);
        db = Room.databaseBuilder(getApplicationContext(), MyDatabase.class, "my_room_db.sqlitedb")
                .allowMainThreadQueries()
                .build();

        ProcessLifecycleOwner.get().getLifecycle().addObserver(appLifecycleObserver);
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
