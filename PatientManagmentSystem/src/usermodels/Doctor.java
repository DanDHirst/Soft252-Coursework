/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usermodels;

import appointmentmodel.Appointment;
import java.util.ArrayList;

/**
 *
 * @author dhirst1
 */
public class Doctor extends User implements Appointments{
    private ArrayList<Appointment> appointments = new ArrayList<>();
    public Doctor(String username, String password, String firstName, String surname, String address) {
        super(username, password, firstName, surname, address);
    }
    
 

    @Override
    public void addAppointment(Appointment appointment) {
        this.appointments.add(appointment);
    }

    @Override
    public void removeAppointment(Appointment appointment) {
        this.appointments.remove(appointment);
    }
    
}
