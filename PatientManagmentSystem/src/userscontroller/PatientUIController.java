/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userscontroller;

import UsersUI.PatientUI;
import adminmodels.AdministratorStorage;
import appointmentmodels.AppointmentStorage;
import appointmentmodels.PendingAppointments;
import authusersview.AuthPatientUI;
import doctormodels.DoctorFeedbackStorage;
import doctormodels.DoctorStorage;
import modelStore.Models;
import patientmodels.PatientStorage;
import prescriptionmodels.PrescriptionStorage;
import secretarymodels.SecretaryStorage;

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
    }
}
