package com.drondon;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Office {

    private Scanner scanner;

    public Office(InputStream in) {
        scanner = new Scanner(in);
    }

    public void start() {
        ArrayList<User> users = new ArrayList<>();

        User testUser = new User();

        User testUser2 = new User(2, "Test user name", "Test@email.com");

        users.add(testUser2);

        User testUser3 = new StaffUser(3, "Samuil", "samuil@email.com");

        users.add(testUser3);

        for (User user : users) {
            user.print();
        }

    }

}
