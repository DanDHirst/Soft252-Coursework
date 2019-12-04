/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usermodels;

/**
 *
 * @author dhirst1
 */
public abstract class User {
    protected String userID;
    protected String password;
    protected String firstName;
    protected String surname;
    protected String address;

    public User(String username, String password, String firstName, String surname, String address) {
        this.userID = username;
        this.password = password;
        this.firstName = firstName;
        this.surname = surname;
        this.address = address;
    }

    public String getUsername() {
        return userID;
    }

    public void setUsername(String username) {
        this.userID = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    
    
    
    
}
