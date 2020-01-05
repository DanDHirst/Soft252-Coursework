/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userscontroller;

import Serializer.WriteFile;
import UsersUI.DoctorUI;
import appointmentmodels.Appointment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import modelStore.Models;
import prescriptionmodels.Medicine;
import prescriptionmodels.Prescription;
import usermodels.User;

/**
 *
 * @author dhirst1
 */
public class DoctorUIController {

    /**
     *Sets up the modelStore
     */
    public Models modelStore;

    /**
     * this is were the view is stored
     */
    public DoctorUI DoctorView;

    /**
     *The writeFile is Initialised here
     */
    public WriteFile file = new WriteFile();

    /**
     * Constructor to set up the controller
     * <p> sets up the view and modelStore </p>
     * <p> sets up the onclicks listeners </p>
     * <p> set up the appointment and patient data </p>
     * @param modelStore
     * @param UserID
     */
    public DoctorUIController(Models modelStore, String UserID) {
        this.modelStore = modelStore;
        this.DoctorView = new DoctorUI();
        DoctorView.setVisible(true);
        DoctorView.setTxtDoctorID(UserID);
        setUpOnClicks();
        setUpAppointment();
        setUpPatients();
    }

    /**
     *Save the model to file
     * <p> calls the writeFile object to write the models to the file</p>
     */
    public void saveData(){
        file.executeAction(modelStore);
    } 
    private void setUpOnClicks(){
        this.DoctorView.listAppointmentsOnChange(new DoctorUIController.ShowAppointment());
        this.DoctorView.btnCompleteAppointment(new DoctorUIController.CompleteAppointment());
        this.DoctorView.listHistoryPatientOnChange(new DoctorUIController.showHistoryAppointments());
        this.DoctorView.listHistoryAppointmentsOnChange(new DoctorUIController.showHistoryAppointmentInfo());
        this.DoctorView.listPatientPrescribeOnChange(new DoctorUIController.SelectPatientPrescibe());
        this.DoctorView.btnPrescribeMedicine(new DoctorUIController.savePrescription());
        this.DoctorView.btnRequestMedicine(new DoctorUIController.RequestMedicine());
        this.DoctorView.btnSubmitAppointment(new DoctorUIController.DoctorRequestAppointment());
    }
    private void setUpAppointment(){
        int appointLength = modelStore.appointmentStore.getAppointments().size();
        String[] appointments = new  String[modelStore.appointmentStore.getAppointments().size()];
        String doctorID = this.DoctorView.getTxtDoctorID();
        for (int i = 0; i < appointLength; i++) {
            if (doctorID.equals(modelStore.appointmentStore.getAppointments().get(i).getDoctorID()) && modelStore.appointmentStore.getAppointments().get(i).isCompleted() == false) {
                appointments[i] = Integer.toString(modelStore.appointmentStore.getAppointments().get(i).getAppointmentID());
            }
        }
        
        this.DoctorView.setListAppointments(appointments);
    }
    private void setUpPatients(){
        int pLength = modelStore.patientStore.getUsers().size();
        String[] pList = new String[pLength];
        for (int i = 0; i < pLength; i++) {
            pList[i] = modelStore.patientStore.getUsers().get(i).getUsername();
           
        }
        DoctorView.setListHistoryPatient(pList);
        DoctorView.setListPatientPrescribe(pList);
        for (User pat : modelStore.patientStore.getUsers()) {
            DoctorView.setBoxPatient(pat.getUsername());
        }
        
    }
    private void clearAppointmentInfo(){
        DoctorView.setTxtAppointmentID("");
        DoctorView.setTxtAppointmentDate("");
        DoctorView.setTxtAppointmentTime("");
        DoctorView.setTxtAppointmentPatient("");
        DoctorView.setTxtAppointmentReason("");
        DoctorView.setTxtAppointmentNotes("");
    }
    private void clearPrescriptionInfo(){
        DoctorView.setTxtPrescribeMedDose("");
        DoctorView.setTxtPrescribeMedName("");
        DoctorView.setTxtPrescribeMedQty("");
        DoctorView.setTxtPrescribeNotes("");
    }
    private void clearRequestMedicine(){
        DoctorView.setTxtRequestMedName("");
        DoctorView.setTxtRequestMedQty("");
    }
    
    class ShowAppointment implements ListSelectionListener{

        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (DoctorView.getListAppointments() != null) {
                int appointmentID = Integer.parseInt(DoctorView.getListAppointments());
            for(Appointment app : modelStore.appointmentStore.getAppointments()){
                if (app.getAppointmentID() == appointmentID) {
                    DoctorView.setTxtAppointmentID(Integer.toString(app.getAppointmentID()));
                    DoctorView.setTxtAppointmentDate(app.getStartTime().format(DateTimeFormatter.ISO_DATE));
                    DoctorView.setTxtAppointmentTime(app.getStartTime().format(DateTimeFormatter.ISO_LOCAL_TIME)+ " - " + app.getEndTime().format(DateTimeFormatter.ISO_TIME));
                    DoctorView.setTxtAppointmentPatient(app.getPatientID());
                    DoctorView.setTxtAppointmentReason(app.getReason());
                    DoctorView.setTxtAppointmentNotes(app.getNotes());
                }
            }
            }
            
            
        }
        
    }
    class CompleteAppointment implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int appointmentID = Integer.parseInt(DoctorView.getTxtAppointmentID());
            String notes = DoctorView.getTxtAppointmentNotes();
            for(Appointment app : modelStore.appointmentStore.getAppointments()){
                if (app.getAppointmentID() == appointmentID) {
                    app.setNotes(notes);
                    app.setCompleted(true);
                }
                
            }
            DoctorView.deselectAppointment();
            clearAppointmentInfo();
            setUpAppointment();
            saveData();
        }
        
    }
    class showHistoryAppointments implements ListSelectionListener{

        @Override
        public void valueChanged(ListSelectionEvent e) {
            String patientID = DoctorView.getListHistoryPatient();
            int pLength = modelStore.appointmentStore.getAppointments().size();
            String[] pList = new String[pLength];
            for (int i = 0; i < pLength; i++) {
                if(modelStore.appointmentStore.getAppointments().get(i).getPatientID().equals(patientID) && modelStore.appointmentStore.getAppointments().get(i).isCompleted()){
                    pList[i] = Integer.toString(modelStore.appointmentStore.getAppointments().get(i).getAppointmentID());
                }  
            }
            DoctorView.setListHistoryAppointments(pList);
            saveData();
                    
        }
        
    }
    class showHistoryAppointmentInfo implements ListSelectionListener{

        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (DoctorView.getListHistoryAppointments() != null) {
                int appID = Integer.parseInt(DoctorView.getListHistoryAppointments());
            for(Appointment app : modelStore.appointmentStore.getAppointments()){
                if (app.getAppointmentID() == appID) {
                    DoctorView.setHistoryTxtAppointmentID(Integer.toString(app.getAppointmentID()));
                    DoctorView.setHistoryTxtAppointmentDate(app.getStartTime().format(DateTimeFormatter.ISO_DATE));
                    DoctorView.setTxtHistoryAppointmentTime(app.getStartTime().format(DateTimeFormatter.ISO_LOCAL_TIME)+ " - " + app.getEndTime().format(DateTimeFormatter.ISO_TIME));
                    DoctorView.setTxtHistoryAppointmentPatient(app.getPatientID());
                    DoctorView.setTxtHistoryAppointmentReason(app.getReason());
                    DoctorView.setTxtHistoryAppointmentNotes(app.getNotes());
                }
                
            }
            saveData();
            }
            
            
            
                    
        }
        
    }
    class SelectPatientPrescibe implements ListSelectionListener{

        @Override
        public void valueChanged(ListSelectionEvent e) {
            String patientID = DoctorView.getListPatientPrescribe();
            DoctorView.setTxtPrescribePatient(patientID);
            
        }
        
        
    }
    class savePrescription implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String patientID = DoctorView.getTxtPrescribePatient();
            String doctorID = DoctorView.getTxtDoctorID();
            String medName = DoctorView.getTxtPrescribeMedName();
            String medQty = DoctorView.getTxtPrescribeMedQty();
            String medDose = DoctorView.getTxtPrescribeMedDose();
            String notes = DoctorView.getTxtPrescribeNotes();
            LocalDateTime now = LocalDateTime.now();
            int prescriptionID = modelStore.prescriptionStore.getPrescriptions().size();
            Medicine med = new Medicine(medName, Integer.parseInt(medQty),medDose );
            
            Prescription newPresc = new Prescription(prescriptionID, patientID, doctorID, notes,
            now,med);
            modelStore.prescriptionStore.addPrescription(newPresc);
            clearPrescriptionInfo();
            saveData();
        }
        
    }
    class RequestMedicine implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String medName = DoctorView.getTxtRequestMedName();
            int medQty = Integer.parseInt(DoctorView.getTxtRequestMedQty());
            
            Medicine med = new Medicine(medName, medQty);
            modelStore.requestMedicineStore.addMedicine(med);
            clearRequestMedicine();
            DoctorView.setTxtMedResponse("Medicine requested");
            saveData();
        }
        
    }
            
    class DoctorRequestAppointment implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           
            
            Date start = DoctorView.getDateStart(); 
            String startDate = Integer.toString(start.getYear()+1900)+ "-" 
                    + checkDateMonth(start) + "-" 
                    + checkDateDay(start) + "T" + DoctorView.getBoxStartHour()
                    + ":" + DoctorView.getTxtMinStart() + ":" + "00";
            Date end = DoctorView.getDateEnd();
            String endDate = Integer.toString(end.getYear()+1900)+ "-" 
                    + checkDateMonth(end) + "-" 
                    + checkDateDay(end) + "T" + DoctorView.getBoxEndHour()
                    + ":" + DoctorView.getTxtMinEnd() + ":" + "00";
            
            
            LocalDateTime datetimeStart = LocalDateTime.parse(startDate);
            LocalDateTime dateTimeEnd = LocalDateTime.parse(endDate);
            String doctor = DoctorView.getTxtDoctorID();
            String patientID = DoctorView.getBoxPatient();
            
            int SizeOfAppoitments = modelStore.appointmentStore.getAppointments().size() -1;
            int getAppointmentID = modelStore.appointmentStore.getAppointments().get(SizeOfAppoitments).getAppointmentID() +1;
            Appointment ap = new Appointment(getAppointmentID,datetimeStart, dateTimeEnd, doctor, patientID);
            modelStore.pendingAppointmentsStore.addAppointment(ap);
            DoctorView.setTxtAppResponse("Appointment Requested");
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
            if (aDate.getMonth() < 10) {
                String newDate = "0" + Integer.toString(aDate.getMonth());
                
                return newDate;
            }
            return Integer.toString(aDate.getMonth());
                      
        }
        
    }
}
