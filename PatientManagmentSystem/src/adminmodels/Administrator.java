/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminmodels;

import java.io.Serializable;
import usermodels.User;

/**
 *
 * @author dhirst1
 */
public class Administrator extends User {

    /**
     * default constructor so can save read from the json file
     */
    public Administrator(){
    }
    
    /**
     * Constructor that call the super call user to create and admin
     * @param username
     * @param password
     * @param firstName
     * @param surname
     * @param address
     */
    public Administrator(String username, String password, String firstName, String surname, String address) {
        super(username, password, firstName, surname, address);
    }

    
    
}
