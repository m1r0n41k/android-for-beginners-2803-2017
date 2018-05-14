package com.drondon.android9.api;

import android.support.annotation.Nullable;

import com.drondon.android9.Coin;
import com.drondon.android9.GlobalData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CoinMarketCapService {

    @GET("v1/ticker/")
    Call<List<Coin>> getAllCoins(@Nullable @Query("limit") Integer limit);

    @GET("v1/global/")
    Call<GlobalData> getGlobalData();

}
