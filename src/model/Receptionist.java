package model;

import java.time.DayOfWeek;
import java.util.HashSet;
import  java.time.DayOfWeek;

public class Receptionist extends Person{
    private HashSet<DayOfWeek> availability = new HashSet<>();

    public Receptionist(String firstName, String lastName, String id, String email, HashSet<DayOfWeek> availability) {
        super(firstName, lastName, id, email);
        this.availability = availability;
    }

    @Override
    public void showInfos(){
        System.out.println("-First name: " + firstName);
        System.out.println("-Last name: " + lastName);
        System.out.println("-ID: " + id);
        System.out.println("-Email: " + email);
    }
}
