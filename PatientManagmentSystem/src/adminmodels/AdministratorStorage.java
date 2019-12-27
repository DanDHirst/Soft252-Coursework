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

    public AdministratorStorage() {
    }

    @Override
    public void addUser(User user) {
        this.admins.add(user);
    }

    @Override
    public void removeUser(User user) {
        this.admins.remove(user);
    }

    @Override
    public User findUser(User user) {
        int index = this.admins.indexOf(user);
        return this.admins.get(index);
    }

    @Override
    public ArrayList<User> getUsers() {
        return this.admins;
    }
}
