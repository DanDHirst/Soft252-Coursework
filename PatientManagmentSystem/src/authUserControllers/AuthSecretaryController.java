/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package authUserControllers;

import authusersview.AuthSecretaryUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelStore.Models;
import usermodels.User;
import userscontroller.SecretaryUIController;

/**
 *
 * @author dhirst1
 */
public class AuthSecretaryController {
    public AuthSecretaryUI AuthSecretaryView;
    public Models modelStore;
    
    public AuthSecretaryController(Models modelStore) {
         
        this.modelStore = modelStore;
        AuthSecretaryView = new AuthSecretaryUI();    
        AuthSecretaryView.setVisible(true);
        //this.AuthPatientView.setBtnListner(new AuthPatientController.RedirectListener());
        this.AuthSecretaryView.setBtnSecretaryLoginListner(new AuthSecretaryController.SecretaryAuthRedirectListener());
    }
    class SecretaryAuthRedirectListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent arg0) {
            
            String UserID = checkLogin(AuthSecretaryView.getUsername(),AuthSecretaryView.getPassword());
            if( UserID != null){
                SecretaryUIController AuthController= new SecretaryUIController(modelStore,UserID);   
                AuthSecretaryView.setVisible(false);
            }
            else{
                AuthSecretaryView.setTxtResponse("invalid username and/or password");
            }
        }
        public String checkLogin(String Username,String Password){

            for (User p : modelStore.secretaryStore.getUsers()){
                if(p.getUsername().equals(Username) && p.getPassword().equals(Password)){
                    return p.getUsername();
                }
            }
            return null;
        }
        
    }
}
