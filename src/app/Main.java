package app;

import model.Appointment;
import model.Doctor;
import model.Patient;
import model.Person;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashSet<String> personsIDs = new HashSet<>();
        ArrayList<Patient> patients = new ArrayList<>();
        ArrayList<Doctor> doctors = new ArrayList<>();


        printMenu();
        int choice = scanner.nextInt();

        do {
            Patient p = new Patient();
            String patientID;
            switch (choice){
                case 1:
                    //Logic of creating an appointment between a doctor and a patient.
                    //1. Create patient infos if don't exists in a hashmap that stores ID's.
                    //2. Check availablity of doctors, until we find a doctor that have a date. Then assign it.

                    //1. Check if patient infos exists If not create a new one and add it to the queue:
                    System.out.println("Add the patient ID to check if it exists.");
                    patientID = scanner.nextLine().toUpperCase();

                    if(personsIDs.contains(patientID)){
                        System.out.println("This patient already exists.");
                        //Find which patient to assign it to the appointment
                        for(Patient patient: patients){
                            if(patient.getId().equalsIgnoreCase(patientID)){
                                p = patient;
                                break;
                            }
                        }
                    }else{
                        p = addPatient(patientID);
                        patients.add(p);
                        personsIDs.add(p.getId());
                    }
                    Appointment a = new Appointment();
                    a.setP(p);

                    //2. Find the doctor:
                    System.out.println("What's the speciality of the doctor.");
                    System.out.println("1. Generalist.");
                    System.out.println("2. Generalist.");
                    System.out.println("3. Generalist.");
                    System.out.println("4. Generalist.");
                    System.out.println("5. Generalist.");
                    int specialityChoice = scanner.nextInt();
                    switch(specialityChoice){
                        case 1:
                    }



                    break;
                case 2:
                    //Adding informations of the doctor.
                    //I'm not sure which one is better to do
                    //Person p = new Patient(); vs Patient p = new Patient();
                    System.out.println("Add the doctor ID to check if it exists.");
                    String doctorID = scanner.nextLine().toUpperCase();
                    if(personsIDs.contains(doctorID)){
                        System.out.println("This doctor already exists.");

                    }else{
                        Doctor d = addDoctor(doctorID);
                        doctors.add(d);
                    }

                    break;
                case 3:
                    //Adding infos of a patient.
                    //FIX variables either outside of the scope or remove init.
                    System.out.println("Add the patient ID to check if it exists.");
                    patientID = scanner.nextLine().toUpperCase();
                    if(personsIDs.contains(patientID)){
                        System.out.println("This patient already exists.");
                    }else{
                        p = addPatient(patientID);
                        patients.add(p);
                        personsIDs.add(p.getId());
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
            printMenu();
            choice = scanner.nextInt();
        }while(choice != 0);


    }
    static Patient addPatient(String patientID){
        Scanner scanner = new Scanner(System.in);
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
        Patient p = new Patient(firstName,lastName,patientID,phoneNumber,hasInsurance,insurance);
        return p;
    }
    static Doctor addDoctor(String doctorID){
        Scanner scanner = new Scanner(System.in);

        //I'm not sure which one is better to do
        //Person p = new Patient(); vs Patient p = new Patient();
        System.out.println("----Adding a new doctor----");
        System.out.println("-Add doctor first name:");
        String firstName = scanner.nextLine();
        System.out.println("-Add doctor last name:");
        String lastName = scanner.nextLine();
        System.out.println("-Add doctor phone number:");
        String phoneNumber = scanner.nextLine();
        System.out.println("-Add doctor speciality:");
        String speciality = scanner.nextLine();

        Doctor d = new Doctor(firstName,lastName,doctorID,phoneNumber,speciality);
        return d;
    }
    static void printMenu(){

        System.out.println("----------------Menu Clinique----------------");
        System.out.println("1. New appointment.");
        System.out.println("2. Add a new doctor.");
        System.out.println("3. Add a patient.");
        System.out.println("4. Medical record.");
        System.out.println("5. Proceed a payment.");
        System.out.println("0. Quit.");
        System.out.println("Choose an option:");
    }
}