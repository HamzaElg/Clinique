package model;

import java.util.HashSet;
import java.time.DayOfWeek;

public class Doctor extends Person{
    private HashSet<DayOfWeek> availability = new HashSet<>();
    private String speciality;

    public Doctor(String firstName, String lastName, String id, String email, String speciality, HashSet<DayOfWeek> availability) {
        super(firstName, lastName, id, email);
        this.speciality = speciality;
        this.availability = availability;
    }

    public HashSet<DayOfWeek> getAvailability() {
        return availability;
    }

    public void setAvailability(HashSet<DayOfWeek> availability) {
        this.availability = availability;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Override
    public void showInfos(){
        System.out.println("-First name: " + firstName);
        System.out.println("-Last name: " + lastName);
        System.out.println("-ID: " + id);
        System.out.println("-Email: " + email);
    }
}
