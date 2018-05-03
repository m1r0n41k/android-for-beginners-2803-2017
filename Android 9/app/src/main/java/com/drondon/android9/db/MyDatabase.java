package com.drondon.android9.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.drondon.android9.Coin;

@Database(entities = {Coin.class},
        exportSchema = false,
        version = 1)
public abstract class MyDatabase extends RoomDatabase {
    public abstract CoinsDao getCoinDao();
}
