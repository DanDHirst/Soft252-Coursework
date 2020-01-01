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
public class RequestMedicineStore implements IMedicineStorage , Serializable {
    ArrayList<Medicine> medicines = new ArrayList<>();

    /**
     * constructor for the request a medicine storage
     */
    public RequestMedicineStore() {
    }

    /**
     *adds a medicine by passing in a medicine object
     * @param medicine
     */
    @Override
    public void addMedicine(Medicine medicine) {
        medicines.add(medicine);
    }

    /**
     *removes a medicine by passing in a medicine object
     * @param medicine
     */
    @Override
    public void removeMedicine(Medicine medicine) {
        medicines.remove(medicine);
    }

    /**
     *finds a medicine by passing in a medicine object
     * @param medicine
     * @return the index of the medicine as a integer
     */
    @Override
    public Medicine findMedicine(Medicine medicine) {
        int index = medicines.indexOf(medicine);
        return medicines.get(index);
    }

    /**
     * gets all the medicines
     * @return array list of medicine objects
     */
    @Override
    public ArrayList<Medicine> getMedicine() {
        return this.medicines;
    }
}
