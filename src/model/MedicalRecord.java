package model;

import java.util.ArrayList;

public class MedicalRecord {
    private ArrayList<String> meds = new ArrayList<>();
    private ArrayList<String> radios = new ArrayList<>();

    public MedicalRecord() {
    }

    public MedicalRecord(ArrayList<String> meds, ArrayList<String> radios) {
        this.meds = meds;
        this.radios = radios;
    }

    public ArrayList<String> getMeds() {
        return meds;
    }

    public void setMeds(ArrayList<String> meds) {
        this.meds = meds;
    }

    public ArrayList<String> getRadios() {
        return radios;
    }

    public void setRadios(ArrayList<String> radios) {
        this.radios = radios;
    }
}
