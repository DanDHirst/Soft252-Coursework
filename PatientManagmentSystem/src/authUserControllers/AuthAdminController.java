/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package authUserControllers;

import authusersview.AuthAdminUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import userscontroller.AdminUIController;

/**
 *
 * @author dhirst1
 */
public class AuthAdminController {
    public AuthAdminUI AuthAdminView;
    public AuthAdminController() {
        AuthAdminView = new AuthAdminUI();    
        AuthAdminView.setVisible(true);
        this.AuthAdminView.setBtnAdminLoginListner(new AuthAdminController.AdminAuthRedirectListener());
    }
    class AdminAuthRedirectListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent arg0) {
            AdminUIController AuthController= new AdminUIController();   
            AuthAdminView.setVisible(false);
        }
        
    }
}
