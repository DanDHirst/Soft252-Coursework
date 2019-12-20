
import adminmodels.Administrator;
import adminmodels.AdministratorStorage;
import appointmentmodels.Appointment;
import appointmentmodels.AppointmentStorage;
import appointmentmodels.PendingAppointments;
import doctormodels.Doctor;
import doctormodels.DoctorFeedback;
import doctormodels.DoctorFeedbackStorage;
import doctormodels.DoctorPendingFeedbackStorage;
import doctormodels.DoctorStorage;
import java.time.LocalDateTime;
import modelStore.Models;
import patientmodels.Patient;
import patientmodels.PatientStorage;
import patientmodels.PendingPatientAccounts;
import patientmodels.PendingTerminatePatientAccounts;
import prescriptionmodels.Medicine;
import prescriptionmodels.Prescription;
import prescriptionmodels.PrescriptionStorage;
import secretarymodels.Secretary;
import secretarymodels.SecretaryStorage;
import userchoicecontroller.UserRoleChoiceController;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author dhirst1
 */
public class PatientManagmentSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Patient patient1 = new Patient(20,"male","person123", "password", "firstname", "surname","25 a place");
        Patient patient2 = new Patient(21,"male","person123", "password", "firstname", "surname","25 a place");
        Patient patient3  = new Patient(22,"male","person123", "password", "firstname", "surname","25 a place");
        
        PatientStorage patientStore = new PatientStorage();
        
        patientStore.addUser(patient1);
        patientStore.addUser(patient2);
        patientStore.addUser(patient3);

        DoctorStorage doctorStore = new DoctorStorage();
        Doctor james = new Doctor("John", "password", "John","steve","a location");
        Doctor sam = new Doctor("sam", "password", "John","steve","a location");
        doctorStore.addUser(james);
        doctorStore.addUser(sam);
        Administrator admin1 = new Administrator("person123", "password", "firstname", "surname","25 a place");
        AdministratorStorage adminStore = new AdministratorStorage();
        adminStore.addUser(admin1);
        
        Secretary sec1 = new Secretary("james", "password", "james","steve","a location");
        Secretary sec2 = new Secretary("sam", "password", "sam","steve","a location");
        SecretaryStorage secretaryStore = new SecretaryStorage();
        secretaryStore.addUser(sec1);
        secretaryStore.addUser(sec2);
                

        PrescriptionStorage prescriptionStore = new PrescriptionStorage();
        LocalDateTime now = LocalDateTime.now();
        Medicine med = new Medicine("paracemtol", 20 , "2 a day");
        Prescription pre = new Prescription("person123","John","",now);
        pre.addMedicine(med);
        prescriptionStore.addPrescription(pre);
        
        DoctorFeedbackStorage doctorFeedbackStore = new DoctorFeedbackStorage();
        DoctorFeedback feedback1 = new DoctorFeedback("John",4,"good doctor but is very busy",1);
        doctorFeedbackStore.addDoctorFeedback(feedback1);
        DoctorFeedback feedback2 = new DoctorFeedback("John",3,"good doctor but is very busy",2);
        doctorFeedbackStore.addDoctorFeedback(feedback2);
        
        DoctorPendingFeedbackStorage doctorPendingFeedbackStore = new DoctorPendingFeedbackStorage();
        DoctorFeedback feedback3 = new DoctorFeedback("John",1,"bad doctor and is very busy",1);
        DoctorFeedback feedback4 = new DoctorFeedback("John",5,"good doctor but is very busys",2);
        doctorPendingFeedbackStore.addDoctorFeedback(feedback3);
        doctorPendingFeedbackStore.addDoctorFeedback(feedback4);
        
        
        AppointmentStorage appointmentStore = new AppointmentStorage();
        Appointment app = new Appointment(now,"John","person123");
        appointmentStore.addAppointment(app);
        
        PendingAppointments pendingAppointmentsStore = new PendingAppointments();
        PendingPatientAccounts pendingAccountsStore = new PendingPatientAccounts();
        PendingTerminatePatientAccounts pendingTerminateAccountsStore = new PendingTerminatePatientAccounts();
        
        Models modelStore = new Models(patientStore, doctorStore , adminStore 
                ,secretaryStore, prescriptionStore, doctorFeedbackStore,doctorPendingFeedbackStore,appointmentStore 
                ,pendingAppointmentsStore, pendingTerminateAccountsStore, pendingAccountsStore);
        
        UserRoleChoiceController theController = new UserRoleChoiceController(modelStore);
        
    }
    
}
