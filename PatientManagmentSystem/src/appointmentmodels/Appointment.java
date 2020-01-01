package appointmentmodels;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author dhirst1
 */
public class Appointment implements Serializable{
    private int AppointmentID;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String doctorID;
    private String patientID;
    private String reason;
    private String notes;
    private boolean completed = false;

    /**
     *
     * @param AppointmentID
     * @param startTime
     * @param endTime
     * @param doctorID
     * @param patientID
     * @param reason
     */
    public Appointment(int AppointmentID, LocalDateTime startTime, LocalDateTime endTime, String doctorID, String patientID, String reason) {
        this.AppointmentID = AppointmentID;
        this.startTime = startTime;
        this.endTime = endTime;
        this.doctorID = doctorID;
        this.patientID = patientID;
        this.reason = reason;
    }

    /**
     *
     * @param AppointmentID
     * @param startTime
     * @param endTime
     * @param doctorID
     * @param patientID
     */
    public Appointment(int AppointmentID, LocalDateTime startTime, LocalDateTime endTime, String doctorID, String patientID) {
        this.AppointmentID = AppointmentID;
        this.startTime = startTime;
        this.endTime = endTime;
        this.doctorID = doctorID;
        this.patientID = patientID;
    }

    /**
     *
     * @param AppointmentID
     * @param startTime
     * @param doctorID
     * @param patientID
     * @param reason
     */
    public Appointment(int AppointmentID, LocalDateTime startTime, String doctorID, String patientID, String reason) {
        this.AppointmentID = AppointmentID;
        this.startTime = startTime;
        this.doctorID = doctorID;
        this.patientID = patientID;
        this.reason = reason;
    }
    
    /**
     *
     * @return
     */
    public LocalDateTime getStartTime() {
        return startTime;
    }

    /**
     *
     * @param startTime
     */
    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    /**
     *
     * @return
     */
    public LocalDateTime getEndTime() {
        return endTime;
    }

    /**
     *
     * @param endTime
     */
    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    /**
     *
     * @return
     */
    public String getDoctorID() {
        return doctorID;
    }

    /**
     *
     * @param doctorID
     */
    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
    }

    /**
     *
     * @return
     */
    public String getPatientID() {
        return patientID;
    }

    /**
     *
     * @param patientID
     */
    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    /**
     *
     * @return
     */
    public String getReason() {
        return reason;
    }

    /**
     *
     * @param reason
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     *
     * @return
     */
    public int getAppointmentID() {
        return AppointmentID;
    }

    /**
     *
     * @param AppointmentID
     */
    public void setAppointmentID(int AppointmentID) {
        this.AppointmentID = AppointmentID;
    }

    /**
     *
     * @return
     */
    public String getNotes() {
        return notes;
    }

    /**
     *
     * @param notes
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     *
     * @return
     */
    public boolean isCompleted() {
        return completed;
    }

    /**
     *
     * @param completed
     */
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
    
    
    
}
