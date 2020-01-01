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
public class AppointmentStorage implements IAppointmentManagement , Serializable {
    ArrayList<Appointment> appointments= new ArrayList<>();

    /**
     *constructor to setup the appointment storage
     */
    public AppointmentStorage() {
    }

    /**
     *adds appointment
     * <p> adds appointment by passing in an appointment object</p>
     * @param appointment
     */
    @Override
    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    /**
     *removes appointment
     * <p> removes appointment by passing in a appointment object </p>
     * @param appointment
     */
    @Override
    public void removeAppointment(Appointment appointment) {
        appointments.remove(appointment);
    }

    /**
     * finds appointment
     * <p> finds appointment by passing in an appointment object </p>
     * @param appointment
     * @return an appointment index
     */
    @Override
    public Appointment findAppointment(Appointment appointment) {
        int index = appointments.indexOf(appointment);
        return appointments.get(index);
    }

    /**
     *return appointments
     * @return array list of appointment objects
     */
    @Override
    public ArrayList<Appointment> getAppointments() {
        return this.appointments;
    }
}
