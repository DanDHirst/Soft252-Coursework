/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package authUserControllers;

import adminmodels.AdministratorStorage;
import appointmentmodels.AppointmentStorage;
import appointmentmodels.PendingAppointments;
import authusersview.AuthDoctorUI;
import doctormodels.DoctorFeedbackStorage;
import doctormodels.DoctorStorage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import patientmodels.PatientStorage;
import prescriptionmodels.PrescriptionStorage;
import secretarymodels.SecretaryStorage;
import usermodels.User;
import userscontroller.DoctorUIController;

/**
 *
 * @author dhirst1
 */
public class AuthDoctorController {
    public AuthDoctorUI AuthDoctorView;
    public PatientStorage patientStore;
    public DoctorStorage doctorStore;
    public AdministratorStorage adminStore;
    public SecretaryStorage secretaryStore;
    
    public PrescriptionStorage prescriptionStore;
    public DoctorFeedbackStorage doctorFeedbackStore;
    public AppointmentStorage appointmentStore;
    public PendingAppointments pendingAppointmentsStore;
    
    public AuthDoctorController(PatientStorage patients,DoctorStorage doctors, 
            AdministratorStorage admins, SecretaryStorage secretaries, 
            PrescriptionStorage prescriptions,DoctorFeedbackStorage doctorFeedback, 
            AppointmentStorage appointments, PendingAppointments pendingAppointments) {
        this.patientStore = patients;
        this.doctorStore = doctors;
        this.adminStore =admins;
        this.secretaryStore = secretaries;
        this.prescriptionStore = prescriptions;
        this.doctorFeedbackStore = doctorFeedback;
        this.appointmentStore = appointments;
        this.pendingAppointmentsStore = pendingAppointments; 
        AuthDoctorView = new AuthDoctorUI();    
        AuthDoctorView.setVisible(true);
        //this.AuthPatientView.setBtnListner(new AuthPatientController.RedirectListener());
        this.AuthDoctorView.setBtnDoctorLoginListner(new AuthDoctorController.DoctorAuthRedirectListener());
    }
    class DoctorAuthRedirectListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent arg0) {
            String UserID = checkLogin(AuthDoctorView.getUsername(),AuthDoctorView.getPassword());
            if( UserID != null){
                DoctorUIController AuthController= new DoctorUIController();   
                AuthDoctorView.setVisible(false);
            }
            else{
                AuthDoctorView.setTxtResponse("invalid username and/or password");
            }
        }
        public String checkLogin(String Username,String Password){

            for (User p : doctorStore.getUsers()){
                if(p.getUsername().equals(Username) && p.getPassword().equals(Password)){
                    return p.getUsername();
                }
            }
            return null;
        }
        
    }
}