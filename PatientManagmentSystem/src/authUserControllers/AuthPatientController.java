/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package authUserControllers;

import Serializer.WriteFile;
import authusersview.AuthPatientUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelStore.Models;
import patientmodels.Patient;
import usermodels.User;
import userscontroller.PatientUIController;


/**
 *
 * @author dhirst1
 */
public class AuthPatientController extends AuthHandler {
    public AuthPatientUI AuthPatientView;
    public Models modelStore;
    public WriteFile file = new WriteFile();

    public AuthPatientController( Models modelStore) {
        RequestAccount acc = new RequestAccount();
        setStrategy(acc);
        this.modelStore = modelStore;
        this.modelStore = modelStore;
        AuthPatientView = new AuthPatientUI();    
        AuthPatientView.setVisible(true);
        //this.AuthPatientView.setBtnListner(new AuthPatientController.RedirectListener());
        this.AuthPatientView.setBtnPatientLoginListner(new AuthPatientController.PatientAuthRedirectListener());
        this.AuthPatientView.setBtnPatientRegister(new AuthPatientController.RegisterPatientListener());
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
            System.out.println(modelStore.patientStore.getUsers());
            for (User p : modelStore.patientStore.getUsers()){
                if(p.getUsername().equals(Username) && p.getPassword().equals(Password)){
                    return p.getUsername();
                }
            }
            return null;
        }
        
    }
    class RegisterPatientListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String username = AuthPatientView.getTxtUsernameReg();
            String password = AuthPatientView.getTxtPasswordReg();
            String firstname = AuthPatientView.getTxtFirstnameReg();
            String surname = AuthPatientView.getTxtSurnameReg();
            String address = AuthPatientView.getTxtAddressReg();
            int age = Integer.parseInt(AuthPatientView.getTxtAgeReg());
            String gender = AuthPatientView.getTxtGenderReg();
            Patient tempPatient = new Patient(age,gender,username,password,firstname
            ,surname,address);
            modelStore = createAccount(modelStore,tempPatient);
            file.executeAction(modelStore);
        }
        
    }
}
