package com.drondon;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("User name: " + args[0]);
        System.out.println("User email: " + args[1]);

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.print("Введите слово: ");
            String input = scanner.next();
            scanner.reset();

            System.out.println("Length: " + input.length());

            System.out.print("Введите индекс буквы: ");
            int index = scanner.nextInt();

            char letter = input.charAt(index);
            System.out.println("Выбранная буква: " + letter);

            char[] chars = input.toCharArray();

            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                Character upperC = Character.toUpperCase(c);
                System.out.println("" + upperC + ((i < (chars.length - 1)) ? ", " : ""));
            }

        }

    }


}
