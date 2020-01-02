/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PrescriptionTest;

import java.time.LocalDateTime;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import prescriptionmodels.Medicine;
import prescriptionmodels.Prescription;
import prescriptionmodels.PrescriptionStorage;

/**
 *
 * @author dan
 */
public class TestPrescriptionModels {
    
    public TestPrescriptionModels() {
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
    public void TestPrescripitionValues(){
        LocalDateTime now = LocalDateTime.now();
        Medicine med = new Medicine("paracemtol", 20 , "2 a day");
        Prescription pre = new Prescription( 0 ,"Steve","John","",now,med);
        assertEquals("testing ID method", now, pre.getDatePrescriped());
        assertEquals("testing doctor ID method","John",pre.getDoctor());
        assertEquals("testing medicine method",med,pre.getMedicine());
        assertEquals("testing notes method","",pre.getNotes());
        assertEquals("testing PatientID method","Steve",pre.getPatient());
        assertEquals("testing prescriptionID method",0,pre.getPrescriptionID());
            
    }
    @Test
    public void TestPrescripitionStorage(){

            
        PrescriptionStorage prescriptionStore = new PrescriptionStorage();
            LocalDateTime now = LocalDateTime.now();
            Medicine med = new Medicine("paracemtol", 20 , "2 a day");
            Prescription pre = new Prescription( 0 ,"Steve","John","",now,med);
            prescriptionStore.addPrescription(pre);
        assertEquals("testing Adding prescription method",0,prescriptionStore.getPrescriptions().get(0).getPrescriptionID());
        //editing a appointment
        prescriptionStore.getPrescriptions().get(0).setPrescriptionID(1);
        assertEquals("Test if editing a prescription in storage works", 1,prescriptionStore.getPrescriptions().get(0).getPrescriptionID());
        //testing removing a user
        prescriptionStore.removePrescriptions(pre);
        assertEquals("Test if remove function works", 0 , prescriptionStore.getPrescriptions().size());
    }
    
}
