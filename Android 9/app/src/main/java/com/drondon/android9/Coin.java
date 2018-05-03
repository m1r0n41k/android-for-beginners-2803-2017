package com.drondon.android9;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "coins")
public class Coin {

    private int rank;

    private String name;

    @ColumnInfo(name = "market_cap")
    private long marketCap;

    @PrimaryKey
    @NonNull
    private String simbol;

    @ColumnInfo(name = "price_usd")
    private double priceUsd;

    @ColumnInfo(name = "percent_24h")
    private double percent24h;

    @Ignore
    private boolean favorite = false;

    public Coin(int rank, String simbol, String name, long marketCap, double priceUsd, double percent24h) {
        this.rank = rank;
        this.name = name;
        this.marketCap = marketCap;
        this.simbol = simbol;
        this.priceUsd = priceUsd;
        this.percent24h = percent24h;
    }

    public int getRank() {
        return rank;
    }

    public String getName() {
        return name;
    }

    public long getMarketCap() {
        return marketCap;
    }

    public String getSimbol() {
        return simbol;
    }

    public double getPriceUsd() {
        return priceUsd;
    }

    public double getPercent24h() {
        return percent24h;
    }

    public boolean isFavorite() {
        return favorite;
    }


    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMarketCap(long marketCap) {
        this.marketCap = marketCap;
    }

    public void setSimbol(String simbol) {
        this.simbol = simbol;
    }

    public void setPriceUsd(double priceUsd) {
        this.priceUsd = priceUsd;
    }

    public void setPercent24h(double percent24h) {
        this.percent24h = percent24h;
    }


    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }
}
