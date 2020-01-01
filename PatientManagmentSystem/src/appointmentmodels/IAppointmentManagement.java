/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointmentmodels;

import java.util.ArrayList;



/**
 *
 * @author dhirst1
 */
public interface IAppointmentManagement {

    /**
     * 
     * @param appointment
     */
    public void addAppointment(Appointment appointment);

    /**
     *
     * @param appointment
     */
    public void removeAppointment(Appointment appointment);

    /**
     *
     * @param appointment
     * @return
     */
    public Appointment findAppointment(Appointment appointment);

    /**
     *
     * @return
     */
    public ArrayList<Appointment> getAppointments();
   
}