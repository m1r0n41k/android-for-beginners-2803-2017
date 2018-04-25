package com.drondon.android9;

public class Coin {

    private int rank;

    private String name;

    private long marketCap;

    private String simbol;

    private double priceUsd;

    private double percent24h;

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
}
