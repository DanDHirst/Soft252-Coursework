/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usermodels;

import appointmentmodel.Appointment;

/**
 *
 * @author dhirst1
 */
public interface Appointments {
   public void addAppointment(Appointment appointment);
   public void removeAppointment(Appointment appointment);
}