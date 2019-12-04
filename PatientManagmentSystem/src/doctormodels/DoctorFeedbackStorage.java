/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doctormodels;

import java.util.ArrayList;

/**
 *
 * @author dan
 */
public class DoctorFeedbackStorage {
    private ArrayList<DoctorFeedback> doctorsFeedback = new ArrayList<>();

    public DoctorFeedbackStorage() {
    }
    
    public void addDoctorFeedback(DoctorFeedback doctorFeedback) {
        this.doctorsFeedback.add(doctorFeedback);
    }

    
    public void removeDoctorFeedback(DoctorFeedback doctorFeedback) {
        doctorsFeedback.remove(doctorFeedback);
    }


    public DoctorFeedback findDoctorFeedback(DoctorFeedback doctorFeedback) {
        int index = doctorsFeedback.indexOf(doctorFeedback);
        return doctorsFeedback.get(index);
    }
    public ArrayList<DoctorFeedback> getDoctorsFeedback() {
        return doctorsFeedback;
    }
    
    
}
