package app;

import model.*;
import system.ClinicSystem;

public class Main {

    public static void main(String[] args) {

        ClinicSystem system = new ClinicSystem();

        Doctor d1 = new Doctor("D1", "Dr. Smith", "Cardiology");
        Doctor d2 = new Doctor("D2", "Dr. Ali", "Dermatology");

        system.registerDoctor(d1);
        system.registerDoctor(d2);

        Patient p1 = new Patient("P1", "John");
        Patient p2 = new Patient("P2", "Sara");

        system.registerPatient(p1);
        system.registerPatient(p2);

        system.requestAppointment(p1, "Cardiology");
        system.requestAppointment(p2, "Cardiology");

        // End of week
        system.resetWeek();
    }
}
