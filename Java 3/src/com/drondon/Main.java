package com.drondon;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int[] array = null;
        //int [] array;

        System.out.println("Array 1 : " + array);

        // Next code throw exception
        //int length = array.length;
        //System.out.println("Array size: " + length);

        int[] array2 = new int[0];
        //int [] array;

        System.out.println("Array 2 : " + array2);
        int length2 = array2.length;
        System.out.println("Array size: " + length2);

        //Array with nulls
        String[] array3 = new String[10];

        System.out.println("Array 3 : " + array3);
        int length3 = array3.length;
        System.out.println("Array size: " + length3);

        Arrays.fill(array3, "Sam");

        String user5 = array3[4];
        System.out.println("User 5 size: " + user5.length());

        // Multi array
        int[][] multiArray = new int[5][4];


        multiArray[0][0] = 1;
        multiArray[0][1] = 100666;
        multiArray[0][2] = 16;
        //..
        multiArray[4][3] = 16;

        System.out.println("Array multi : " + multiArray);


        // Multi array
        int sizeI = 3;
        int sizeJ = 3;
        int[][] multiArray2 = new int[sizeI][sizeJ];

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < sizeI; i++) {
            for (int j = 0; j < sizeJ; j++) {
                System.out.print("Введите элемент [" + i + ":" + j + "] : ");
                int value = 1;//scanner.nextInt();
                multiArray2[i][j] = value;
            }
        }


        System.out.println("Size: [" + multiArray2.length + "]");

        for (int i = 0; i < sizeI; i++) {
            for (int j = 0; j < sizeJ; j++) {
                System.out.print(multiArray2[i][j] + ", ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();
        System.out.println();

        int[][] multiArray3 = {{1, 2, 3, 4, 5}, {1, 2}};
        String[] arrayOfString = {"Hello!", Integer.toString(100), null};

        for (String s : arrayOfString) {
            if ( s.isEmpty()) {
                System.out.println("Empty data!");
            }else {
                System.out.println(s);
            }
        }

    }
}
