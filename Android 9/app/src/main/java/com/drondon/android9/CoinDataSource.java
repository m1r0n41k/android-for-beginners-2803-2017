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
        coins.add(new Coin(3, "MTC", "Mycoin", 10055009L, 1000.0, 5.0));
        coins.add(new Coin(4, "MTC", "Mycoin", 10055009L, 1000.0, 5.0));
        coins.add(new Coin(5, "MTC", "Mycoin", 10055009L, 1000.0, 5.0));
        coins.add(new Coin(6, "MTC", "Mycoin", 10055009L, 1000.0, 5.0));
        coins.add(new Coin(7, "MTC", "Mycoin", 10055009L, 1000.0, 5.0));
        coins.add(new Coin(8, "MTC", "Mycoin", 10055009L, 1000.0, 5.0));
        coins.add(new Coin(9, "MTC", "Mycoin", 10055009L, 1000.0, 5.0));
        coins.add(new Coin(10, "MTC", "Mycoin", 10055009L, 1000.0, 5.0));
        coins.add(new Coin(11, "MTC", "Mycoin", 10055009L, 1000.0, 5.0));
        coins.add(new Coin(12, "MTC", "Mycoin", 10055009L, 1000.0, 5.0));
        coins.add(new Coin(13, "MTC", "Mycoin", 10055009L, 1000.0, 5.0));
        coins.add(new Coin(14, "MTC", "Mycoin", 10055009L, 1000.0, 5.0));
        coins.add(new Coin(15, "MTC", "Mycoin", 10055009L, 1000.0, 5.0));

        resultCallback.onResult(coins);
    }

}
