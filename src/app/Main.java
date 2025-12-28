package app;

import model.Patient;
import model.Person;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashSet<String> patientsIDs = new HashSet<>();
        HashSet<Person> patients = new HashSet<>();


        System.out.println("----------------Menu Clinique----------------");
        System.out.println("1. New appointment.");
        System.out.println("2. Add a new doctor.");
        System.out.println("3. Add a patient.");
        System.out.println("4. Medical record.");
        System.out.println("5. Proceed a payment.");
        System.out.println("0. Quit.");
        System.out.println("Choose an option:");

        int choice = scanner.nextInt();

        do {
            switch (choice){
                case 1:
                    //Logic of creating an appointment between a doctor and a patient.
                    //1. Create patient infos if don't exists in a hashmap that stores ID's.
                    //2. Check availablity of doctors, until we find a doctor that have a date. Then assign it.
                    break;
                case 2:
                    //Adding informations of the doctor.
                    break;
                case 3:
                    //Adding infos of a patient.
                    System.out.println("Add the patient ID to check if it exists.");
                    String patientID = scanner.nextLine().toUpperCase();
                    if(patientsIDs.contains(patientID)){
                        System.out.println("This patient already exists.");

                    }else{
                        //I'm not sure which one is better to do
                        //Person p = new Patient(); vs Patient p = new Patient();
                        System.out.println("----Adding a new patient----");
                        System.out.println("-Add patient first name:");
                        String firstName = scanner.nextLine();
                        System.out.println("-Add patient last name:");
                        String lastName = scanner.nextLine();
                        System.out.println("-Add patient phone number:");
                        String phoneNumber = scanner.nextLine();
                        System.out.println("-Patient has insurance?(true/fasle)");
                        boolean hasInsurance = scanner.nextBoolean();
                        String insurance;
                        if(hasInsurance){
                            System.out.println("-Add patient name:");
                            insurance = scanner.nextLine();
                        }else{
                            insurance="";
                        }

                        Person p = new Patient(firstName,lastName,patientID,phoneNumber,hasInsurance,insurance);

                    }


                    break;
                case 4:
                    //Adding a medical record of a patient through a method that takes patient and a doctor and saves the medical record of that patient.
                    break;
                case 5:
                    //Proceeding payement based on speciality of doctors, if patient did radio, if took a room (based on days of stay in the room).
                    break;
                case 0:
                    System.out.println("Goodbye!");
            }
        }while(choice != 0);

    }
}