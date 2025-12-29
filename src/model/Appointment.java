package model;

import java.time.LocalDateTime;

public class Appointment {
    private Patient p;
    private Doctor d;
    private String appointementDate;
    private LocalDateTime dateTime;

    public Appointment(Patient p, Doctor d, String appointementDate, LocalDateTime dateTime) {
        this.p = p;
        this.d = d;
        this.appointementDate = appointementDate;
        this.dateTime = dateTime;
    }

    public Appointment() {
    }

    public Patient getP() {
        return p;
    }

    public void setP(Patient p) {
        this.p = p;
    }

    public Doctor getD() {
        return d;
    }

    public void setD(Doctor d) {
        this.d = d;
    }

    public String getAppointementDate() {
        return appointementDate;
    }

    public void setAppointementDate(String appointementDate) {
        this.appointementDate = appointementDate;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
