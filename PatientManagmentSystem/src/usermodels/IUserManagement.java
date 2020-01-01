/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usermodels;

import java.util.ArrayList;

/**
 *
 * @author dan
 */
public interface IUserManagement {

    /**
     * adds user abstract implementation
     * @param user
     */
    public void addUser(User user);

    /**
     * remove user abstract implementation
     * @param user
     */
    public void removeUser(User user);

    /**
     * finds user abstract implementation
     * @param user
     * @return a user object
     */
    public User findUser(User user);

    /**
     * gets the users
     * @return a array list of users
     */
    public ArrayList<User> getUsers();
}
