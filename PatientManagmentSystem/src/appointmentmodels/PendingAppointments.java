/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointmentmodels;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author dan
 */
public class PendingAppointments implements IAppointmentManagement , Serializable{
    ArrayList<Appointment> appointments= new ArrayList<>();

    /**
     * Sets up the pending appointment class so can read from the file
     */
    public PendingAppointments() {
    }

    /**
     * Method to add an appointment to the object
     * <p>Adds an appointment to the arraylist passing in an appointment object</p>
     * @param appointment
     */
    @Override
    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    /**
     *Method to remove an appointment
     * <p>Removes an appointment by passing in an appointment object</p>
     * @param appointment
     */
    @Override
    public void removeAppointment(Appointment appointment) {
        appointments.remove(appointment);
    }

    /**
     *finds an appointment
     * <p>finds an appointment by passing in an appointment object</p>
     * @param appointment
     * @return
     */
    @Override
    public Appointment findAppointment(Appointment appointment) {
        int index = appointments.indexOf(appointment);
        return appointments.get(index);
    }

    /**
     *returns the appointment list
     * <p> returns the array list of the appointment objects </p>
     * @return arraylist of appointment objects
     */
    @Override
    public ArrayList<Appointment> getAppointments() {
        return this.appointments;
    }
    
}
