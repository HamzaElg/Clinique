package model;

import java.util.List;

public class MedicalRecord {

    private List<String> medications;
    private List<String> exams;

    public MedicalRecord(List<String> medications, List<String> exams) {
        this.medications = medications;
        this.exams = exams;
    }
}
