/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userscontroller;

import UsersUI.AdminUI;
import authusersview.AuthAdminUI;

/**
 *
 * @author dhirst1
 */
public class AdminUIController {
    public AdminUI AdminView;
    public AdminUIController() {
        AdminView = new AdminUI();    
        AdminView.setVisible(true);
    }
}
