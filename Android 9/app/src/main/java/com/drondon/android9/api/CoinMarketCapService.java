package com.drondon.android9.api;

import com.drondon.android9.Coin;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CoinMarketCapService {

    @GET("v1/ticker/")
    Call<List<Coin>> getAllCoins();

}
