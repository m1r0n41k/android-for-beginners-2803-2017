package com.drondon.android9;

import java.util.ArrayList;
import java.util.List;

public class CoinDataSource {

    interface ResultCallback {
        void onResult(List<Coin> coins);
    }

    void load(ResultCallback resultCallback) {

        List<Coin> coins = new ArrayList<>();

        coins.add(new Coin(1, "BTC", "Bitcoin", 1000055000L, 10000.0, -2.0));
        coins.add(new Coin(2, "MTC", "Mycoin", 10055009L, 1000.0, 5.0));
        coins.add(new Coin(3, "MTC", "Mycoin", 10055009L, 1000.0, 5.0));
        coins.add(new Coin(4, "MTC", "Mycoin", 10055009L, 1000.0, 5.0));
        coins.add(new Coin(5, "MTC", "Mycoin", 10055009L, 1000.0, 5.0));
        coins.add(new Coin(6, "MTC", "Mycoin", 10055009L, 1000.0, 5.0));
        coins.add(new Coin(6, "MTC", "Mycoin", 10055009L, 1000.0, 5.0));
        coins.add(new Coin(6, "MTC", "Mycoin", 10055009L, 1000.0, 5.0));
        coins.add(new Coin(6, "MTC", "Mycoin", 10055009L, 1000.0, 5.0));
        coins.add(new Coin(6, "MTC", "Mycoin", 10055009L, 1000.0, 5.0));
        coins.add(new Coin(6, "MTC", "Mycoin", 10055009L, 1000.0, 5.0));
        coins.add(new Coin(6, "MTC", "Mycoin", 10055009L, 1000.0, 5.0));

        resultCallback.onResult(coins);
    }

}
