/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoctorTest;

import doctormodels.Doctor;
import doctormodels.DoctorStorage;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dan
 */
public class TestDoctorModels {
    
    public TestDoctorModels() {
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

    @Test
    public void TestDoctorAttributes(){
        Doctor person = new Doctor("person123", "password", "firstname", "surname","25 a place");
        assertEquals("testing username method", "person123", person.getUsername());
        assertEquals("testing password method","password",person.getPassword());
        assertEquals("testing firstname method","firstname",person.getFirstName());
        assertEquals("testing surname method","surname",person.getSurname());
        assertEquals("testing address method","25 a place",person.getAddress());
    }
    @Test
    public void TestDoctorStorage(){
        //testing adding a person
        Doctor person = new Doctor("person123", "password", "firstname", "surname","25 a place");
        DoctorStorage doctorStore = new DoctorStorage();
        doctorStore.addUser(person);
        assertEquals("Test if admin in storage", "person123", doctorStore.getUsers().get(0).getUsername());
        //test editing a user
        doctorStore.getUsers().get(0).setUsername("james");
        assertEquals("Test if editing a admin in storage works", "james", doctorStore.getUsers().get(0).getUsername());
        //testing removing a user
        doctorStore.removeUser(person);
        assertEquals("Test if remove function works", 0 , doctorStore.getUsers().size());
        
        
    }
}
