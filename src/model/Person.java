package model;

public abstract class Person {
    protected String firstName;
    protected String lastName;
    protected String id;
    protected String phoneNumber;

    public Person(String firstName, String lastName, String id, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id.toUpperCase();
        this.phoneNumber = phoneNumber;
    }
    public Person(){

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getphoneNumber() {
        return phoneNumber;
    }

    public void setphoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public abstract void showInfos();

}
