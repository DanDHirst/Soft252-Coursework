/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminmodels;

import java.io.Serializable;
import java.util.ArrayList;
import usermodels.User;
import usermodels.IUserManagement;

/**
 *
 * @author dan
 */
public class AdministratorStorage  implements IUserManagement   {
    ArrayList<User> admins = new ArrayList<>();

    /**
     * Default constructor so can read from the json file
     */
    public AdministratorStorage() {
    }

    /**
     * Adds a admin object to this class
     * @param user
     */
    @Override
    public void addUser(User user) {
        this.admins.add(user);
    }

    /**
     * removes a admin object by passing in a user object
     * @param user
     */
    @Override
    public void removeUser(User user) {
        this.admins.remove(user);
    }

    /**
     * Finds an admin by passing in a user object
     * @param user
     * @return the index of the object 
     */
    @Override
    public User findUser(User user) {
        int index = this.admins.indexOf(user);
        return this.admins.get(index);
    }

    /**
     * gets the array list of admins
     * @return the Array list of objects Admins
     */
    @Override
    public ArrayList<User> getUsers() {
        return this.admins;
    }
}
