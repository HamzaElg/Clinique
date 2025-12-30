package model;

import java.time.DayOfWeek;

public class Appointment {

    private Patient patient;
    private Doctor doctor;
    private DayOfWeek day;
    private MedicalRecord medicalRecord;

    public Appointment(Patient patient, Doctor doctor, DayOfWeek day) {
        this.patient = patient;
        this.doctor = doctor;
        this.day = day;
    }

    public void addMedicalRecord(MedicalRecord record) {
        this.medicalRecord = record;
    }

    public Patient getPatient() { return patient; }
    public Doctor getDoctor() { return doctor; }
    public DayOfWeek getDay() { return day; }
}
