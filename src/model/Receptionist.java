package model;

import java.time.DayOfWeek;
import java.util.HashSet;
import  java.time.DayOfWeek;

public class Receptionist extends Person{
    private HashSet<DayOfWeek> availability = new HashSet<>();

    public Receptionist(String firstName, String lastName, String id, String phoneNumber, HashSet<DayOfWeek> availability) {
        super(firstName, lastName, id, phoneNumber);
        this.availability = availability;
    }
    public Receptionist(){}
    public HashSet<DayOfWeek> getAvailability() {
        return availability;
    }

    public void setAvailability(HashSet<DayOfWeek> availability) {
        this.availability = availability;
    }

    @Override
    public void showInfos(){
        System.out.println("-First name: " + firstName);
        System.out.println("-Last name: " + lastName);
        System.out.println("-ID: " + id);
        System.out.println("-Phone number: " + phoneNumber);
    }
}
