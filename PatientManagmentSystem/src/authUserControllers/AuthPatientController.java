/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package authUserControllers;

import authusersview.AuthPatientUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelStore.Models;
import usermodels.User;
import userscontroller.PatientUIController;


/**
 *
 * @author dhirst1
 */
public class AuthPatientController {
    public AuthPatientUI AuthPatientView;
    public Models modelStore;
    
    public AuthPatientController(Models modelStore) {
        
        this.modelStore = modelStore;
        AuthPatientView = new AuthPatientUI();    
        AuthPatientView.setVisible(true);
        //this.AuthPatientView.setBtnListner(new AuthPatientController.RedirectListener());
        this.AuthPatientView.setBtnPatientLoginListner(new AuthPatientController.PatientAuthRedirectListener());
    }
    class PatientAuthRedirectListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent arg0) {
            String UserID = checkLogin(AuthPatientView.getUsername(),AuthPatientView.getPassword());
            if( UserID != null){
                PatientUIController AuthController= new PatientUIController(modelStore, UserID);   
                AuthPatientView.setVisible(false);
            }
            else{
                AuthPatientView.setTxtResponse("invalid username and/or password");
            }
        }
        public String checkLogin(String Username,String Password){

            for (User p : modelStore.patientStore.getUsers()){
                if(p.getUsername().equals(Username) && p.getPassword().equals(Password)){
                    return p.getUsername();
                }
            }
            return null;
        }
        
    }
}
