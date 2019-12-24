/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doctormodels;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author dan
 */
public class DoctorFeedbackStorage implements IDoctorFeedbackStorage , Serializable{
    private ArrayList<DoctorFeedback> doctorsFeedback = new ArrayList<>();

    public DoctorFeedbackStorage() {
    }
    
    @Override
    public void addDoctorFeedback(DoctorFeedback doctorFeedback) {
        this.doctorsFeedback.add(doctorFeedback);
    }

    
    @Override
    public void removeDoctorFeedback(DoctorFeedback doctorFeedback) {
        doctorsFeedback.remove(doctorFeedback);
    }


    @Override
    public DoctorFeedback findDoctorFeedback(DoctorFeedback doctorFeedback) {
        int index = doctorsFeedback.indexOf(doctorFeedback);
        return doctorsFeedback.get(index);
    }
    @Override
    public ArrayList<DoctorFeedback> getDoctorsFeedback() {
        return doctorsFeedback;
    }
    
    
}
