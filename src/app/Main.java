package app;

import model.*;
import system.ClinicSystem;

import java.time.DayOfWeek;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ClinicSystem system = new ClinicSystem();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running) {
            printMenu();
            String choice = scanner.nextLine();

            try {
                switch (choice) {
                    case "1" -> registerDoctor(system, scanner);
                    case "2" -> registerPatient(system, scanner);
                    case "3" -> requestAppointment(system, scanner);
                    case "4" -> showAppointmentsByDay(system, scanner);
                    case "5" -> {
                        system.resetWeek();
                        System.out.println("✅ New week started ✅");
                    }
                    case "0" -> {
                        running = false;
                        System.out.println("Goodbye👋👋");
                    }
                    default -> System.out.println("❌ Invalid option ❌");
                }
            } catch (Exception e) {
                System.out.println("❌ Error: " + e.getMessage());
            }
        }
    }

    // ---------------- MENU ----------------
    private static void printMenu() {
        System.out.println("""
                
                ========= Clinic System =========
                1. Register Doctor              |
                2. Register Patient             |
                3. Request Appointment          |
                4. Show Appointments By Day     |
                5. Reset Week                   |
                0. Exit                         |
                ================================
                Choose an option:
                """);
    }

    // ---------------- ACTIONS ----------------
    private static void registerDoctor(ClinicSystem system, Scanner scanner) {
        System.out.print("- Enter Doctor ID: ");
        String id = scanner.nextLine();

        System.out.print("- Enter Doctor Full Name: ");
        String name = scanner.nextLine();

        System.out.print("- Enter Doctor specialty: ");
        String specialty = scanner.nextLine();

        //FIX: Check if it keeps adding that doctor to the list
        system.registerDoctor(new Doctor(id, name, specialty));
        System.out.println("✅ Doctor registered.");
    }

    private static void registerPatient(ClinicSystem system, Scanner scanner) {
        System.out.print("- Enter Patient ID: ");
        String id = scanner.nextLine();

        System.out.print("- Enter Patient Full Name: ");
        String name = scanner.nextLine();

        system.registerPatient(new Patient(id, name));
        System.out.println("✅ Patient registered.");
    }

    private static void requestAppointment(ClinicSystem system, Scanner scanner) {

        System.out.print("- Enter Patient ID: ");
        String patientId = scanner.nextLine();

        System.out.print("- Enter Doctor's Specialty: ");
        String specialty = scanner.nextLine();

        try {
            Patient patient = system.getPatientById(patientId);

            Appointment appointment =
                    system.requestAppointment(patient, specialty);

            if (appointment == null) {
                System.out.println("❌ No available doctor this week.");
            } else {
                System.out.println("✅ Appointment scheduled on " +
                        appointment.getDay() +
                        " with " +
                        appointment.getDoctor().getName());
            }

        } catch (IllegalArgumentException e) {
            System.out.println("❌ " + e.getMessage());
        }
    }

    private static void showAppointmentsByDay(ClinicSystem system, Scanner scanner) {
        System.out.print("- Enter day (MONDAY..SATURDAY): ");
        DayOfWeek day = DayOfWeek.valueOf(scanner.nextLine().toUpperCase());

        System.out.println("Appointments on " + day + ":");
        for (Appointment a : system.getAppointmentsForDay(day)) {
            System.out.println(
                    "- " + a.getPatient().getName()
                    + " with " + a.getDoctor().getName()
            );
        }
    }
}
