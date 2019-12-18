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
public interface IDoctorFeedbackStorage {

    public void addDoctorFeedback(DoctorFeedback doctorFeedback);
    public void removeDoctorFeedback(DoctorFeedback doctorFeedback);
    public DoctorFeedback findDoctorFeedback(DoctorFeedback doctorFeedback) ;
    public ArrayList<DoctorFeedback> getDoctorsFeedback() ;
    
}
