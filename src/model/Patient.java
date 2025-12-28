package model;

public class Patient extends Person{
    private boolean hasInsurance;
    private String insuranceName;
    private boolean paid;

    public Patient(String firstName, String lastName, String id, String phoneNumber, boolean hasInsurance, String insuranceName) {
        super(firstName, lastName, id, phoneNumber);
        this.hasInsurance = hasInsurance;
        this.insuranceName = insuranceName;
        this.paid = false;
    }
    public Patient(){}

    public boolean isHasInsurance() {
        return hasInsurance;
    }

    public void setHasInsurance(boolean hasInsurance) {
        this.hasInsurance = hasInsurance;
    }

    public String getInsuranceName() {
        return insuranceName;
    }

    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    @Override
    public void showInfos(){
        System.out.println("-First name: " + firstName);
        System.out.println("-Last name: " + lastName);
        System.out.println("-ID: " + id);
        System.out.println("-Phone number: " + phoneNumber);
    }
}
