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
import doctormodels.DoctorStorage;
import patientmodels.PatientStorage;
import patientmodels.PendingPatientAccounts;
import patientmodels.PendingTerminatePatientAccounts;
import prescriptionmodels.PrescriptionStorage;
import secretarymodels.SecretaryStorage;
import userchoiceview.UserRoleChoice;

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
    
    public PrescriptionStorage prescriptionStore;
    public DoctorFeedbackStorage doctorFeedbackStore;
    public AppointmentStorage appointmentStore;
    public PendingAppointments pendingAppointmentsStore;
    public PendingPatientAccounts pendingAccountsStore;

    public Models(PatientStorage patientStore, DoctorStorage doctorStore, AdministratorStorage adminStore, SecretaryStorage secretaryStore, PrescriptionStorage prescriptionStore, DoctorFeedbackStorage doctorFeedbackStore, AppointmentStorage appointmentStore, PendingAppointments pendingAppointmentsStore, PendingPatientAccounts pendingAccountsStore) {
        this.patientStore = patientStore;
        this.doctorStore = doctorStore;
        this.adminStore = adminStore;
        this.secretaryStore = secretaryStore;
        this.prescriptionStore = prescriptionStore;
        this.doctorFeedbackStore = doctorFeedbackStore;
        this.appointmentStore = appointmentStore;
        this.pendingAppointmentsStore = pendingAppointmentsStore;
        this.pendingAccountsStore = pendingAccountsStore;
    }

    public Models(PatientStorage patientStore, DoctorStorage doctorStore, AdministratorStorage adminStore, SecretaryStorage secretaryStore, PrescriptionStorage prescriptionStore, DoctorFeedbackStorage doctorFeedbackStore, AppointmentStorage appointmentStore, PendingAppointments pendingAppointmentsStore, PendingTerminatePatientAccounts pendingTerminateAccountsStore, PendingPatientAccounts pendingAccountsStore) {
        this.patientStore = patientStore;
        this.doctorStore = doctorStore;
        this.adminStore = adminStore;
        this.secretaryStore = secretaryStore;
        this.prescriptionStore = prescriptionStore;
        this.doctorFeedbackStore = doctorFeedbackStore;
        this.appointmentStore = appointmentStore;
        this.pendingAppointmentsStore = pendingAppointmentsStore;
        this.pendingAccountsStore = pendingAccountsStore;
    }
    

    public PatientStorage getPatientStore() {
        return patientStore;
    }

    public void setPatientStore(PatientStorage patientStore) {
        this.patientStore = patientStore;
    }

    public DoctorStorage getDoctorStore() {
        return doctorStore;
    }

    public void setDoctorStore(DoctorStorage doctorStore) {
        this.doctorStore = doctorStore;
    }

    public AdministratorStorage getAdminStore() {
        return adminStore;
    }

    public void setAdminStore(AdministratorStorage adminStore) {
        this.adminStore = adminStore;
    }

    public SecretaryStorage getSecretaryStore() {
        return secretaryStore;
    }

    public void setSecretaryStore(SecretaryStorage secretaryStore) {
        this.secretaryStore = secretaryStore;
    }

    public PrescriptionStorage getPrescriptionStore() {
        return prescriptionStore;
    }

    public void setPrescriptionStore(PrescriptionStorage prescriptionStore) {
        this.prescriptionStore = prescriptionStore;
    }

    public DoctorFeedbackStorage getDoctorFeedbackStore() {
        return doctorFeedbackStore;
    }

    public void setDoctorFeedbackStore(DoctorFeedbackStorage doctorFeedbackStore) {
        this.doctorFeedbackStore = doctorFeedbackStore;
    }

    public AppointmentStorage getAppointmentStore() {
        return appointmentStore;
    }

    public void setAppointmentStore(AppointmentStorage appointmentStore) {
        this.appointmentStore = appointmentStore;
    }

    public PendingAppointments getPendingAppointmentsStore() {
        return pendingAppointmentsStore;
    }

    public void setPendingAppointmentsStore(PendingAppointments pendingAppointmentsStore) {
        this.pendingAppointmentsStore = pendingAppointmentsStore;
    }

    public PendingPatientAccounts getPendingAccountsStore() {
        return pendingAccountsStore;
    }

    public void setPendingAccountsStore(PendingPatientAccounts pendingAccountsStore) {
        this.pendingAccountsStore = pendingAccountsStore;
    }
    
    
}
