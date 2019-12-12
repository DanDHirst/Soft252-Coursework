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
import patientmodels.PatientStorage;
import prescriptionmodels.PrescriptionStorage;
import secretarymodels.SecretaryStorage;

/**
 *
 * @author dhirst1
 */
public class PatientUIController {
    public PatientUI PatientView;
    public PatientStorage patientStore;
    public DoctorStorage doctorStore;
    public AdministratorStorage adminStore;
    public SecretaryStorage secretaryStore;
    
    public PrescriptionStorage prescriptionStore;
    public DoctorFeedbackStorage doctorFeedbackStore;
    public AppointmentStorage appointmentStore;
    public PendingAppointments pendingAppointmentsStore;
    
    public PatientUIController(PatientStorage patients,DoctorStorage doctors, 
            AdministratorStorage admins, SecretaryStorage secretaries, 
            PrescriptionStorage prescriptions,DoctorFeedbackStorage doctorFeedback, 
            AppointmentStorage appointments, PendingAppointments pendingAppointments,
            String UserID) {
        PatientView = new PatientUI();    
        PatientView.setVisible(true);
        PatientView.setPatientID(UserID);
    }
}
