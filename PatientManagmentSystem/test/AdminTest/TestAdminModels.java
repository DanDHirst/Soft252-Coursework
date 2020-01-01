/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminTest;

import adminmodels.Administrator;
import adminmodels.AdministratorStorage;
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
public class TestAdminModels {
    
    public TestAdminModels() {
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
    public void TestAdminAttributes(){
        Administrator person = new Administrator("person123", "password", "firstname", "surname","25 a place");
        assertEquals("testing username method", "person123", person.getUsername());
        assertEquals("testing password method","password",person.getPassword());
        assertEquals("testing firstname method","firstname",person.getFirstName());
        assertEquals("testing surname method","surname",person.getSurname());
        assertEquals("testing address method","25 a place",person.getAddress());
    }
    @Test
    public void TestAdminStorage(){
        //testing adding a person
        Administrator person = new Administrator("person123", "password", "firstname", "surname","25 a place");
        AdministratorStorage adminStore = new AdministratorStorage();
        adminStore.addUser(person);
        assertEquals("Test if admin in storage", "person123", adminStore.getUsers().get(0).getUsername());
        //test editing a user
        adminStore.getUsers().get(0).setUsername("james");
        assertEquals("Test if editing a admin in storage works", "james", adminStore.getUsers().get(0).getUsername());
        //testing removing a user
        adminStore.removeUser(person);
        assertEquals("Test if remove function works", 0 , adminStore.getUsers().size());
        
        
    }
    
}
