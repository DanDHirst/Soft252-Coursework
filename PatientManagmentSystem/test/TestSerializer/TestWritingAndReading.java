/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestSerializer;

import TestSerializer.MockSerializer.ReadFile;
import TestSerializer.MockSerializer.WriteFile;
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
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import patientmodels.Patient;
import patientmodels.PatientStorage;
import patientmodels.PendingPatientAccounts;
import patientmodels.PendingTerminatePatientAccounts;
import prescriptionmodels.Medicine;
import prescriptionmodels.MedicineStore;
import prescriptionmodels.Prescription;
import prescriptionmodels.PrescriptionStorage;
import prescriptionmodels.RequestMedicineStore;
import secretarymodels.Secretary;
import secretarymodels.SecretaryStorage;
import usermodels.User;

/**
 *
 * @author dan
 */
public class TestWritingAndReading {
    private Models modelStore;
    private Models ReadFilestore;
    
    public TestWritingAndReading() {
        Patient patient1 = new Patient(54,"male","Steve", "password", "Steve", "stephens","pl5 423a");
            Patient patient2 = new Patient(21,"female","Ellie", "aPassword", "Ellie", "Matthews","pl4 32a");
            Patient patient3  = new Patient(22,"male","Ryan", "bestPassword", "Ryan", "Harvey","pl6 e12");
            
            PatientStorage patientStore = new PatientStorage();
            
            patientStore.addUser(patient1);
            patientStore.addUser(patient2);
            patientStore.addUser(patient3);
            
            DoctorStorage doctorStore = new DoctorStorage();
            Doctor james = new Doctor("John", "password", "John","smith","pl5 4as");
            Doctor sam = new Doctor("Sam", "topSecret", "Sam","Hunt","pl34 23a");
            Doctor jill = new Doctor("Jill", "Banana1", "Jill","Hunt","pl34 23a");
            doctorStore.addUser(james);
            doctorStore.addUser(sam);
            doctorStore.addUser(jill);
            
            Administrator admin1 = new Administrator("Paul", "password", "Paul", "Santos","pl65 23");
            AdministratorStorage adminStore = new AdministratorStorage();
            adminStore.addUser(admin1);
            
            Secretary sec1 = new Secretary("Terry", "password", "Terry","Wells","pl45 ase");
            SecretaryStorage secretaryStore = new SecretaryStorage();
            secretaryStore.addUser(sec1);
//            
//            
            PrescriptionStorage prescriptionStore = new PrescriptionStorage();
            LocalDateTime now = LocalDateTime.now();
            Medicine med = new Medicine("paracemtol", 20 , "2 a day");
            Prescription pre = new Prescription( 0 ,"Steve","John","",now,med);
//        pre.addMedicine(med);
            prescriptionStore.addPrescription(pre);

            Medicine med1 = new Medicine("paracemtol", 19);
            Medicine med2 = new Medicine("Solcicsola", 100 );
            Medicine med3 = new Medicine("Naxfloxal", 60 );
            Medicine med4 = new Medicine("Nitradexobo", 120 );
            Medicine med5 = new Medicine("Hobix", 19 );
            Medicine med6 = new Medicine("Enthsol", 19 );
            Medicine med7= new Medicine("Ectiridril", 19 );
            Medicine med8 = new Medicine("Anthcinui", 19 );
            Medicine med9 = new Medicine("Ganfloxart", 19 );
            Medicine med10 = new Medicine("Lincilagro", 19 );
            
            
            MedicineStore medicineStore = new MedicineStore();
            medicineStore.addMedicine(med1);
            medicineStore.addMedicine(med2);
            medicineStore.addMedicine(med3);
            medicineStore.addMedicine(med4);
            medicineStore.addMedicine(med5);
            medicineStore.addMedicine(med6);
            medicineStore.addMedicine(med7);
            medicineStore.addMedicine(med8);
            medicineStore.addMedicine(med9);
            medicineStore.addMedicine(med10);
            

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
            Appointment app = new Appointment(0,now,now.plusMinutes(20),"John","Steve");
            Appointment app4 = new Appointment(1,now,now.minusHours(11),"John","Steve");
            app.setCompleted(true);
            appointmentStore.addAppointment(app);
            appointmentStore.addAppointment(app4);

            PendingAppointments pendingAppointmentsStore = new PendingAppointments();
            Appointment app1 = new Appointment(0,now,now.plusMinutes(20),"John","Steve");
            Appointment app2 = new Appointment(1,now,now.plusMinutes(20).plusDays(5),"sam","Steve");
            pendingAppointmentsStore.addAppointment(app1);
            pendingAppointmentsStore.addAppointment(app2);

            PendingPatientAccounts pendingAccountsStore = new PendingPatientAccounts();
            Patient patient4  = new Patient(22,"female","Emilee", "password", "Emilee", "Esparza","25 a place");
            Patient patient5  = new Patient(44,"male","Milo", "password", "Milo", "Goodman","25 a place");
            pendingAccountsStore.addUser(patient4);
            pendingAccountsStore.addUser(patient5);

            PendingTerminatePatientAccounts pendingTerminateAccountsStore = new PendingTerminatePatientAccounts();
            pendingTerminateAccountsStore.addUser(patient1);

            RequestMedicineStore requestMedicineStore = new RequestMedicineStore();
            Medicine med11 = new Medicine("sleep tablets", 20 );
            requestMedicineStore.addMedicine(med11);




             this.modelStore = new Models(patientStore, doctorStore , adminStore
                    ,secretaryStore,medicineStore ,prescriptionStore, doctorFeedbackStore,doctorPendingFeedbackStore,appointmentStore
                    ,pendingAppointmentsStore, pendingAccountsStore,pendingTerminateAccountsStore,requestMedicineStore);
    }
    
    @BeforeClass
    public static void setUpClass() {
        

    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        WriteFile files = new WriteFile();
           files.executeAction(modelStore);
           
           Models temp = null;         
           ReadFile file = new ReadFile();
           Models store = file.executeAction(temp);
           this.ReadFilestore = store;
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void TestPatientAfterFileRead() {
         int patientNumber = 0;
         for (User pat: ReadFilestore.patientStore.getUsers()) {
             assertTrue("test if the patient Username is the same", pat.getUsername().equals(modelStore.patientStore.getUsers().get(patientNumber).getUsername()));
             assertTrue("test if the patient password is the same", pat.getPassword().equals(modelStore.patientStore.getUsers().get(patientNumber).getPassword()));
             assertTrue("test if the patient firstname is the same", pat.getFirstName().equals(modelStore.patientStore.getUsers().get(patientNumber).getFirstName()));
             assertTrue("test if the patient surname is the same", pat.getSurname().equals(modelStore.patientStore.getUsers().get(patientNumber).getSurname()));
             assertTrue("test if the patient address is the same", pat.getAddress().equals(modelStore.patientStore.getUsers().get(patientNumber).getAddress()));
             
             
             
             patientNumber +=1;
         }
         
         
           
     }
}
