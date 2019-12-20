/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userscontroller;

import UsersUI.AdminUI;
import adminmodels.Administrator;
import doctormodels.Doctor;
import doctormodels.DoctorFeedback;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import modelStore.Models;
import secretarymodels.Secretary;
import usermodels.User;

/**
 *
 * @author dhirst1
 */
public class AdminUIController {

    public AdminUI AdminView;
    public Models modelStore;

    public AdminUIController(Models modelStore, String UserID) {
        this.modelStore = modelStore;
        AdminView = new AdminUI();
        AdminView.setVisible(true);
        AdminView.setTxtAdminID(UserID);
        this.AdminView.btnAddUser(new AdminUIController.AddUser());
        this.AdminView.btnRemoveUser(new AdminUIController.RemoveUser());
        this.AdminView.listDoctorClick(new AdminUIController.ShowDoctorUser());
        this.AdminView.listSecretaryClick(new AdminUIController.ShowSecretaryUser());
        this.AdminView.listDoctorRatingClick(new AdminUIController.ShowFeedbackAndRatings());
        setDoctorsList();
        setSecretaryList();
    }

    public void setDoctorsList() {
        int amntOfDocs = modelStore.doctorStore.getUsers().size();

        String[] doctors = new String[amntOfDocs];
        for (int i = 0; i < amntOfDocs; i++) {
            doctors[i] = modelStore.doctorStore.getUsers().get(i).getUsername();
        }
        AdminView.setListDoctors(doctors);
    }

    public void setSecretaryList() {
        int amntOfSecretaries = modelStore.secretaryStore.getUsers().size();

        String[] secretaries = new String[amntOfSecretaries];
        for (int i = 0; i < amntOfSecretaries; i++) {
            secretaries[i] = modelStore.secretaryStore.getUsers().get(i).getUsername();
        }
        AdminView.setListSecretary(secretaries);
    }

    class AddUser implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String user = AdminView.getTxtUser();
            String username = AdminView.getTxtUsername();
            String password = AdminView.getTxtPassword();
            String firstname = AdminView.getTxtFirstname();
            String surname = AdminView.getTxtSurname();
            String address = AdminView.getTxtAddress();
            
            if (user.equals("Secretary")) {
                Secretary sec = new Secretary(username,password,firstname,surname,address);
                modelStore.secretaryStore.addUser(sec);
                
            }
            else if(user.equals("Doctor")){
                Doctor ad = new Doctor(username,password,firstname,surname,address);
                modelStore.doctorStore.addUser(ad);
            }
            setDoctorsList();
            setSecretaryList();
            AdminView.deselectSecretary();
            AdminView.deselectDoctor();
        }

    }

    class RemoveUser implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String user = AdminView.getTxtUser();
            String username = AdminView.getTxtUsername();
            if (user.equals("Secretary")) {
                for(User sec : modelStore.secretaryStore.getUsers()){
                    if(sec.getUsername().equals(username)){
                        modelStore.secretaryStore.removeUser(sec);
                        break;
                    }
                }  
            }
            
            else if(user.equals("Doctor")){
                for(User dr : modelStore.doctorStore.getUsers()){
                    if(dr.getUsername().equals(username)){
                        modelStore.doctorStore.removeUser(dr);
                        break;
                    }
                }
            }
            setDoctorsList();
            setSecretaryList();
            AdminView.deselectSecretary();
            AdminView.deselectDoctor();
        }

    }

    class ShowDoctorUser implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            String doctor = AdminView.getListDoctor();
            for (User dr : modelStore.doctorStore.getUsers()) {
                if (dr.getUsername().equals(doctor)) {
                    AdminView.setTxtUser("Doctor");
                    AdminView.setTxtUsername(doctor);
                    AdminView.setTxtPassword(dr.getPassword());
                    AdminView.setTxtFirstname(dr.getFirstName());
                    AdminView.setTxtSurname(dr.getSurname());
                    AdminView.setTxtAddress(dr.getAddress());
                    AdminView.deselectSecretary();
                }
            }
            AdminView.selectDoctorRad();
        }

    }

    class ShowSecretaryUser implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            String secretary = AdminView.getListSecretary();
            for (User sec : modelStore.secretaryStore.getUsers()) {
                if (sec.getUsername().equals(secretary)) {
                    AdminView.setTxtUser("Secretary");
                    AdminView.setTxtUsername(secretary);
                    AdminView.setTxtPassword(sec.getPassword());
                    AdminView.setTxtFirstname(sec.getFirstName());
                    AdminView.setTxtSurname(sec.getSurname());
                    AdminView.setTxtAddress(sec.getAddress());
                    AdminView.deselectDoctor();
                }
            }
            AdminView.selectSecretaryRad();
        }

    }
    class ShowFeedbackAndRatings implements ListSelectionListener{

        @Override
        public void valueChanged(ListSelectionEvent e) {
            //showing ratings
            String doctor = AdminView.getListRatingDoctor();
            float averageRating = 0;
            AdminView.setTxtInfo("Doctor: " + doctor);
            for(DoctorFeedback feedback : modelStore.doctorFeedbackStore.getDoctorsFeedback()){
                if (feedback.getDoctorID().equals(doctor)) {
                    AdminView.addTxtInfo("\nRating: " + feedback.getRating() + "\nComments: " + feedback.getFeedbackNotes());
                    averageRating += feedback.getRating();
                }
                
            }
            averageRating = averageRating / modelStore.doctorFeedbackStore.getDoctorsFeedback().size();
            AdminView.addTxtInfo("\nAverage Rating: " + averageRating);
            
            //showing feedback
            AdminView.setTxtFeedback("Doctor: " + doctor);
            for(DoctorFeedback feedback : modelStore.doctorPendingFeedbackStore.getDoctorsFeedback()){
                if (feedback.getDoctorID().equals(doctor)) {
                    AdminView.addTxtFeedback("\nRating: " + feedback.getRating() + "\nComments: " + feedback.getFeedbackNotes());
                   
                }
                
            }
            
        }
        
    }
}
