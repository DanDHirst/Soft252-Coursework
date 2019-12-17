/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userscontroller;

import UsersUI.PatientUI;
import appointmentmodels.Appointment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import modelStore.Models;
import patientmodels.Patient;
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
        setPatientAppointmentBox(UserID);
        setPatientPrescriptionBox(UserID);
        //load and add appointments to the patient
        
    }
    private void setPatientAppointmentBox(String UserID){
        // search for patient 
        LocalDateTime now = LocalDateTime.now();
        Appointment app = new Appointment(now,"doctoMan","person123");
        modelStore.appointmentStore.addAppointment(app);
        for (Appointment ap : modelStore.appointmentStore.getAppointments()) {
             if(ap.getPatientID().equals(UserID)){
                 PatientView.setBoxAppointment(ap.getStartTime().toString());
             }
        }
        //loop through appointment
        
        //set appointment
    }
    private void setPatientPrescriptionBox(String UserID){
        // search for patient 
        LocalDateTime now = LocalDateTime.now();
        Prescription pre = new Prescription("person123","doctroman","",now);
        modelStore.prescriptionStore.addPrescription(pre);
        System.out.println(modelStore.prescriptionStore.getPrescriptions());
        for (Prescription pr : modelStore.prescriptionStore.getPrescriptions()) {
            System.out.println(pr.getDatePrescriped().toString());
             if(pr.getPatient().equals(UserID)){
                 PatientView.setBoxPrescription(pr.getDatePrescriped().toString());
             }
        }
        //loop through appointment
        
        //set appointment
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
}
