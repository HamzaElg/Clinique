package model;

import java.time.DayOfWeek;
import java.util.*;

public class Doctor extends Person {

    private String specialty;
    private Map<DayOfWeek, Integer> capacityPerDay;
    private List<Appointment> appointments = new ArrayList<>();

    public Doctor(String id, String name, String specialty) {
        super(id, name);
        this.specialty = specialty;
        initWeeklyCapacity();
    }

    private void initWeeklyCapacity() {
        capacityPerDay = new EnumMap<>(DayOfWeek.class);
        capacityPerDay.put(DayOfWeek.MONDAY, 30);
        capacityPerDay.put(DayOfWeek.TUESDAY, 30);
        capacityPerDay.put(DayOfWeek.WEDNESDAY, 30);
        capacityPerDay.put(DayOfWeek.THURSDAY, 30);
        capacityPerDay.put(DayOfWeek.FRIDAY, 30);
        capacityPerDay.put(DayOfWeek.SATURDAY, 20);
    }

    public boolean canTakePatient(DayOfWeek day) {
        return capacityPerDay.getOrDefault(day, 0) > 0;
    }

    public void assignAppointment(Appointment appointment) {
        DayOfWeek day = appointment.getDay();
        capacityPerDay.put(day, capacityPerDay.get(day) - 1);
        appointments.add(appointment);
    }

    public void resetWeek() {
        initWeeklyCapacity();
        appointments.clear();
    }

    public String getSpecialty() {
        return specialty;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    @Override
    public String getRole() {
        return "Doctor";
    }

    @Override
    public void showInfos(){
        System.out.println("- Doctor name:" + name);
        System.out.println("- Doctor ID" + id);
        System.out.println("- Doctor speciality" + specialty);
    }
}
