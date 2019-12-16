/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package authUserControllers;

import authusersview.AuthAdminUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelStore.Models;
import usermodels.User;
import userscontroller.AdminUIController;

/**
 *
 * @author dhirst1
 */
public class AuthAdminController {
    public AuthAdminUI AuthAdminView;
    public Models modelStore;
    
    public AuthAdminController(Models modelStore) {
        this.modelStore = modelStore;
        AuthAdminView = new AuthAdminUI();    
        AuthAdminView.setVisible(true);
        this.AuthAdminView.setBtnAdminLoginListner(new AuthAdminController.AdminAuthRedirectListener());
    }
    class AdminAuthRedirectListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent arg0) {
            String UserID = checkLogin(AuthAdminView.getUsername(),AuthAdminView.getPassword());
            if( UserID != null){
                AdminUIController AuthController= new AdminUIController();   
                AuthAdminView.setVisible(false);
            }
            else{
                AuthAdminView.setTxtResponse("invalid username and/or password");
            }
            
        }
        public String checkLogin(String Username,String Password){

            for (User p : modelStore.adminStore.getUsers()){
                if(p.getUsername().equals(Username) && p.getPassword().equals(Password)){
                    return p.getUsername();
                }
            }
            return null;
        }
        
    }
}
