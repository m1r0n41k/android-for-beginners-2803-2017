package com.drondon.android9.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "my_database.sqlitedb";
    public static final int VERSION = 1;

    public DataBaseHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE coins (" +
                "_id TEXT PRIMARY KEY," +
                "rank INTEGER," +
                "name TEXT," +
                "marketCap INTEGER," +
                "simbol TEXT," +
                "priceUsd REAL," +
                "percent24h REAL" +
                ")");

        db.execSQL("CREATE TABLE favorites (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "counId TEXT," +
                "favorite INTERGER," +
                "UNIQUE(counId)" +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
