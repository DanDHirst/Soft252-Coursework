/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prescriptionmodels;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author dan
 */
public class PrescriptionStorage implements Serializable{
    ArrayList<Prescription> prescriptions= new ArrayList<>();

    /**
     *Constructor for the prescription storage
     */
    public PrescriptionStorage() {
    }

    /**
     *adds prescription by passing in a prescription object
     * @param prescription
     */
    public void addPrescription(Prescription prescription) {
        this.prescriptions.add(prescription);
    }

    /**
     * removes prescription by passing in a prescription object
     * @param prescription
     */
    public void removePrescriptions(Prescription prescription) {
        prescriptions.remove(prescription);
    }

    /**
     *find prescription by passing in a prescription object
     * @param prescription
     * @return index of the prescription integer
     */
    public Prescription findPrescription(Prescription prescription) {
        int index = prescriptions.indexOf(prescription);
        return prescriptions.get(index);
    }

    /**
     *gets all the prescriptions
     * @return array list of the prescription objects 
     */
    public ArrayList<Prescription> getPrescriptions() {
        return this.prescriptions;
    }
}
