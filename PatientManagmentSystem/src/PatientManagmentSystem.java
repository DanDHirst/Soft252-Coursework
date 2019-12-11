
import adminmodels.AdministratorStorage;
import appointmentmodels.AppointmentStorage;
import appointmentmodels.PendingAppointments;
import doctormodels.DoctorFeedbackStorage;
import doctormodels.DoctorStorage;
import patientmodels.Patient;
import patientmodels.PatientStorage;
import prescriptionmodels.PrescriptionStorage;
import secretarymodels.SecretaryStorage;
import userchoicecontroller.UserRoleChoiceController;
import userchoiceview.UserRoleChoice;

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
        AdministratorStorage adminStore = new AdministratorStorage();
        SecretaryStorage secretaryStore = new SecretaryStorage();

        PrescriptionStorage prescriptionStore = new PrescriptionStorage();
        DoctorFeedbackStorage doctorFeedbackStore = new DoctorFeedbackStorage();
        AppointmentStorage appointmentStore = new AppointmentStorage();
        PendingAppointments pendingAppointmentsStore = new PendingAppointments();
        
        UserRoleChoiceController theController = new UserRoleChoiceController(patientStore, doctorStore , adminStore
        ,secretaryStore, prescriptionStore, doctorFeedbackStore,appointmentStore
        ,pendingAppointmentsStore);
        
    }
    
}
