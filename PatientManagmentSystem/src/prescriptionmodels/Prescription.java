/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prescriptionmodels;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author dhirst1
 */
public class Prescription implements Serializable{
    private int prescriptionID;
    private String patientID;
    private String doctorID;
    private String notes;
    private LocalDateTime datePrescriped; 
    Medicine medicine;
    private boolean Completed = false;

    public Prescription(String patient, String doctor, String notes) {
        this.patientID = patient;
        this.doctorID = doctor;
        this.notes = notes;
    }



    public Prescription(int prescriptionID, String patientID, String doctorID, String notes, LocalDateTime datePrescriped, Medicine medicine) {
        this.prescriptionID = prescriptionID;
        this.patientID = patientID;
        this.doctorID = doctorID;
        this.notes = notes;
        this.datePrescriped = datePrescriped;
        this.medicine = medicine;
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

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }
    
    public void completePrescription(){
        this.Completed = true;
    }

    public int getPrescriptionID() {
        return prescriptionID;
    }

    public void setPrescriptionID(int prescriptionID) {
        this.prescriptionID = prescriptionID;
    }

    public boolean isCompleted() {
        return Completed;
    }
        

    
    
    
}
