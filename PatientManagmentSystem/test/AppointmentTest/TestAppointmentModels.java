/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppointmentTest;

import appointmentmodels.Appointment;
import appointmentmodels.AppointmentStorage;
import appointmentmodels.PendingAppointments;
import java.time.LocalDateTime;
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
public class TestAppointmentModels {
    
    public TestAppointmentModels() {
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
    public void TestAppointmentsValues(){
        LocalDateTime now = LocalDateTime.now();
        Appointment app = new Appointment(0,now,now.plusMinutes(20),"John","Steve");
        assertEquals("testing ID method", 0, app.getAppointmentID());
        assertEquals("testing doctor ID method","John",app.getDoctorID());
        assertEquals("testing EndTime method",now.plusMinutes(20),app.getEndTime());
        assertEquals("testing Startime method",now,app.getStartTime());
        assertEquals("testing PatientID method","Steve",app.getPatientID());
    }
    @Test
    public void TestAppointmentsStorage(){
        LocalDateTime now = LocalDateTime.now();
        AppointmentStorage appointmentStore = new AppointmentStorage();
        Appointment app = new Appointment(0,now,now.plusMinutes(20),"John","Steve");
        appointmentStore.addAppointment(app);
        assertEquals("testing Adding appointment method",0,appointmentStore.getAppointments().get(0).getAppointmentID());
        //editing a appointment
        appointmentStore.getAppointments().get(0).setAppointmentID(1);
        assertEquals("Test if editing a appointment in storage works", 1, appointmentStore.getAppointments().get(0).getAppointmentID());
        //testing removing a user
        appointmentStore.removeAppointment(app);
        assertEquals("Test if remove function works", 0 , appointmentStore.getAppointments().size());
        
    }
    @Test
    public void TestPendingAppointmentsStorage(){
        LocalDateTime now = LocalDateTime.now();
        PendingAppointments appointmentStore = new PendingAppointments();
        Appointment app = new Appointment(0,now,now.plusMinutes(20),"John","Steve");
        appointmentStore.addAppointment(app);
        assertEquals("testing Adding appointment method",0,appointmentStore.getAppointments().get(0).getAppointmentID());
        //editing a appointment
        appointmentStore.getAppointments().get(0).setAppointmentID(1);
        assertEquals("Test if editing a appointment in storage works", 1, appointmentStore.getAppointments().get(0).getAppointmentID());
        //testing removing a user
        appointmentStore.removeAppointment(app);
        assertEquals("Test if remove function works", 0 , appointmentStore.getAppointments().size());
        
    }
}
