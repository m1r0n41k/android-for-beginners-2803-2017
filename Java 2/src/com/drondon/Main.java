package com.drondon;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        printHello();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.next();
            if (input != null && "exit".equalsIgnoreCase(input) || "quit".equalsIgnoreCase(input)) {
                System.out.println("Goodbye my friend!");
                break;
            } else if ("hello".equalsIgnoreCase(input)) {
                System.out.println("Hello my friend!");
            } else {
                System.out.println("What ?!");
                printHello();
            }
        }
    }

    public static final void printHello() {
        System.out.print("Hello... Please input here: ");
    }
}
