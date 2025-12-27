package model;

public class Patient extends Person{
    private boolean hasInsurance;
    private String insuranceName;
    private boolean paid;

    public Patient(String firstName, String lastName, String id, String email, boolean hasInsurance, String insuranceName, boolean paid) {
        super(firstName, lastName, id, email);
        this.hasInsurance = hasInsurance;
        this.insuranceName = insuranceName;
        this.paid = paid;
    }

    @Override
    public void showInfos(){
        System.out.println("-First name: " + firstName);
        System.out.println("-Last name: " + lastName);
        System.out.println("-ID: " + id);
        System.out.println("-Email: " + email);
    }
}
