/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userscontroller;

import UsersUI.DoctorUI;
import appointmentmodels.Appointment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import modelStore.Models;

/**
 *
 * @author dhirst1
 */
public class DoctorUIController {
    public Models modelStore;
    public DoctorUI DoctorView;

    public DoctorUIController(Models modelStore, String UserID) {
        this.modelStore = modelStore;
        this.DoctorView = new DoctorUI();
        DoctorView.setVisible(true);
        DoctorView.setTxtDoctorID(UserID);
        setUpOnClicks();
        setUpAppointment();
    }
    
    private void setUpOnClicks(){
        this.DoctorView.listAppointmentsOnChange(new DoctorUIController.ShowAppointment());
        this.DoctorView.btnCompleteAppointment(new DoctorUIController.CompleteAppointment());
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
    private void clearAppointmentInfo(){
        DoctorView.setTxtAppointmentID("");
        DoctorView.setTxtAppointmentDate("");
        DoctorView.setTxtAppointmentTime("");
        DoctorView.setTxtAppointmentPatient("");
        DoctorView.setTxtAppointmentReason("");
        DoctorView.setTxtAppointmentNotes("");
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
        }
        
    }
}
