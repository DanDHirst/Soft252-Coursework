/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package authUserControllers;

import Serializer.WriteFile;
import adminmodels.Administrator;
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
public class AuthAdminController extends AuthHandler {

    /**
     *sets up the view 
     */
    public AuthAdminUI AuthAdminView;

    /**
     * sets up the modelStore
     */
    public Models modelStore;

    /**
     * initialises the writeFile object
     */
    public WriteFile file = new WriteFile();
    
    /**
     *Constructor for AuthAdminController
     * <p> sets up the strategy to create an account </p>
     * <p> sets up modelStore and the AuthAdminView</p>
     * <p> sets up the onclicks listeners </p>
     * @param modelStore
     */
    public AuthAdminController(Models modelStore) {
        CreateAccount acc = new CreateAccount();
        setStrategy(acc);
        this.modelStore = modelStore;
        AuthAdminView = new AuthAdminUI();    
        AuthAdminView.setVisible(true);
        this.AuthAdminView.setBtnAdminLoginListner(new AuthAdminController.AdminAuthRedirectListener());
        this.AuthAdminView.setBtnAdminCreateAccountListener(new AuthAdminController.AdminCreateAccount());
    }
    class AdminAuthRedirectListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent arg0) {
            String UserID = checkLogin(AuthAdminView.getUsername(),AuthAdminView.getPassword());
            if( UserID != null){
                AdminUIController AuthController= new AdminUIController(modelStore, UserID);   
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
    class AdminCreateAccount implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String username = AuthAdminView.getTxtUsernameReg();
            String password = AuthAdminView.getTxtPasswordReg();
            String firstname = AuthAdminView.getTxtFirstnameReg();
            String surname = AuthAdminView.getTxtSurnameReg();
            String address = AuthAdminView.getTxtAddressReg();
            
            Administrator admin = new Administrator(username,password,firstname,surname,address);
            modelStore.adminStore.addUser(admin);
            AuthAdminView.setTxtResponseReg("Account create Sucessfully");
            file.executeAction(modelStore);
            AuthAdminView.setTxtPasswordReg("Created Admin Account");
        }
        
    }
}
