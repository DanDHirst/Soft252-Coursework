/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userchoicecontroller;

import authUserControllers.AuthPatientController;
import authusersview.AuthAdminUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import userchoiceview.UserRoleChoice;

/**
 *
 * @author dhirst1
 */
public class UserRoleChoiceController {
    public UserRoleChoice theView;
    public UserRoleChoiceController() {
        theView = new UserRoleChoice();    
        theView.setVisible(true);
        this.theView.setBtnListner(new RedirectListener());
    }

    class RedirectListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent arg0) {
            AuthPatientController AuthController= new AuthPatientController();   
            theView.setVisible(false);
        }
        
    }
    
    
}
