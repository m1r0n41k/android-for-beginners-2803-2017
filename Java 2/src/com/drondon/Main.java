package com.drondon;

public class Main {

    public static void main(String[] args) {
        boolean sameStrings = "I'm string".equals("I'm string ");
        System.out.println("Same : " + sameStrings);

        boolean sameStrings2 = "I'm string".equals("I'm string");
        System.out.println("Same 2 : " + sameStrings2);

        String data = "I'm String  ";
        boolean sameStrings3 = "I'M STRING".equals(data.trim().toUpperCase());
        System.out.println("Same 3 : " + sameStrings3);

        String stringData = new String("I'm string");
        //stringData.trim();
        //"I'm string".trim();

        boolean sameStrings4 = "I'm string" == stringData;
        System.out.println("Same 4 : " + sameStrings4);

    }

    public static void play() {

    }
}
