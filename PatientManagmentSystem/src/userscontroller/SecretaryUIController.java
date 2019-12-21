/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userscontroller;

import UsersUI.AdminUI;
import UsersUI.SecretaryUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import modelStore.Models;
import patientmodels.Patient;
import usermodels.User;

/**
 *
 * @author dhirst1
 */
public class SecretaryUIController {
    public SecretaryUI SecretaryView;
    public Models modelStore;

    public SecretaryUIController(Models modelStore, String UserID) {
        this.modelStore = modelStore;
        this.SecretaryView = new SecretaryUI();
        SecretaryView.setVisible(true);
        SecretaryView.setTxtSecretaryID(UserID);
        setUpOnClicks();
        setUpUsers();
        
        
    }
    private void setUpOnClicks(){
        SecretaryView.listApprovePatientListener(new SecretaryUIController.ShowPendingPatient());
        this.SecretaryView.btnApprovePatient(new SecretaryUIController.ApprovePatient());
        this.SecretaryView.btnRemovePatient(new SecretaryUIController.RemovePatient());
        this.SecretaryView.listPatientListener(new SecretaryUIController.showUsernamePatient());
        this.SecretaryView.listTermiatePatientListener(new SecretaryUIController.showUsernameTerminatePatient());
    }

    private void setUpUsers() {
        //set up pending Patients
        setUpPendingPatientList();
        setUpPatients();
        setUpPatientsTerminate();
    }
    private void setUpPendingPatientList(){
        int pendingPLength = modelStore.pendingAccountsStore.getUsers().size();
        String[] pendingPList = new String[pendingPLength];
        for (int i = 0; i < pendingPLength; i++) {
            pendingPList[i] = modelStore.pendingAccountsStore.getUsers().get(i).getUsername();
           
        }
        SecretaryView.setListApprovePatient(pendingPList);
         
    }
    private void setUpPatients(){
        int pLength = modelStore.patientStore.getUsers().size();
        String[] pList = new String[pLength];
        for (int i = 0; i < pLength; i++) {
            pList[i] = modelStore.patientStore.getUsers().get(i).getUsername();
           
        }
        SecretaryView.setListPatients(pList);
    }
    private void setUpPatientsTerminate(){
        int pLength = modelStore.pendingTerminateStore.getUsers().size();
        String[] tPList = new String[pLength];
        for (int i = 0; i < pLength; i++) {
            tPList[i] = modelStore.pendingTerminateStore.getUsers().get(i).getUsername();
           
        }
        SecretaryView.setListPatientTerminate(tPList);
    }
    private void clearPendingPatientFields(){
        SecretaryView.setTxtApproveUsername("");
        SecretaryView.setTxtApproveFirstname("");
        SecretaryView.setTxtApproveSurname("");
        SecretaryView.setTxtApprovePassword("");
        SecretaryView.setTxtApproveAddress("");
        SecretaryView.setTxtApproveGender("");
        SecretaryView.setTxtApproveAge("");
    }
    
    class ShowPendingPatient implements ListSelectionListener{

        @Override
        public void valueChanged(ListSelectionEvent e) {
            String patientID = SecretaryView.getListApprovePatient();
            for(User pat : modelStore.pendingAccountsStore.getUsers()){
                if (pat.getUsername().equals(patientID)) {
                    SecretaryView.setTxtApproveUsername(pat.getUsername());
                    SecretaryView.setTxtApprovePassword(pat.getPassword());
                    SecretaryView.setTxtApproveFirstname(pat.getFirstName());
                    SecretaryView.setTxtApproveSurname(pat.getSurname());
                    SecretaryView.setTxtApproveAddress(pat.getAddress());
                    Patient tempP = (Patient)pat;
                    SecretaryView.setTxtApproveGender(tempP.getSex());
                    SecretaryView.setTxtApproveAge(Integer.toString(tempP.getAge()));
                    
                    
                }
            }
            
        }
        
    }
    class ApprovePatient implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String patientID = SecretaryView.getTxtApproveUsername();
            String password = SecretaryView.getTxtApprovePassword();
            String firstname = SecretaryView.getTxtApproveFirstname();
            String surname = SecretaryView.getTxtApproveSurname();
            String address = SecretaryView.getTxtApproveSurname();
            String gender = SecretaryView.getTxtApproveGender();
            int age = Integer.parseInt(SecretaryView.getTxtApproveAge());
            
            Patient tempP = new Patient(age,gender, patientID,password, firstname, surname,address);
            modelStore.patientStore.addUser(tempP);
            
            //remove patient from pending
            for(User pat : modelStore.pendingAccountsStore.getUsers()){
                if (pat.getUsername().equals(patientID)) {
                    modelStore.pendingAccountsStore.removeUser(pat);
                    break;
                }
            }
            setUpPendingPatientList();
            clearPendingPatientFields();
            setUpUsers();
            
            
            
        }
        
    }
    class RemovePatient implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String patientID = SecretaryView.getTxtRemoveUsername();
            for (User pat : modelStore.patientStore.getUsers()) {
                if (pat.getUsername().equals(patientID)) {
                    modelStore.patientStore.removeUser(pat);
                    modelStore.pendingTerminateStore.removeUser(pat);
                }
            }
            setUpUsers();
            SecretaryView.setTxtRemoveUsername("");
            
            
        }
        
    }
    class showUsernamePatient implements ListSelectionListener{

        @Override
        public void valueChanged(ListSelectionEvent e) {
            
            String patientID = SecretaryView.getListPatients();
            
            for (User pat : modelStore.patientStore.getUsers()) {
                if (pat.getUsername().equals(patientID)) {
                    
                    SecretaryView.setTxtRemoveUsername(patientID);
                    SecretaryView.deselectPatientTerminateList();
                }
            }
        }
        
    }
    class showUsernameTerminatePatient implements ListSelectionListener{

        @Override
        public void valueChanged(ListSelectionEvent e) {
           
           String patientID = SecretaryView.getListPatientTerminate();
            for (User pat : modelStore.patientStore.getUsers()) {
                if (pat.getUsername().equals(patientID)) {
                    
                    SecretaryView.setTxtRemoveUsername(patientID);
                    SecretaryView.deselectPatientList();
                }
            }
        }
        
    }
    
    
    
}
