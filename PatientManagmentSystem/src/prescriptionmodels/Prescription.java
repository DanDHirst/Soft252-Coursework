/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prescriptionmodels;

import patientmodels.Patient;
import doctormodels.Doctor;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author dhirst1
 */
public class Prescription {
    private String patientID;
    private String doctorID;
    private String notes;
    private LocalDateTime datePrescriped; 
    ArrayList<Medicine> medicines = new ArrayList<>();

    public Prescription(String patient, String doctor, String notes) {
        this.patientID = patient;
        this.doctorID = doctor;
        this.notes = notes;
    }

    public Prescription(String patientID, String doctorID, String notes, LocalDateTime datePrescriped) {
        this.patientID = patientID;
        this.doctorID = doctorID;
        this.notes = notes;
        this.datePrescriped = datePrescriped;
    }

    public LocalDateTime getDatePrescriped() {
        return datePrescriped;
    }

    public void setDatePrescriped(LocalDateTime datePrescriped) {
        this.datePrescriped = datePrescriped;
    }
    

    public String getPatient() {
        return patientID;
    }

    public void setPatient(String patient) {
        this.patientID = patient;
    }

    public String getDoctor() {
        return doctorID;
    }

    public void setDoctor(String doctor) {
        this.doctorID = doctor;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public ArrayList<Medicine> getMedicines() {
        return medicines;
    }
    public void addMedicine(Medicine medicine){
        this.medicines.add(medicine);
    }
    
    
}
