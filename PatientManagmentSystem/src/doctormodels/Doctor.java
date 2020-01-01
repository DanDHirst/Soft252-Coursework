/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doctormodels;


import java.io.Serializable;
import usermodels.User;

/**
 *
 * @author dhirst1
 */
public class Doctor extends User implements Serializable {

    /**
     * Constructor so that the program can read from the file 
     */
    public Doctor(){
        
    }

    /**
     * Constructor so can create a new doctor using the super class user
     * @param username
     * @param password
     * @param firstName
     * @param surname
     * @param address
     */
    public Doctor(String username, String password, String firstName, String surname, String address) {
        super(username, password, firstName, surname, address);
    }
    
 

    
}
