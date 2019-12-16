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
import modelStore.Models;
import patientmodels.PatientStorage;
import patientmodels.PendingPatientAccounts;
import patientmodels.PendingTerminatePatientAccounts;
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
    public Models modelStore;
    public UserRoleChoiceController(Models modelStore) {
        
        this.modelStore = modelStore;
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
            AuthAdminController AuthController= new AuthAdminController(modelStore);   
            theView.setVisible(false);
        }
        
    }
    class DoctorRedirectListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent arg0) {
            AuthDoctorController AuthController= new AuthDoctorController(modelStore);   
            theView.setVisible(false);
        }
        
    }
    class PatientRedirectListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent arg0) {
            AuthPatientController AuthController= new AuthPatientController(modelStore);   
            theView.setVisible(false);
        }
        
    }
    class SecretaryRedirectListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent arg0) {
            AuthSecretaryController AuthController= new AuthSecretaryController(modelStore);   
            theView.setVisible(false);
        }
        
    }
    
    
}
