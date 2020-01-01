/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prescriptionmodels;

import java.io.Serializable;

/**
 *
 * @author dhirst1
 */
public class Medicine implements Serializable {
    private String name;
    private int quantity;
    private String dosage;

    /**
     *Constructor to set up a medicine 
     * 
     * @param name
     * @param quantity
     * @param dosage
     */
    public Medicine(String name, int quantity, String dosage) {
        this.name = name;
        this.quantity = quantity;
        this.dosage = dosage;
    }

    /**
     * Constructor for setting up a medicine object
     * @param name
     * @param quantity
     */
    public Medicine(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }
    
    /**
     * gets medicine name
     * @return medicine name
     */
    public String getName() {
        return name;
    }

    /**
     * sets medicine name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *gets medicine quantity
     * @return
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     *sets medicine quantity
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * gets medicine dosage
     * @return medicine dosage
     */
    public String getDosage() {
        return dosage;
    }

    /**
     *sets medicine dosage
     * @param dosage
     */
    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

   
    
    
}
