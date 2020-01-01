/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usermodels;

import java.io.Serializable;

/**
 *
 * @author dhirst1
 */
public  class User  implements Serializable{

    /**
     *Store the unique id for the user
     */
    protected String userID;

    /**
     * the password for the user
     */
    protected String password;

    /**
     * The users firstname
     */
    protected String firstName;

    /**
     * The users surname
     */
    protected String surname;

    /**
     * The users address 
     */
    protected String address;

    /**
     * default constructor not used except for reading from the json file
     */
    public User(){
        
    }
    
    /**
     * Constructor that initialises the attributes
     * @param username
     * @param password
     * @param firstName
     * @param surname
     * @param address
     */
    public User(String username, String password, String firstName, String surname, String address) {
        this.userID = username;
        this.password = password;
        this.firstName = firstName;
        this.surname = surname;
        this.address = address;
    }

    /**
     * gets username
     * @return the username 
     */
    public String getUsername() {
        return userID;
    }

    /**
     *sets username
     * @param username
     */
    public void setUsername(String username) {
        this.userID = username;
    }

    /**
     * gets the user password
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * sets the password
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *gets the firstname 
     * @return firstname
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     *sets the firstname
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *gets the surname
     * @return surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * sets the surname
     * @param surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * gets the address
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * sets the address 
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    
    
    
    
}
