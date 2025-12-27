package model;

public abstract class Person {
    protected String firstName;
    protected String lastName;
    protected String id;
    protected String email;

    public Person(String firstName, String lastName, String id, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.email = email;
    }

    public abstract void showInfos();

//    public abstract void showInfos(){
//        System.out.println("-First name: " + firstName);
//        System.out.println("-Last name: " + lastName);
//        System.out.println("-ID: " + id);
//        System.out.println("-Email: " + email);
//    }
}
