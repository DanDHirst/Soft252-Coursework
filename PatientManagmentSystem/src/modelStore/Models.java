/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelStore;

import adminmodels.AdministratorStorage;
import appointmentmodels.AppointmentStorage;
import appointmentmodels.PendingAppointments;
import doctormodels.DoctorFeedbackStorage;
import doctormodels.DoctorPendingFeedbackStorage;
import doctormodels.DoctorStorage;
import patientmodels.PatientStorage;
import patientmodels.PendingPatientAccounts;
import patientmodels.PendingTerminatePatientAccounts;
import prescriptionmodels.MedicineStore;
import prescriptionmodels.PrescriptionStorage;
import secretarymodels.SecretaryStorage;

/**
 *
 * @author dan
 */
public class Models {
    //User models
    public PatientStorage patientStore;
    public DoctorStorage doctorStore;
    public AdministratorStorage adminStore;
    public SecretaryStorage secretaryStore;
    public MedicineStore medicineStore;
    public PrescriptionStorage prescriptionStore;
    public DoctorFeedbackStorage doctorFeedbackStore;
    public DoctorPendingFeedbackStorage doctorPendingFeedbackStore;
    public AppointmentStorage appointmentStore;
    public PendingAppointments pendingAppointmentsStore;
    public PendingPatientAccounts pendingAccountsStore;
    public PendingTerminatePatientAccounts pendingTerminateStore;
    

   

    

    public Models(PatientStorage patientStore, DoctorStorage doctorStore, AdministratorStorage adminStore, SecretaryStorage secretaryStore, MedicineStore medicineStore, PrescriptionStorage prescriptionStore, DoctorFeedbackStorage doctorFeedbackStore, DoctorPendingFeedbackStorage doctorPendingFeedbackStore, AppointmentStorage appointmentStore, PendingAppointments pendingAppointmentsStore, PendingPatientAccounts pendingAccountsStore, PendingTerminatePatientAccounts pendingTerminateStore) {
        this.patientStore = patientStore;
        this.doctorStore = doctorStore;
        this.adminStore = adminStore;
        this.secretaryStore = secretaryStore;
        this.medicineStore = medicineStore;
        this.prescriptionStore = prescriptionStore;
        this.doctorFeedbackStore = doctorFeedbackStore;
        this.doctorPendingFeedbackStore = doctorPendingFeedbackStore;
        this.appointmentStore = appointmentStore;
        this.pendingAppointmentsStore = pendingAppointmentsStore;
        this.pendingAccountsStore = pendingAccountsStore;
        this.pendingTerminateStore = pendingTerminateStore;
    }

    
    
    

  
    
}
