package com.drondon.android9;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import com.drondon.android9.db.DataBaseHelper;

import java.util.ArrayList;
import java.util.List;

public class CoinDataSource {

    private List<Coin> favorites = new ArrayList<>();
    private DataBaseHelper helper;

    public CoinDataSource(Context context) {
        helper = new DataBaseHelper(context);

        /*SQLiteDatabase database = null;
        try {
            database = helper.getWritableDatabase();
        } finally {
            if (database != null) {
                database.close();
            }
        }*/
    }

    interface ResultCallback {
        void onResult(List<Coin> coins);
    }

    public List<Coin> getFavorites() {
        return favorites;
    }

    void load(ResultCallback resultCallback) {

        List<Coin> coins = new ArrayList<>();

        coins.add(new Coin(1, "BTC", "Bitcoin", 1000055000L, 10000.0, -2.0));
        coins.add(new Coin(2, "MTC", "Mycoin", 10055009L, 1000.0, 5.0));
        coins.add(new Coin(3, "MTC1", "Mycoin", 10055009L, 1000.0, 5.0));
        coins.add(new Coin(4, "MTC2", "Mycoin", 10055009L, 1000.0, 5.0));
        coins.add(new Coin(5, "MTC3", "Mycoin", 10055009L, 1000.0, 5.0));
        coins.add(new Coin(6, "MTC4", "Mycoin", 10055009L, 1000.0, 5.0));
        coins.add(new Coin(7, "MTC5", "Mycoin", 10055009L, 1000.0, 5.0));
        coins.add(new Coin(8, "MTC6", "Mycoin", 10055009L, 1000.0, 5.0));
        coins.add(new Coin(9, "MTC7", "Mycoin", 10055009L, 1000.0, 5.0));
        coins.add(new Coin(10, "MTC8", "Mycoin", 10055009L, 1000.0, 5.0));
        coins.add(new Coin(11, "MTC9", "Mycoin", 10055009L, 1000.0, 5.0));
        coins.add(new Coin(12, "MTC10", "Mycoin", 10055009L, 1000.0, 5.0));
        coins.add(new Coin(13, "MTC11", "Mycoin", 10055009L, 1000.0, 5.0));
        coins.add(new Coin(14, "MTC12", "Mycoin", 10055009L, 1000.0, 5.0));
        coins.add(new Coin(15, "MTC13", "Mycoin", 10055009L, 1000.0, 5.0));

        try (SQLiteDatabase database = helper.getWritableDatabase()) {
            try {
                database.beginTransaction();
                //Insert
                for (Coin coin : coins) {

                    ContentValues value = new ContentValues();
                    value.put(BaseColumns._ID, coin.getSimbol());
                    value.put("rank", coin.getRank());
                    value.put("name", coin.getName());
                    value.put("marketCap", coin.getMarketCap());
                    value.put("simbol", coin.getSimbol());
                    value.put("priceUsd", coin.getPriceUsd());
                    value.put("percent24h", coin.getPercent24h());

                    database.insertWithOnConflict("coins", null, value, SQLiteDatabase.CONFLICT_REPLACE);
                }
                database.setTransactionSuccessful();
            } finally {
                database.endTransaction();
            }

        }


        resultCallback.onResult(coins);
    }

}
