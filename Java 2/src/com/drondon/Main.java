package com.drondon;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Сколько денег напечатать? : ");

        if (scanner.hasNextInt()) {
            int count = scanner.nextInt();
            for (int i = 0; i < count; i++) {
                System.out.println("Index: " + i);
                printMoney();
            }
        }

    }

    public static final void printMoney() {
        System.out.println("100$");
    }

}
