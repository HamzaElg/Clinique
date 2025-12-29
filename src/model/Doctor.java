package model;

import java.util.HashSet;

public class Doctor extends Person{
    private HashSet<String> availability = new HashSet<>();
    private String speciality;
    private boolean isAvailable;;

    public Doctor(String firstName, String lastName, String id, String phoneNumber, String speciality) {
        super(firstName, lastName, id, phoneNumber);
        this.speciality = speciality;
        this.availability.add("MONDAY");
        this.availability.add("TUESDAY");
        this.availability.add("WEDNESDAY");
        this.availability.add("THURSDAY");
        this.availability.add("FRIDAY");
        this.availability.add("SATURDAY");
        this.isAvailable = true;
    }
    public Doctor(){}

    public HashSet<String> getAvailability() {
        return availability;
    }

    public void setAvailability(HashSet<String> availability) {
        this.availability = availability;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void makeDocAvailable() {
        isAvailable = true;
    }

    public void makeDocUnavailable() {
        isAvailable = false;
    }

    @Override
    public void showInfos(){
        System.out.println("-First name: " + firstName);
        System.out.println("-Last name: " + lastName);
        System.out.println("-ID: " + id);
        System.out.println("-Phone number: " + phoneNumber);
    }
}
