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
   public void addAppointment(Appointment appointment);
   public void removeAppointment(Appointment appointment);
   public Appointment findAppointment(Appointment appointment);
   public ArrayList<Appointment> getAppointments();
   
}