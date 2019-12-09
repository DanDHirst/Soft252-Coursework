/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package authUserControllers;

import authusersview.AuthDoctorUI;

/**
 *
 * @author dhirst1
 */
public class AuthDoctorController {
    public AuthDoctorUI AuthDoctorView;
    public AuthDoctorController() {
        AuthDoctorView = new AuthDoctorUI();    
        AuthDoctorView.setVisible(true);
        //this.AuthPatientView.setBtnListner(new AuthPatientController.RedirectListener());
    }
}
