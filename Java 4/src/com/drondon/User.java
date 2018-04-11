package com.drondon;

import com.sun.xml.internal.rngom.binary.DataExceptPattern;

import java.util.Date;

public class User {
    private long id;
    private String name;
    private String email;
    private long lastTime;

    private Date date = new Date();

    public User() {
        id = 1;
        name = "DEFAULT";
    }

    public User(long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void updateLastTime() {
        this.lastTime = System.currentTimeMillis();
    }

    public String printLastTime() {
        date.setTime(lastTime);
        return date.toString();
    }

    public void calculateSalary() {

    }

    public void print() {

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        if (id != user.id) return false;
        return email != null ? email.equals(user.email) : user.email == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
