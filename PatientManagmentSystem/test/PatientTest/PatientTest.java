package PatientTest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import patientmodels.Patient;
import patientmodels.PatientStorage;
import patientmodels.PendingTerminatePatientAccounts;

/**
 *
 * @author dan
 */
public class PatientTest {
    
    public PatientTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void TestPatientAttributes(){
        Patient person = new Patient(20,"male","person123", "password", "firstname", "surname","25 a place");
        assertEquals("testing age method", 20, person.getAge());
        assertEquals("testing gender method", "male", person.getSex());
        assertEquals("testing username method", "person123", person.getUsername());
        assertEquals("testing password method","password",person.getPassword());
        assertEquals("testing firstname method","firstname",person.getFirstName());
        assertEquals("testing surname method","surname",person.getSurname());
        assertEquals("testing address method","25 a place",person.getAddress());
    }
    @Test
    public void TestPatientStorage(){
        Patient person = new Patient(20,"male","person123", "password", "firstname", "surname","25 a place");
        PatientStorage patientStore = new PatientStorage();
        patientStore.addUser(person);
        person = (Patient) patientStore.findUser(person);
        assertEquals("testing if can cast and get back the sex","male",person.getSex());
    }
    
    @Test
    public void TestPatientStorageTerminate(){
        Patient person = new Patient(20,"male","person123", "password", "firstname", "surname","25 a place");
        PendingTerminatePatientAccounts pendingTerminatePatientAccounts = new PendingTerminatePatientAccounts();
        pendingTerminatePatientAccounts.addUser(person);
        person = (Patient) pendingTerminatePatientAccounts.findUser(person);
        assertEquals("testing if can cast and get back the sex","male",person.getSex());
    }
    
}
