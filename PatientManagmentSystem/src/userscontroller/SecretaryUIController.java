/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userscontroller;

import Serializer.WriteFile;
import UsersUI.SecretaryUI;
import appointmentmodels.Appointment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import modelStore.Models;
import patientmodels.Patient;
import prescriptionmodels.Medicine;
import prescriptionmodels.Prescription;
import usermodels.User;

/**
 *
 * @author dhirst1
 */
public class SecretaryUIController {

    /**
     *This is were the view is stored
     */
    public SecretaryUI SecretaryView;

    /**
     * This is the models storage
     */
    public Models modelStore;

    /**
     * Object to initalise the writefile object
     */
    public WriteFile file = new WriteFile();

    /**
     *Constructor to set up the controller
     * <p> initalises the Secretary view and modelStore</p>
     * <p> sets up the users, apppointments and medStock on screen</p>
     * <p> sets up the onClicks listeners </p>
     * @param modelStore
     * @param UserID
     */
    public SecretaryUIController(Models modelStore, String UserID) {
        this.modelStore = modelStore;
        this.SecretaryView = new SecretaryUI();
        SecretaryView.setVisible(true);
        SecretaryView.setTxtSecretaryID(UserID);
        setUpOnClicks();
        setUpUsers();
        setUpPendingAppointments();
        setUpDoctorAppointment();
        setUpMedStock();
        
        
    }

    /**
     *Save the model to file
     * <p> calls the writeFile object to write the models to the file</p>
     */
    public void saveData(){
        file.executeAction(modelStore);
    } 
    private void setUpOnClicks(){
        SecretaryView.listApprovePatientListener(new SecretaryUIController.ShowPendingPatient());
        this.SecretaryView.btnApprovePatient(new SecretaryUIController.ApprovePatient());
        this.SecretaryView.btnRemovePatient(new SecretaryUIController.RemovePatient());
        this.SecretaryView.listPatientListener(new SecretaryUIController.showUsernamePatient());
        this.SecretaryView.listTermiatePatientListener(new SecretaryUIController.showUsernameTerminatePatient());
        this.SecretaryView.listPendingAppointmentsonClick(new SecretaryUIController.ShowPendingAppointment());
        this.SecretaryView.btnCreateAppointmentListener(new SecretaryUIController.CreateAppointment());
        this.SecretaryView.listMedicinePatientonClick(new SecretaryUIController.ShowPatientPrescription());
        this.SecretaryView.listPrescriptionPatientonClick(new SecretaryUIController.ShowPatientPrescriptionInfo());
        this.SecretaryView.btnGiveMed(new SecretaryUIController.GiveMedicine());
        this.SecretaryView.btnAddMedicine(new SecretaryUIController.AddMedicine());
        this.SecretaryView.ListMedicineStock(new SecretaryUIController.ViewMedicine());
        this.SecretaryView.ListMedicineRequestedStock(new SecretaryUIController.ViewRequestedMedicine());
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
        SecretaryView.setListMedicinePatient(pList);
    }
    private void setUpPatientsTerminate(){
        int pLength = modelStore.pendingTerminateStore.getUsers().size();
        String[] tPList = new String[pLength];
        for (int i = 0; i < pLength; i++) {
            tPList[i] = modelStore.pendingTerminateStore.getUsers().get(i).getUsername();
           
        }
        SecretaryView.setListPatientTerminate(tPList);
    }
    private void setUpPendingAppointments(){
        int aLength = modelStore.pendingAppointmentsStore.getAppointments().size();
        String[] appList = new String[aLength];
        for (int i = 0; i < aLength; i++) {
            appList[i] = Integer.toString(modelStore.pendingAppointmentsStore.getAppointments().get(i).getAppointmentID());
           
        }
        SecretaryView.setListPendingAppointments(appList);
    }
    private void setUpDoctorAppointment(){
        for (User dr : modelStore.doctorStore.getUsers()) {
             SecretaryView.addBoxDoctor(dr.getUsername());
        }
    }
    private void setUpMedStock(){
        int medLength = modelStore.medicineStore.getMedicine().size();
        String[] medList = new String[medLength];
        for (int i = 0; i < medLength; i++) {
            medList[i] = (modelStore.medicineStore.getMedicine().get(i).getName());
           
        }
        SecretaryView.setListMedicineStock(medList);
        setUpRequestedMedStock();
        
        
    }
    private void setUpRequestedMedStock(){
        int medRequestedLength = modelStore.requestMedicineStore.getMedicine().size();
        String[] medRequestedList = new String[medRequestedLength];
        for (int i = 0; i < medRequestedLength; i++) {
            medRequestedList[i] = (modelStore.requestMedicineStore.getMedicine().get(i).getName());
           
        }
        SecretaryView.setListMedicineRequestedStock(medRequestedList);
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
    private void clearAppointmentInfo(){
        SecretaryView.setTxtAppointmentID("");
        SecretaryView.setTxtUserStart("");
        SecretaryView.setTxtUserEnd("");
        SecretaryView.setTxtRequestDoctor("");
        SecretaryView.setTxtPatientApp("");
    }
    private void clearPrescriptionInfo(){
        SecretaryView.setTxtPrescriptionID("");
        SecretaryView.setTxtPreDate("");
        SecretaryView.setTxtPreDoctorID("");
        SecretaryView.setTxtPreMedDosage("");
        SecretaryView.setTxtPreMedName("");
        SecretaryView.setTxtPreMedQty("");
        SecretaryView.setTxtPreNotes("");
        SecretaryView.setTxtPrePatientID("");
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
            saveData();
            
            
            
        }
        
    }
    class RemovePatient implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String patientID = SecretaryView.getTxtRemoveUsername();
            for (User pat : modelStore.patientStore.getUsers()) {
                if (pat.getUsername().equals(patientID)) {
                    modelStore.patientStore.removeUser(pat);
                    for(User patRemove : modelStore.pendingTerminateStore.getUsers()){
                        if (patRemove.getUsername().equals(pat.getUsername())) {
                            modelStore.pendingTerminateStore.removeUser(patRemove);
                        }
                    }
                    
                }
            }
            setUpUsers();
            SecretaryView.setTxtRemoveUsername("");
            saveData();
            
            
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
            saveData();
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
    class ShowPendingAppointment implements ListSelectionListener{

        @Override
        public void valueChanged(ListSelectionEvent e) {
            if(SecretaryView.getListPendingAppointments() != null){
                
                int appointmentID = Integer.parseInt(SecretaryView.getListPendingAppointments());
                //loop thorugh all of the pending appointmenst for the info needed
                for(Appointment ap : modelStore.pendingAppointmentsStore.getAppointments()){
                    if (appointmentID == ap.getAppointmentID()) {
                        SecretaryView.setTxtAppointmentID(Integer.toString(ap.getAppointmentID()));
                        SecretaryView.setTxtUserStart(ap.getStartTime().toString());
                        SecretaryView.setTxtUserEnd(ap.getEndTime().toString());
                        SecretaryView.setTxtRequestDoctor(ap.getDoctorID());
                        SecretaryView.setTxtPatientApp(ap.getPatientID());
                    }
                }
            }
            
            
        }
        
    }
    class CreateAppointment implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           Date start = SecretaryView.getDateStart(); 
            String startDate = Integer.toString(start.getYear()+1900)+ "-" 
                    + checkDateMonth(start) + "-" 
                    + checkDateDay(start) + "T" + SecretaryView.getBoxStartHour()
                    + ":" + SecretaryView.getTxtMinStart() + ":" + "00";
            Date end = SecretaryView.getDateStart();
            String endDate = Integer.toString(end.getYear()+1900)+ "-" 
                    + checkDateMonth(end) + "-" 
                    + checkDateDay(end) + "T" + SecretaryView.getBoxEndHour()
                    + ":" + SecretaryView.getTxtMinEnd() + ":" + "00";
            
            
            LocalDateTime datetimeStart = LocalDateTime.parse(startDate);
            LocalDateTime dateTimeEnd = LocalDateTime.parse(endDate);
            String doctor = SecretaryView.getBoxDoctor();
            String patientID = SecretaryView.getTxtPatientApp();
            int SizeOfAppoitments = modelStore.appointmentStore.getAppointments().size() -1;
            int getAppointmentID = modelStore.appointmentStore.getAppointments().get(SizeOfAppoitments).getAppointmentID() +1;
            Appointment ap = new Appointment(getAppointmentID,datetimeStart, dateTimeEnd, doctor, patientID);
            boolean isInList = false;
            for (Appointment tempAp : modelStore.appointmentStore.getAppointments()) {
                if (tempAp.getDoctorID().equals(doctor)){
                    if ((datetimeStart.isBefore(tempAp.getStartTime()) || datetimeStart.isAfter(tempAp.getEndTime())) 
                            && (dateTimeEnd.isBefore(tempAp.getStartTime())|| dateTimeEnd.isAfter(tempAp.getEndTime()))) {  
                    }
                    else{
                       isInList = true;
                    }
                }
            }
            if (isInList) {
                SecretaryView.setTxtAppResponse("The doctor is busy at those times");
            }
            else{
                modelStore.appointmentStore.addAppointment(ap);
                SecretaryView.setTxtAppResponse("Appointment made");
                removePendingAppointment(Integer.parseInt(SecretaryView.getTxtAppointmentID()));
                SecretaryView.deselectPendingAppointment();
                setUpPendingAppointments();
                clearAppointmentInfo();
                
            }
            saveData();
            
            
        }
        public String checkDateDay(Date aDate){ // prevents from crashing if date is less than 10
            if (aDate.getDate() < 10) {
                String newDate = "0" + Integer.toString(aDate.getDate());
                
                return newDate;
            }
            return Integer.toString(aDate.getDate());
                      
        }
        public String checkDateMonth(Date aDate){ // prevents from crashing if month is less than 10
            if (aDate.getMonth() < 10) {
                String newDate = "0" + Integer.toString(aDate.getMonth()+1);
                
                return newDate;
            }
            return Integer.toString(aDate.getMonth());
                      
        }
        public void removePendingAppointment(int appointment){
            for(Appointment app : modelStore.pendingAppointmentsStore.getAppointments()){
                if (app.getAppointmentID() == appointment) {
                    modelStore.pendingAppointmentsStore.removeAppointment(app);
                    break;
                }
            }
            saveData();
        }
       
        
    }
    
    class ShowPatientPrescription implements ListSelectionListener{

        @Override
        public void valueChanged(ListSelectionEvent e) {
            String username = SecretaryView.getListMedicinePatient();
            // loop though all prescriptions
            int pLength = modelStore.prescriptionStore.getPrescriptions().size();
            String[] PList = new String[pLength];
            for (int i = 0; i < pLength; i++) {
                if (modelStore.prescriptionStore.getPrescriptions().get(i).getPatient().equals(username) 
                        && modelStore.prescriptionStore.getPrescriptions().get(i).isCompleted() == false) {
                    PList[i] = Integer.toString(modelStore.prescriptionStore.getPrescriptions().get(i).getPrescriptionID());
                }

            }
            SecretaryView.setListPrescriptionPatient(PList);
            saveData();
            
        }
        
    }
    class ShowPatientPrescriptionInfo implements ListSelectionListener{

        @Override
        public void valueChanged(ListSelectionEvent e) {
            String username = SecretaryView.getListMedicinePatient();
            if (SecretaryView.getListPrescriptionPatient() != null) {
                int prescriptionID = Integer.parseInt(SecretaryView.getListPrescriptionPatient());
            //loop though the prescriptions finding if user and pre id is the same
                for(Prescription pre : modelStore.prescriptionStore.getPrescriptions()){
                    if (pre.getPatient().equals(username) && pre.getPrescriptionID() == prescriptionID) {
                        SecretaryView.setTxtPrescriptionID(Integer.toString(pre.getPrescriptionID()));
                        SecretaryView.setTxtPreDate(pre.getDatePrescriped().format(DateTimeFormatter.ISO_DATE));
                        SecretaryView.setTxtPreDoctorID(pre.getDoctor());
                        SecretaryView.setTxtPreMedDosage(pre.getMedicine().getDosage());
                        SecretaryView.setTxtPreMedName(pre.getMedicine().getName());
                        SecretaryView.setTxtPreMedQty(Integer.toString(pre.getMedicine().getQuantity()));
                        SecretaryView.setTxtPreNotes(pre.getNotes());
                        SecretaryView.setTxtPrePatientID(pre.getPatient());
                    }
                }
            }
            
            
            
        }
        
    }
    class GiveMedicine implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int prescID = Integer.parseInt(SecretaryView.getTxtPrescriptionID());
            String patientID = SecretaryView.getTxtPrePatientID();
            String doctorID = SecretaryView.getTxtPreDoctorID();
            String medicine = SecretaryView.getTxtPreMedName();
            int medQty = Integer.parseInt(SecretaryView.getTxtPreMedQty());
            String medDose = SecretaryView.getTxtPreMedDosage();
            
            //check if medicine is in stock
            for (Medicine med : modelStore.medicineStore.getMedicine()) {
                if (med.getName().equals(medicine)) {
                    if (med.getQuantity() >= medQty) {
                        med.setQuantity(med.getQuantity() - medQty);
                        SecretaryView.setTxtPreResponse("Prescription validated");
                        for (Prescription pre : modelStore.prescriptionStore.getPrescriptions())
                        {
                            if(pre.getPrescriptionID() == prescID ){
                                pre.completePrescription();
                            }
                            
                        }
                        SecretaryView.deselectPresscriptionID();
                        SecretaryView.deselectPrePatient();
                        clearPrescriptionInfo();
                        setUpPatients();
                        break;
                        
                    }
                    else{
                        SecretaryView.setTxtPreResponse("Medicine not enough stock");
                    }
                }
                else{
                    SecretaryView.setTxtPreResponse("Medicine not in medicine store");
                }
                
            }
            saveData();
            
        }
        
    }
    class AddMedicine implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String medicine = SecretaryView.getTxtOrderMed();
            int quantity = Integer.parseInt(SecretaryView.getTxtOrderMedQty());
            Medicine newMed = new Medicine(medicine,quantity);
            
            Boolean isInList = false;
            for (Medicine med : modelStore.medicineStore.getMedicine()) {
                if (med.getName().equals(medicine)) {
                    isInList = true;
                    med.setQuantity(med.getQuantity() + quantity);
                }
            }
            if (isInList == false) {
                
                modelStore.medicineStore.addMedicine(newMed);
                SecretaryView.setTxtOrderResponse("Medicine has been added ");
            }
            else{
                SecretaryView.setTxtOrderResponse("Medicine Quantity has been added");
            }
//            System.out.println(medicine.equals(SecretaryView.getListMedicineRequestedStock()));
//            if (medicine.equals(SecretaryView.getListMedicineRequestedStock())) {
//                System.out.println("True");
//                modelStore.requestMedicineStore.removeMedicine(newMed);
//                System.out.println(modelStore.requestMedicineStore.getMedicine());
//            }
            for(Medicine tempMeds : modelStore.requestMedicineStore.getMedicine()){
                if (tempMeds.getName().equals(SecretaryView.getListMedicineRequestedStock())){
                    modelStore.requestMedicineStore.removeMedicine(tempMeds);
                    break;
                }
            }
            setUpMedStock();
            saveData();
            
        }
        
    }
    class ViewMedicine implements ListSelectionListener{

        @Override
        public void valueChanged(ListSelectionEvent e) {
            SecretaryView.deselectMedRequestedStock();
            
            String medName = SecretaryView.getListMedicineStock();
            
            for (Medicine med : modelStore.medicineStore.getMedicine()) {
                if (med.getName().equals(medName)) {
                    SecretaryView.setTxtOrderMed(medName);
                    SecretaryView.setTxtOrderMedQty(Integer.toString(med.getQuantity()));
                }
            }
            saveData();
        }
        
    }
    class ViewRequestedMedicine implements ListSelectionListener{

        @Override
        public void valueChanged(ListSelectionEvent e) {
            SecretaryView.deselectMedStock();
            if (SecretaryView.getListMedicineRequestedStock() != null ) {
                String medName = SecretaryView.getListMedicineRequestedStock();
            for (Medicine med : modelStore.requestMedicineStore.getMedicine()) {
                if (med.getName().equals(medName)) {
                    SecretaryView.setTxtOrderMed(medName);
                    SecretaryView.setTxtOrderMedQty(Integer.toString(med.getQuantity()));
                    
                }
            }
            }
            saveData();
            
        }
        
    }
    
    
}
