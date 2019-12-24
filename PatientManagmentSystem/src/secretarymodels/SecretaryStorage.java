/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secretarymodels;

import java.io.Serializable;
import java.util.ArrayList;
import usermodels.User;
import usermodels.UserManagement;

/**
 *
 * @author dan
 */
public class SecretaryStorage implements UserManagement , Serializable{
    ArrayList<User> secretaries = new ArrayList<>();

    public SecretaryStorage() {
    }

    @Override
    public void addUser(User user) {
        this.secretaries.add(user);
    }

    @Override
    public void removeUser(User user) {
        this.secretaries.remove(user);
    }

    @Override
    public User findUser(User user) {
        int index = this.secretaries.indexOf(user);
        return this.secretaries.get(index);
    }

    @Override
    public ArrayList<User> getUsers() {
        return this.secretaries;
    }
     
    
}
