package model;

import java.util.ArrayList;
import java.util.List;

public class Patient extends Person {

    private List<Appointment> history = new ArrayList<>();

    public Patient(String id, String name) {
        super(id, name);
    }

    public void addAppointment(Appointment appointment) {
        history.add(appointment);
    }

    public List<Appointment> getHistory() {
        return history;
    }

    @Override
    public String getRole() {
        return "Patient";
    }
}
