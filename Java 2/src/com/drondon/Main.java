package com.drondon;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        printHello();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.next();
            switch (input) {
                case "exit":
                case "quit":
                    System.out.println("Goodbye my friend!");
                    return;

                case "hello": {
                    System.out.println("Hello my friend!");
                    break;
                }

                default:
                    System.out.println("What ?!");
                    String error = validate(input);
                    System.out.println("Error: " + error);
                    printHello();
                    break;

            }
        }
    }

    public static final String validate(String input) {
        return (input.isEmpty() ? "Empty" : "Unknown") + " data";
    }

    public static final void printHello() {
        System.out.print("Hello... Please input here: ");
    }
}
