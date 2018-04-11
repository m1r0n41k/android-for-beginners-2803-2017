package com.drondon.core;

public class Guard implements Man {

    private String name;

    public void alarm(){
        System.out.println("Alarm");
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
        return "102";
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        //IGNORE
    }
}
