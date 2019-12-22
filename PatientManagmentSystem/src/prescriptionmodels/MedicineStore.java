/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prescriptionmodels;

import appointmentmodels.Appointment;
import java.util.ArrayList;

/**
 *
 * @author dan
 */
public class MedicineStore {
    ArrayList<Medicine> medicines = new ArrayList<>();

    public MedicineStore() {
    }

    public void addMedicine(Medicine medicine) {
        medicines.add(medicine);
    }

    public void removeMedicine(Medicine medicine) {
        medicines.remove(medicine);
    }

    public Medicine findMedicine(Medicine medicine) {
        int index = medicines.indexOf(medicine);
        return medicines.get(index);
    }

    public ArrayList<Medicine> getMedicine() {
        return this.medicines;
    }
}
