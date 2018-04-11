package com.drondon;

import com.drondon.core.Guard;
import com.drondon.core.Man;
import com.drondon.core.User;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Man user = new User();
        user.setName("Andrew");
        user.setPhoneNumber("+380663386612");

        Man guard = new Guard();
        guard.setName("Boris");

        System.out.println("User: " + user.toString());
        System.out.println("User hashCode: " + Integer.toHexString(user.hashCode()));
        System.out.println("User data: " + user.getName() + " : " + user.getPhoneNumber());

        Man man = new Man() {
            @Override
            public String getName() {
                return null;
            }

            @Override
            public void setName(String name) {

            }

            @Override
            public String getPhoneNumber() {
                return null;
            }

            @Override
            public void setPhoneNumber(String phoneNumber) {

            }
        };

        ArrayList<Man> employers = new ArrayList<>();
        employers.add(user);
        employers.add(guard);
        employers.add(man);

        for (Man employer : employers) {
            printMan(employer);
        }
    }

    public static final void printMan(Man man) {
        System.out.println("User: " + man.getName());
        System.out.println("Phone number: " + man.getPhoneNumber());
    }
}
