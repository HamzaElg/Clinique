package system;

import model.*;

import java.time.DayOfWeek;
import java.util.*;

public class ClinicSystem {

    // To check the existance in data via String ID.
    private Map<String, Person> persons = new HashMap<>();
    //Array List of Doctors.
    private List<Doctor> doctors = new ArrayList<>();
    //Array List of Appointments.
    private List<Appointment> allAppointments = new ArrayList<>();


    //Stores appointments per day during the week.
    private Map<DayOfWeek, List<Appointment>> appointmentsByDay =
            new EnumMap<>(DayOfWeek.class);

    public ClinicSystem() {
        for (DayOfWeek day : DayOfWeek.values()) {
            appointmentsByDay.put(day, new ArrayList<>());
        }
    }

    // -------- Registration --------
    public void registerDoctor(Doctor doctor) {
        ensureUniqueId(doctor.getId());
        doctors.add(doctor);
        persons.put(doctor.getId(), doctor);
    }
    public void registerPatient(Patient patient) {
        ensureUniqueId(patient.getId());
        persons.put(patient.getId(), patient);
    }
    private void ensureUniqueId(String id) {
        if (persons.containsKey(id))
            throw new IllegalArgumentException("Duplicate ID: " + id);
    }

    // -------- Appointment logic --------
    public Appointment requestAppointment(Patient patient, String specialty) {
        for (Doctor doctor : doctors) {
            //Skips if it's not the right specialty
            if (!doctor.getSpecialty().equalsIgnoreCase(specialty))
                continue;

            for (DayOfWeek day : DayOfWeek.values()) {
                //Skip Sunday
                if (day == DayOfWeek.SUNDAY) continue;
                //Checks if doctor can take a patient on that day.
                if (doctor.canTakePatient(day)) {
                    Appointment appointment = new Appointment(patient, doctor, day);

                    doctor.assignAppointment(appointment);
                    patient.addAppointment(appointment);

                    appointmentsByDay.get(day).add(appointment);
                    allAppointments.add(appointment);
                    return appointment;
                }
            }
        }
        return null; // no availability
    }

    // -------- Weekly reset --------
    // To Reset the days once the week is over.
    public void resetWeek() {
        //FIX: check if this wont cause an infinite loop.
        for (Doctor doctor : doctors) {
            doctor.resetWeek();
        }
        for (DayOfWeek day : appointmentsByDay.keySet()) {
            appointmentsByDay.get(day).clear();
        }
        allAppointments.clear();
    }

    // -------- Queries --------
    public List<Appointment> getAppointmentsForDay(DayOfWeek day) {
        return appointmentsByDay.get(day);
    }

    public Patient getPatientById(String patientId) {
        Person person = persons.get(patientId);

        if (person == null)
            throw new IllegalArgumentException("Patient not found");

        if (!(person instanceof Patient))
            throw new IllegalArgumentException("ID does not belong to a patient");

        return (Patient) person;
    }
}
