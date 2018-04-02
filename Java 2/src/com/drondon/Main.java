package com.drondon;

public class Main {

    public static void main(String[] args) {

        int a = 0;

        long b = 30000000000L;

        a = (int) b;

        System.out.println("Result: " + a);


        float c;// = 2 / 3.0F;// = 0.0F;

        double d = 2.000010000000000000000000000122231;

        c = (float) d;

        System.out.println("Result 2: " + c);

        String number = "100500";
        int value  = Integer.valueOf(number);

        System.out.println("Result 3: " + value);


    }

    public static void play() {

    }
}
