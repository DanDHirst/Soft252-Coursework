package appointmentmodels;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.time.LocalDateTime;

/**
 *
 * @author dhirst1
 */
public class Appointment {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String doctorID;
    private String patientID;
    private String reason;

    public Appointment(LocalDateTime startTime, LocalDateTime endTime, String doctor, String patient) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.doctorID = doctor;
        this.patientID = patient;
    }

    public Appointment(LocalDateTime startTime, String doctorID, String patientID) {
        this.startTime = startTime;
        this.doctorID = doctorID;
        this.patientID = patientID;
    }
    

    public Appointment(LocalDateTime startTime, LocalDateTime endTime, String doctor, String patient, String reason) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.doctorID = doctor;
        this.patientID = patient;
        this.reason = reason;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
    
}
