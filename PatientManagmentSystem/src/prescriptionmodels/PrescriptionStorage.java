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
     *
     */
    public PrescriptionStorage() {
    }

    /**
     *
     * @param prescription
     */
    public void addPrescription(Prescription prescription) {
        this.prescriptions.add(prescription);
    }

    /**
     *
     * @param prescription
     */
    public void removePrescriptions(Prescription prescription) {
        prescriptions.remove(prescription);
    }

    /**
     *
     * @param prescription
     * @return
     */
    public Prescription findPrescription(Prescription prescription) {
        int index = prescriptions.indexOf(prescription);
        return prescriptions.get(index);
    }

    /**
     *
     * @return
     */
    public ArrayList<Prescription> getPrescriptions() {
        return this.prescriptions;
    }
}
