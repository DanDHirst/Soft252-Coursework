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
public interface UserManagment {
    public void addUser(User user);
    public void removeUser(User user);
    public User findUser(User user);
    public ArrayList<User> getUsers();
}
