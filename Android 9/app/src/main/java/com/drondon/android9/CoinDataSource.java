package com.drondon.android9;

import java.util.ArrayList;
import java.util.List;

public class CoinDataSource {

    private List<Coin> favorites = new ArrayList<>();

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

        App.get().db.getCoinDao().insertAll(coins);
        List<Coin> all = App.get().db.getCoinDao().getAll();

        resultCallback.onResult(all);
    }

}
