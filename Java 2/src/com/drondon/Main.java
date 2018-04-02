package com.drondon;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        printHello();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.next();
            String trimmedString = input.trim();
            String question = trimmedString.toLowerCase();
            switch (question) {
                case "exit":
                case "quit":
                    System.out.println("Goodbye my friend!");
                    return;

                case "hello":
                    System.out.println("Hello my friend!");
                    printHello();
                    break;

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
