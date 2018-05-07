package com.drondon.android9;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

@Entity(tableName = "coins")
public class Coin {
    @PrimaryKey
    @NonNull
    private String id;

    private int rank;

    private String name;

    @SerializedName("market_cap_usd")
    @ColumnInfo(name = "market_cap")
    private double marketCap;

    private String symbol;

    @SerializedName("price_usd")
    @ColumnInfo(name = "price_usd")
    private double priceUsd;

    @SerializedName("percent_change_24h")
    @ColumnInfo(name = "percent_24h")
    private double percent24h;

    @Ignore
    private boolean favorite = false;

    public String getId() {
        return id;
    }

    public int getRank() {
        return rank;
    }

    public String getName() {
        return name;
    }

    public double getMarketCap() {
        return marketCap;
    }

    public String getSymbol() {
        return symbol;
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

    public void setMarketCap(double marketCap) {
        this.marketCap = marketCap;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coin coin = (Coin) o;
        return rank == coin.rank &&
                marketCap == coin.marketCap &&
                Double.compare(coin.priceUsd, priceUsd) == 0 &&
                Double.compare(coin.percent24h, percent24h) == 0 &&
                favorite == coin.favorite &&
                Objects.equals(name, coin.name) &&
                Objects.equals(symbol, coin.symbol);
    }

    @Override
    public int hashCode() {

        return Objects.hash(rank, name, marketCap, symbol, priceUsd, percent24h, favorite);
    }

    @Override
    public String toString() {
        return "Coin{" +
                "rank=" + rank +
                ", name='" + name + '\'' +
                ", marketCap=" + marketCap +
                ", symbol='" + symbol + '\'' +
                ", priceUsd=" + priceUsd +
                ", percent24h=" + percent24h +
                ", favorite=" + favorite +
                '}';
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }
}
