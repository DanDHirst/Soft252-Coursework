/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userscontroller;

import Serializer.WriteFile;
import UsersUI.PatientUI;
import appointmentmodels.Appointment;
import doctormodels.DoctorFeedback;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.Date;
import modelStore.Models;
import prescriptionmodels.Prescription;
import usermodels.User;

/**
 *
 * @author dhirst1
 */
public class PatientUIController {

    /**
     * This is were the view is stored
     */
    public PatientUI PatientView;

    /**
     * This is were the modelStore is stored
     */
    public Models modelStore;

    /**
     *This is were the writeFile is initialised
     */
    public WriteFile file = new WriteFile();
    
    /**
     *This is were the controller is set up
     * <p> sets up the patientView and the modelStore</p>
     * <p> sets up the onClicks</p>
     * <p> sets up the prescriptions, appointment, history and doctors data</p>
     * @param modelStore
     * @param UserID
     */
    public PatientUIController(Models modelStore, String UserID) {
        this.modelStore = modelStore;
        PatientView = new PatientUI();    
        PatientView.setVisible(true);
        PatientView.setPatientID(UserID);
        this.PatientView.setBtnPatientTerminate(new PatientUIController.PatientTerminateListener());
        this.PatientView.setBtnPatientViewAppointment(new PatientUIController.PatientViewAppointment() );
        this.PatientView.setBtnPatientViewPrescription(new PatientUIController.PatientViewPrescription());
        this.PatientView.setBtnPatientViewDoctor(new PatientUIController.PatientViewDoctors());
        this.PatientView.setBtnSaveFeedback(new PatientUIController.PatientSaveFeedback());
        this.PatientView.setBtnSubmitAppointment(new PatientUIController.PatientRequestAppointment());
        this.PatientView.setBtnPatientHistory(new PatientUIController.PatientHistoryShow());
        setPatientAppointmentBox(UserID);
        setPatientPrescriptionBox(UserID);
        setDoctorBoxes();
        setPatientHistoryBox(UserID);
       
        
    }

    /**
     *Save the model to file
     * <p> calls the writeFile object to write the models to the file</p>
     */
    public void saveData(){
        file.executeAction(modelStore);
    } 
    private void setPatientAppointmentBox(String UserID){
        
        
        for (Appointment ap : modelStore.appointmentStore.getAppointments()) {
             if(ap.getPatientID().equals(UserID) && ap.isCompleted() == false){
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
    private void setDoctorBoxes(){
        
        for (User dr : modelStore.doctorStore.getUsers()) {
             PatientView.setBoxViewDoctors(dr.getUsername());
             PatientView.setBoxDoctors(dr.getUsername());
             PatientView.setBoxDoctorsAppoitment(dr.getUsername());
        }

    }
    private void setPatientHistoryBox(String UserID){
        // search for patient 
        
        
        for (Appointment ap : modelStore.appointmentStore.getAppointments()) {
             if(ap.getPatientID().equals(UserID) && ap.isCompleted()){
                 PatientView.setBoxHistory(ap.getStartTime().toString());
             }
        }
        //loop through appointment
        
        //set appointment
    }
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
                saveData();
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
                     
                         PatientView.addTxtInfo("\nMedicine name: " + pr.getMedicine().getName() +
                                 "\nMedicine dosage: " + pr.getMedicine().getDosage() +
                                 "\nMedicine Quantity: " + pr.getMedicine().getQuantity());
                     
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
            saveData();
        }
        
    }
    class PatientSaveFeedback implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int rating = Integer.parseInt(PatientView.getBoxRating());
            String feedback = PatientView.getTxtFeedback();
            String doctor = PatientView.getBoxDoctor();
            int ratingID = modelStore.doctorPendingFeedbackStore.getDoctorsFeedback().size();
            
            DoctorFeedback drFeedback = new DoctorFeedback(doctor,rating,feedback,ratingID);
            modelStore.doctorPendingFeedbackStore.addDoctorFeedback(drFeedback);
            PatientView.setTxtFeedback("");
            PatientView.setTxtFeedbackResponse("Feedback submitted");
            saveData();
//            System.out.println(modelStore.doctorPendingFeedbackStore.getDoctorsFeedback().get(0).getFeedbackNotes());
        }
        
    }
    class PatientRequestAppointment implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           
            
            Date start = PatientView.getDateStart(); 
            String startDate = Integer.toString(start.getYear()+1900)+ "-" 
                    + checkDateMonth(start) + "-" 
                    + checkDateDay(start) + "T" + PatientView.getBoxStartHour()
                    + ":" + PatientView.getTxtMinStart() + ":" + "00";
            Date end = PatientView.getDateEnd();
            String endDate = Integer.toString(end.getYear()+1900)+ "-" 
                    + checkDateMonth(end) + "-" 
                    + checkDateDay(end) + "T" + PatientView.getBoxEndHour()
                    + ":" + PatientView.getTxtMinEnd() + ":" + "00";
            
            
            LocalDateTime datetimeStart = LocalDateTime.parse(startDate);
            LocalDateTime dateTimeEnd = LocalDateTime.parse(endDate);
            String doctor = PatientView.getBoxDoctorAppointment();
            String patientID = PatientView.getPatientID();
            int SizeOfAppoitments = modelStore.appointmentStore.getAppointments().size() -1;
            int getAppointmentID = modelStore.appointmentStore.getAppointments().get(SizeOfAppoitments).getAppointmentID() +1;
            Appointment ap = new Appointment(getAppointmentID,datetimeStart, dateTimeEnd, doctor, patientID);
            modelStore.pendingAppointmentsStore.addAppointment(ap);
            PatientView.setTxtAppResponse("Appointment requested");
            saveData();
            
        }
        public String checkDateDay(Date aDate){ // prevents from crashing if date is less than 10
            if (aDate.getDate() < 10) {
                String newDate = "0" + Integer.toString(aDate.getDate());
                
                return newDate;
            }
            return Integer.toString(aDate.getDate());
                      
        }
        public String checkDateMonth(Date aDate){ // prevents from crashing if month is less than 10
            if (aDate.getMonth() < 10 ) {
                String newDate = "0" + Integer.toString(aDate.getMonth() +1 );
                
                return newDate;
            }
            return Integer.toString(aDate.getMonth());
                      
        }
        
    }
    class PatientHistoryShow implements ActionListener {

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
}
