package com.drondon.android16;

import java.util.List;

public class Data {

    private int sum;

    private List<Integer> parts;

    public Data(int sum, List<Integer> parts) {
        this.sum = sum;
        this.parts = parts;
    }

    public int getSum() {
        return sum;
    }

    public List<Integer> getParts() {
        return parts;
    }
}
