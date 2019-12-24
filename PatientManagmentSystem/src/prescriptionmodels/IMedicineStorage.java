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
    public void addMedicine(Medicine medicine);

    public void removeMedicine(Medicine medicine);

    public Medicine findMedicine(Medicine medicine);

    public ArrayList<Medicine> getMedicine();
}
