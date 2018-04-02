package com.drondon;

import java.util.Arrays;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер: ");
        int size = scanner.nextInt();
        scanner.reset();

        String[] array = new String[size];

        for (int i = 0; i < size; i++) {
            System.out.println("Введите [" + i + "] елемент");
            array[i] = scanner.next();
            scanner.reset();
        }

        array[0] = "A";
        array[1] = "Ab";
        array[2] = "Abc";
        array[4] = "Abcd";

        System.out.println("Result: ");
        for (String s : array) {
            System.out.println(s);
        }

    }
}
