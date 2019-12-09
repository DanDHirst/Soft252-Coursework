/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package authUserControllers;

import authusersview.AuthSecretaryUI;

/**
 *
 * @author dhirst1
 */
public class AuthSecretaryController {
    public AuthSecretaryUI AuthSecretaryView;
    public AuthSecretaryController() {
        AuthSecretaryView = new AuthSecretaryUI();    
        AuthSecretaryView.setVisible(true);
        //this.AuthPatientView.setBtnListner(new AuthPatientController.RedirectListener());
    }
}
