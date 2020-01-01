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

    /**
     * constructor to set up a prescription
     * @param patient
     * @param doctor
     * @param notes
     */
    public Prescription(String patient, String doctor, String notes) {
        this.patientID = patient;
        this.doctorID = doctor;
        this.notes = notes;
    }

    /**
     * constructor to set up a prescription
     * @param prescriptionID
     * @param patientID
     * @param doctorID
     * @param notes
     * @param datePrescriped
     * @param medicine
     */
    public Prescription(int prescriptionID, String patientID, String doctorID, String notes, LocalDateTime datePrescriped, Medicine medicine) {
        this.prescriptionID = prescriptionID;
        this.patientID = patientID;
        this.doctorID = doctorID;
        this.notes = notes;
        this.datePrescriped = datePrescriped;
        this.medicine = medicine;
    }
    
    /**
     * gets the date prescriped
     * @return a localDateTime of the date prescriped
     */
    public LocalDateTime getDatePrescriped() {
        return datePrescriped;
    }

    /**
     * sets the localdatatime of the date prescriped
     * @param datePrescriped
     */
    public void setDatePrescriped(LocalDateTime datePrescriped) {
        this.datePrescriped = datePrescriped;
    }
    
    /**
     * gets the patientID
     * @return the string patientID
     */
    public String getPatient() {
        return patientID;
    }

    /**
     * sets the patientID
     * @param patient
     */
    public void setPatient(String patient) {
        this.patientID = patient;
    }

    /**
     * gets the doctor ID
     * @return the string doctorID
     */
    public String getDoctor() {
        return doctorID;
    }

    /**
     * sets the doctor ID
     * @param doctor
     */
    public void setDoctor(String doctor) {
        this.doctorID = doctor;
    }

    /**
     * gets the prescription notes
     * @return String Notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     * sets the prescription notes
     * @param notes
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * gets the medicines
     * @return an object medicine
     */
    public Medicine getMedicine() {
        return medicine;
    }

    /**
     * sets the medicine 
     * @param medicine
     */
    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }
    
    /**
     * When the prescription is complete this method is called
     */
    public void completePrescription(){
        this.Completed = true;
    }

    /**
     * gets the prescription ID
     * @return the precription ID
     */
    public int getPrescriptionID() {
        return prescriptionID;
    }

    /**
     * sets the prescription ID
     * @param prescriptionID
     */
    public void setPrescriptionID(int prescriptionID) {
        this.prescriptionID = prescriptionID;
    }

    /**
     * check if is Complete
     * @return if completed
     */
    public boolean isCompleted() {
        return Completed;
    }
        

    
    
    
}
