/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secretarymodels;

import java.io.Serializable;
import usermodels.User;

/**
 *
 * @author dhirst1
 */
public class Secretary extends User implements Serializable{

    /**
     * constructor to set up secretary so can read form the json file
     */
    public Secretary(){
        
    }

    /**
     * constructor that calls the super user constructor
     * @param username
     * @param password
     * @param firstName
     * @param surname
     * @param address
     */
    public Secretary(String username, String password, String firstName, String surname, String address) {
        super(username, password, firstName, surname, address);
    }
    
}
