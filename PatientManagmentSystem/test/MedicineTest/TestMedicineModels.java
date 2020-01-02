/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MedicineTest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import prescriptionmodels.Medicine;
import prescriptionmodels.MedicineStore;
import prescriptionmodels.RequestMedicineStore;

/**
 *
 * @author dan
 */
public class TestMedicineModels {
    
    public TestMedicineModels() {
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
    public void TestMedicineValues(){
            Medicine med = new Medicine("Lincilagro", 19 );
            assertEquals("testing Med name  method", "Lincilagro", med.getName());
            assertEquals("testing med quantity method",19,med.getQuantity());
            
            
            MedicineStore medicineStore = new MedicineStore();
            medicineStore.addMedicine(med);
    }
    @Test
    public void TestMedicineStorage(){
            Medicine med = new Medicine("Lincilagro", 19 );         
            
            MedicineStore medicineStore = new MedicineStore();
            medicineStore.addMedicine(med);
            assertEquals("testing Med name  method", "Lincilagro", medicineStore.getMedicine().get(0).getName());
            assertEquals("testing med quantity method",19,medicineStore.getMedicine().get(0).getQuantity());
            //test editing medicine
            medicineStore.getMedicine().get(0).setName("paracetmol");
            assertEquals("testing editing method", "paracetmol", medicineStore.getMedicine().get(0).getName());
            //testing removing a medicine
            medicineStore.removeMedicine(med);
            assertEquals("Test if remove function works", 0 , medicineStore.getMedicine().size());    
    }
    @Test
    public void TestRequestMedicineStorage(){
            Medicine med = new Medicine("Lincilagro", 19 );         
            
            RequestMedicineStore medicineStore = new RequestMedicineStore();
            medicineStore.addMedicine(med);
            assertEquals("testing Med name  method", "Lincilagro", medicineStore.getMedicine().get(0).getName());
            assertEquals("testing med quantity method",19,medicineStore.getMedicine().get(0).getQuantity());
            //test editing medicine
            medicineStore.getMedicine().get(0).setName("paracetmol");
            assertEquals("testing editing method", "paracetmol", medicineStore.getMedicine().get(0).getName());
            //testing removing a medicine
            medicineStore.removeMedicine(med);
            assertEquals("Test if remove function works", 0 , medicineStore.getMedicine().size());    
    }
}
