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

    public AppointmentStorage() {
    }

    @Override
    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    @Override
    public void removeAppointment(Appointment appointment) {
        appointments.remove(appointment);
    }

    @Override
    public Appointment findAppointment(Appointment appointment) {
        int index = appointments.indexOf(appointment);
        return appointments.get(index);
    }

    @Override
    public ArrayList<Appointment> getAppointments() {
        return this.appointments;
    }
}
