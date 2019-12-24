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

    public RequestMedicineStore() {
    }

    @Override
    public void addMedicine(Medicine medicine) {
        medicines.add(medicine);
    }

    @Override
    public void removeMedicine(Medicine medicine) {
        medicines.remove(medicine);
    }

    @Override
    public Medicine findMedicine(Medicine medicine) {
        int index = medicines.indexOf(medicine);
        return medicines.get(index);
    }

    @Override
    public ArrayList<Medicine> getMedicine() {
        return this.medicines;
    }
}
