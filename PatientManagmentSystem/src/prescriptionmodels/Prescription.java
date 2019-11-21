/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prescriptionmodels;

import usermodels.Doctor;
import usermodels.Patient;

/**
 *
 * @author dhirst1
 */
public class Prescription {
    private Patient patient;
    private Doctor doctor;
    private String notes;

    public Prescription(Patient patient, Doctor doctor, String notes) {
        this.patient = patient;
        this.doctor = doctor;
        this.notes = notes;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
    
    
}
