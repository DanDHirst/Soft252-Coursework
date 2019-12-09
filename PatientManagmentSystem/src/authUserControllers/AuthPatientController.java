/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package authUserControllers;

import authusersview.AuthPatientUI;


/**
 *
 * @author dhirst1
 */
public class AuthPatientController {
    public AuthPatientUI AuthPatientView;
    public AuthPatientController() {
        AuthPatientView = new AuthPatientUI();    
        AuthPatientView.setVisible(true);
        //this.AuthPatientView.setBtnListner(new AuthPatientController.RedirectListener());
    }
}
