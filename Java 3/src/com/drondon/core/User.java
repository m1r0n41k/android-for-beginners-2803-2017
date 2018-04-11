package com.drondon.core;


public class User implements Man {
    public String name;
    public String phoneNumber;

    @Override
    public String toString() {
        String objectData = super.toString();
        String result = "Object [" + objectData + "]," +
                " with name: " + name +
                " and phone number: " + phoneNumber;
        return result;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}