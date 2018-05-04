package com.drondon.android9.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.drondon.android9.Coin;

import java.util.List;

@Dao
public interface CoinsDao {

    @Insert
    void insert(Coin coin);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Coin> coin);

    @Delete
    void delete(Coin coin);

    @Query("SELECT * FROM coins")
    List<Coin> getAll();

    @Query("SELECT * FROM coins WHERE simbol = :id")
    Coin get(String id);

}
