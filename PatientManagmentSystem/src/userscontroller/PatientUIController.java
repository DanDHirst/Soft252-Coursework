/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userscontroller;

import UsersUI.PatientUI;
import appointmentmodels.Appointment;
import doctormodels.DoctorFeedback;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelStore.Models;
import prescriptionmodels.Medicine;
import prescriptionmodels.Prescription;
import usermodels.User;

/**
 *
 * @author dhirst1
 */
public class PatientUIController {
    public PatientUI PatientView;
    public Models modelStore;
    
    public PatientUIController(Models modelStore, String UserID) {
        this.modelStore = modelStore;
        PatientView = new PatientUI();    
        PatientView.setVisible(true);
        PatientView.setPatientID(UserID);
        this.PatientView.setBtnPatientTerminate(new PatientUIController.PatientTerminateListener());
        this.PatientView.setBtnPatientViewAppointment(new PatientUIController.PatientViewAppointment() );
        this.PatientView.setBtnPatientViewPrescription(new PatientUIController.PatientViewPrescription());
        this.PatientView.setBtnPatientViewDoctor(new PatientUIController.PatientViewDoctors());
        setPatientAppointmentBox(UserID);
        setPatientPrescriptionBox(UserID);
        setPatientDoctorBox();
       
        
    }
    private void setPatientAppointmentBox(String UserID){
        
        
        for (Appointment ap : modelStore.appointmentStore.getAppointments()) {
             if(ap.getPatientID().equals(UserID)){
                 PatientView.setBoxAppointment(ap.getStartTime().toString());
             }
        }

    }
    private void setPatientPrescriptionBox(String UserID){
                
        for (Prescription pr : modelStore.prescriptionStore.getPrescriptions()) {
             if(pr.getPatient().equals(UserID)){
                 PatientView.setBoxPrescription(pr.getDatePrescriped().toString());
             }
        }

    }
    private void setPatientDoctorBox(){
        
        for (User dr : modelStore.doctorStore.getUsers()) {
             PatientView.setBoxViewDoctors(dr.getUsername());
             PatientView.setBoxDoctors(dr.getUsername());
        }

    }
//    private void setPatientHistoryBox(String UserID){
//        // search for patient 
//        
//        
//        for (Appointment ap : modelStore.appointmentStore.getAppointments()) {
//            System.out.println(ap.getPatientID());
//             if(ap.getPatientID().equals(UserID)){
//                 PatientView.setBoxAppointment(ap.getStartTime().toString());
//             }
//        }
//        //loop through appointment
//        
//        //set appointment
//    }
    class PatientTerminateListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String patientID = PatientView.getPatientID();
            if(patientID != null){
                //get patients
                for (User p : modelStore.patientStore.getUsers()){
                    //search for exact patient
                    if(p.getUsername().equals(patientID)){
                    //add new patient to terminate patient
                    modelStore.pendingTerminateStore.addUser(p);
                    }
                }
            }  
        }  
    }
    class PatientViewAppointment implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           String AppointmentDate =  PatientView.getBoxAppointment();
           for (Appointment ap : modelStore.appointmentStore.getAppointments()) {
             if(ap.getPatientID().equals(PatientView.getPatientID())){
                 if (ap.getStartTime().toString().equals(AppointmentDate)) {
                     String AppointmentStartTime = Integer.toString(ap.getStartTime().getHour()) + ":"+Integer.toString(ap.getStartTime().getMinute());
                     String day = Integer.toString(ap.getStartTime().getDayOfMonth());
                     String month = Integer.toString(ap.getStartTime().getMonthValue());
                     String year = Integer.toString(ap.getStartTime().getYear());
                     String AppointmentDay = day + "/" + month + "/" + year;
                     PatientView.setTxtInfo("Appointment start time: " + AppointmentStartTime + "\n"
                             + "Appointment Date: " + AppointmentDay
                             + "\nDoctor ID: " + ap.getDoctorID() + "\n"+
                             "Reason: " + ap.getReason());
                 }
                 
             }
        }
        }
        
    }
    class PatientViewPrescription implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           String PrescriptionDate =  PatientView.getBoxPrescription();
           for (Prescription pr : modelStore.prescriptionStore.getPrescriptions()) {
             if(pr.getPatient().equals(PatientView.getPatientID())){
                 if (pr.getDatePrescriped().toString().equals(PrescriptionDate)) {
                     String PrescriptionStartTime = Integer.toString(pr.getDatePrescriped().getHour()) + ":"+Integer.toString(pr.getDatePrescriped().getMinute());
                     String day = Integer.toString(pr.getDatePrescriped().getDayOfMonth());
                     String month = Integer.toString(pr.getDatePrescriped().getMonthValue());
                     String year = Integer.toString(pr.getDatePrescriped().getYear());
                     String PrescriptionDay = day + "/" + month + "/" + year;
                     PatientView.setTxtInfo("Prescription start time: " + PrescriptionStartTime + "\n"
                             + "Prescription Date: " + PrescriptionDay
                             + "\nDoctor ID: " + pr.getDoctor() + "\n"+
                             "Reason: " + pr.getNotes());
                     for (Medicine meds : pr.getMedicines()) {
                         PatientView.addTxtInfo("\nMedicine name: " + meds.getName() +
                                 "\nMedicine dosage: " + meds.getDosage() +
                                 "\nMedicine Quantity: " + meds.getQuantity());
                     }
                 }
                 
             }
        }
        }
        
    }
    class PatientViewDoctors implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String doctor = PatientView.getBoxViewDoctors();
            float averageRating = 0;
            PatientView.setTxtInfo("Doctor: " + doctor);
            for(DoctorFeedback feedback : modelStore.doctorFeedbackStore.getDoctorsFeedback()){
                if (feedback.getDoctorID().equals(doctor)) {
                    PatientView.addTxtInfo("\nRating: " + feedback.getRating() + "\nComments: " + feedback.getFeedbackNotes());
                    averageRating += feedback.getRating();
                }
                
            }
            averageRating = averageRating / modelStore.doctorFeedbackStore.getDoctorsFeedback().size();
            PatientView.addTxtInfo("\nAverage Rating: " + averageRating);
        }
        
    }
}
