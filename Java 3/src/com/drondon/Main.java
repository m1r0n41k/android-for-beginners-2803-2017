package com.drondon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Hello");

        System.out.println("Array list: " + arrayList.toString());
        System.out.println("Array list item id 0: " + arrayList.get(0));

        arrayList.set(0, "Goodbye!");

        int indexOfElement = 10;

        if(indexOfElement < arrayList.size()){
            arrayList.set(0, "Yo!");
        }

        String[] array = new String[]{"Hello"};
        System.out.println("Array: " + array.toString());
        System.out.println("Array data: " + Arrays.toString(array));
        System.out.println("Array item id 0: " + array[0]);

        String substring = "ABC".substring(1, 2);
        System.out.println("Substring: " + substring);

    }
}
