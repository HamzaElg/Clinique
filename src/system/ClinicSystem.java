package system;

import model.*;

import java.time.DayOfWeek;
import java.util.*;

public class ClinicSystem {

    private Map<String, Person> persons = new HashMap<>();
    private List<Doctor> doctors = new ArrayList<>();
    private List<Appointment> allAppointments = new ArrayList<>();

    private Map<DayOfWeek, List<Appointment>> appointmentsByDay =
            new EnumMap<>(DayOfWeek.class);

    public ClinicSystem() {
        for (DayOfWeek day : DayOfWeek.values()) {
            appointmentsByDay.put(day, new ArrayList<>());
        }
    }

    // ---- Registration ----

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

    // ---- Appointment logic ----

    public Appointment requestAppointment(
            Patient patient,
            String specialty
    ) {
        for (Doctor doctor : doctors) {
            if (!doctor.getSpecialty().equalsIgnoreCase(specialty))
                continue;

            for (DayOfWeek day : DayOfWeek.values()) {
                if (day == DayOfWeek.SUNDAY) continue;

                if (doctor.canTakePatient(day)) {
                    Appointment appointment =
                            new Appointment(patient, doctor, day);

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

    // ---- Weekly reset ----

    public void resetWeek() {
        for (Doctor doctor : doctors) {
            doctor.resetWeek();
        }
        for (DayOfWeek day : appointmentsByDay.keySet()) {
            appointmentsByDay.get(day).clear();
        }
        allAppointments.clear();
    }

    // ---- Queries ----

    public List<Appointment> getAppointmentsForDay(DayOfWeek day) {
        return appointmentsByDay.get(day);
    }
}
