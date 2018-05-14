package com.drondon.android9;

import android.widget.Toast;

import com.drondon.android9.api.API;
import com.drondon.android9.api.CoinMarketCapService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CoinDataSource {

    private List<Coin> favorites = new ArrayList<>();

    interface ResultCallback {
        void onResult(List<Coin> coins);
    }

    public List<Coin> getFavorites() {
        return favorites;
    }

    void load(final ResultCallback resultCallback) {
        CoinMarketCapService service = API.get();
        Call<List<Coin>> call = service.getAllCoins(null);
        call.enqueue(new Callback<List<Coin>>() {
            @Override
            public void onResponse(Call<List<Coin>> call, Response<List<Coin>> response) {
                boolean successful = response.isSuccessful();
                if (successful) {
                    List<Coin> coins = response.body();

                    App.get().db.getCoinDao().insertAll(coins);

                    final List<Coin> all = App.get().db.getCoinDao().getAll();

                    resultCallback.onResult(all);

                    //API.get().getGlobalData();
                } else {
                    int code = response.code();
                }
            }

            @Override
            public void onFailure(Call<List<Coin>> call, Throwable t) {
                //Call<List<Coin>> clone = call.clone();
                Toast.makeText(App.get(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
