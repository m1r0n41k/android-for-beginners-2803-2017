package com.drondon.android9;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;

import com.drondon.android9.api.HttpClient;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class CoinDataSource {

    private List<Coin> favorites = new ArrayList<>();

    private Executor executorService = Executors.newSingleThreadExecutor();

    private Handler handler = new Handler(Looper.getMainLooper());

    private Executor uiService = new Executor() {
        @Override
        public void execute(@NonNull Runnable command) {
            handler.post(command);
        }
    };

    interface ResultCallback {
        void onResult(List<Coin> coins);
    }

    public List<Coin> getFavorites() {
        return favorites;
    }

    void load(final ResultCallback resultCallback) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {

                    String result = new HttpClient().request("https://api.coinmarketcap.com/v1/ticker/");

                    Gson gson = new GsonBuilder().create();

                    Type type = new TypeToken<List<Coin>>() {
                    }.getType();

                    List<Coin> coins =  gson.fromJson(result, type);

                    App.get().db.getCoinDao().insertAll(coins);

                    final List<Coin> all = App.get().db.getCoinDao().getAll();

                    uiService.execute(new Runnable() {
                        @Override
                        public void run() {
                            resultCallback.onResult(all);
                        }
                    });

                } catch (IOException e) {
                    e.printStackTrace();
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
            }
        });


    }

}
