package com.drondon.android9.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class API {

    private static CoinMarketCapService createService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.coinmarketcap.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CoinMarketCapService service = retrofit.create(CoinMarketCapService.class);
        return service;
    }

    private static CoinMarketCapService service;

    public static CoinMarketCapService get() {
        synchronized (API.class) {
            if (service == null) {
                service = createService();
            }
        }
        return service;
    }

}
