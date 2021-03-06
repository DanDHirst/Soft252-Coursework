/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doctormodels;

import java.io.Serializable;
import java.util.ArrayList;
import usermodels.User;
import usermodels.IUserManagement;

/**
 *
 * @author dan
 */
public class DoctorStorage implements IUserManagement , Serializable{
    ArrayList<User> doctors = new ArrayList<>();

    /**
     * Constructor to set up doctorStorage
     */
    public DoctorStorage() {
    }

    @Override
    public void addUser(User user) {
        this.doctors.add(user);
    }

    @Override
    public void removeUser(User user) {
        this.doctors.remove(user);
    }

    @Override
    public User findUser(User user) {
        int index = this.doctors.indexOf(user);
        return this.doctors.get(index);
    }

    @Override
    public ArrayList<User> getUsers() {
        return this.doctors;
    }
}
