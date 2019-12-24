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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import modelStore.Models;
import prescriptionmodels.Medicine;
import prescriptionmodels.Prescription;

/**
 *
 * @author dhirst1
 */
public class DoctorUIController {
    public Models modelStore;
    public DoctorUI DoctorView;
    public WriteFile file = new WriteFile();

    public DoctorUIController(Models modelStore, String UserID) {
        this.modelStore = modelStore;
        this.DoctorView = new DoctorUI();
        DoctorView.setVisible(true);
        DoctorView.setTxtDoctorID(UserID);
        setUpOnClicks();
        setUpAppointment();
        setUpPatients();
    }
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
            saveData();
        }
        
    }
            
}
