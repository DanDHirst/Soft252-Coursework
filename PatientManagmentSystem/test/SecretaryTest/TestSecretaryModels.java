/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SecretaryTest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import secretarymodels.Secretary;
import secretarymodels.SecretaryStorage;

/**
 *
 * @author dan
 */
public class TestSecretaryModels {
    
    public TestSecretaryModels() {
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
    public void TestSecretaryAttributes(){
        Secretary person = new Secretary("person123", "password", "firstname", "surname","25 a place");
        assertEquals("testing username method", "person123", person.getUsername());
        assertEquals("testing password method","password",person.getPassword());
        assertEquals("testing firstname method","firstname",person.getFirstName());
        assertEquals("testing surname method","surname",person.getSurname());
        assertEquals("testing address method","25 a place",person.getAddress());
    }
    @Test
    public void TestSecretaryStorage(){
        //testing adding a person
        Secretary person = new Secretary("person123", "password", "firstname", "surname","25 a place");
        SecretaryStorage secretaryStore = new SecretaryStorage();
        secretaryStore.addUser(person);
        assertEquals("Test if admin in storage", "person123", secretaryStore.getUsers().get(0).getUsername());
        //test editing a user
        secretaryStore.getUsers().get(0).setUsername("james");
        assertEquals("Test if editing a admin in storage works", "james", secretaryStore.getUsers().get(0).getUsername());
        //testing removing a user
        secretaryStore.removeUser(person);
        assertEquals("Test if remove function works", 0 , secretaryStore.getUsers().size());
        
        
    }
}
