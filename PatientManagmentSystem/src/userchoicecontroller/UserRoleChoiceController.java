/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userchoicecontroller;

import adminmodels.AdministratorStorage;
import appointmentmodels.AppointmentStorage;
import appointmentmodels.PendingAppointments;
import authUserControllers.AuthAdminController;
import authUserControllers.AuthDoctorController;
import authUserControllers.AuthPatientController;
import authUserControllers.AuthSecretaryController;
import doctormodels.DoctorFeedbackStorage;
import doctormodels.DoctorStorage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import patientmodels.PatientStorage;
import prescriptionmodels.PrescriptionStorage;
import secretarymodels.SecretaryStorage;
import userchoiceview.UserRoleChoice;

/**
 *
 * @author dhirst1
 */
public class UserRoleChoiceController {
    public UserRoleChoice theView;
    //User models
    public PatientStorage patientStore;
    public DoctorStorage doctorStore;
    public AdministratorStorage adminStore;
    public SecretaryStorage secretaryStore;
    
    public PrescriptionStorage prescriptionStore;
    public DoctorFeedbackStorage doctorFeedbackStore;
    public AppointmentStorage appointmentStore;
    public PendingAppointments pendingAppointmentsStore;
    public UserRoleChoiceController(PatientStorage patients,DoctorStorage doctors, 
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
        
        theView = new UserRoleChoice();    
        theView.setVisible(true);
        this.theView.setBtnAdminListner(new AdminRedirectListener());
        this.theView.setBtnPatientListner(new PatientRedirectListener());
        this.theView.setBtnDoctorListner(new DoctorRedirectListener());
        this.theView.setBtnSecretaryListner(new SecretaryRedirectListener());
    }

    class AdminRedirectListener implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent arg0) {
            AuthAdminController AuthController= new AuthAdminController(patientStore, doctorStore , adminStore
        ,secretaryStore, prescriptionStore, doctorFeedbackStore,appointmentStore
        ,pendingAppointmentsStore);   
            theView.setVisible(false);
        }
        
    }
    class DoctorRedirectListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent arg0) {
            AuthDoctorController AuthController= new AuthDoctorController(patientStore, doctorStore , adminStore
        ,secretaryStore, prescriptionStore, doctorFeedbackStore,appointmentStore
        ,pendingAppointmentsStore);   
            theView.setVisible(false);
        }
        
    }
    class PatientRedirectListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent arg0) {
            AuthPatientController AuthController= new AuthPatientController(patientStore, doctorStore , adminStore
        ,secretaryStore, prescriptionStore, doctorFeedbackStore,appointmentStore
        ,pendingAppointmentsStore);   
            theView.setVisible(false);
        }
        
    }
    class SecretaryRedirectListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent arg0) {
            AuthSecretaryController AuthController= new AuthSecretaryController(patientStore, doctorStore , adminStore
        ,secretaryStore, prescriptionStore, doctorFeedbackStore,appointmentStore
        ,pendingAppointmentsStore);   
            theView.setVisible(false);
        }
        
    }
    
    
}
