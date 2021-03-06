/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package authUserControllers;

import authusersview.AuthDoctorUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelStore.Models;
import usermodels.User;
import userscontroller.DoctorUIController;

/**
 *
 * @author dhirst1
 */
public class AuthDoctorController {

    /**
     *sets up the view 
     */
    public AuthDoctorUI AuthDoctorView;

    /**
     * sets up the modelStore
     */
    public Models modelStore;
    
    /**
     *Constructor for authDoctorController
     * <p> sets up the modelStore and the view</p>
     * <p> sets up the onclicks for the doctorView </p>
     * @param modelStore
     */
    public AuthDoctorController(Models modelStore) {
        this.modelStore = modelStore; 
        AuthDoctorView = new AuthDoctorUI();    
        AuthDoctorView.setVisible(true);
        //this.AuthPatientView.setBtnListner(new AuthPatientController.RedirectListener());
        this.AuthDoctorView.setBtnDoctorLoginListner(new AuthDoctorController.DoctorAuthRedirectListener());
    }
    class DoctorAuthRedirectListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent arg0) {
            String UserID = checkLogin(AuthDoctorView.getUsername(),AuthDoctorView.getPassword());
            if( UserID != null){
                DoctorUIController AuthController= new DoctorUIController(modelStore,UserID);   
                AuthDoctorView.setVisible(false);
            }
            else{
                AuthDoctorView.setTxtResponse("invalid username and/or password");
            }
        }
        public String checkLogin(String Username,String Password){

            for (User p : modelStore.doctorStore.getUsers()){
                if(p.getUsername().equals(Username) && p.getPassword().equals(Password)){
                    return p.getUsername();
                }
            }
            return null;
        }
        
    }
}
