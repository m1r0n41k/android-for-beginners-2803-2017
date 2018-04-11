package com.drondon;

public class StaffUser extends User {

    public StaffUser() {
        super();
    }

    public StaffUser(long id, String name, String email) {
        super(id, name, email);
    }


    @Override
    public String getName() {
        return super.getName() + " - Staff";
    }

    @Override
    public void calculateSalary() {
        //Specific calculation
    }

    @Override
    public void print() {
        System.out.println(" | " + getId() + " | " + getName() + " | ");
    }
}
