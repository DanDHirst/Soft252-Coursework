/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prescriptionmodels;

import java.util.ArrayList;

/**
 *
 * @author dan
 */
public interface IMedicineStorage {

    /**
     *abstract add medicine
     * @param medicine
     */
    public void addMedicine(Medicine medicine);

    /**
     * abstract remove medicine
     * @param medicine
     */
    public void removeMedicine(Medicine medicine);

    /**
     *abstract find medicine
     * @param medicine
     * @return a medicine object
     */
    public Medicine findMedicine(Medicine medicine);

    /**
     *abstract get all medicines
     * @return array list of medicine objects
     */
    public ArrayList<Medicine> getMedicine();
}
