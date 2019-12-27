/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientmodels;

import java.io.Serializable;
import java.util.ArrayList;
import usermodels.User;
import usermodels.IUserManagement;

/**
 *
 * @author dan
 */
public class PatientStorage implements IUserManagement , Serializable{
    ArrayList<Patient> patients= new ArrayList<>();
    public PatientStorage() {
    }

    @Override
    public void addUser(User user) {
           this.patients.add((Patient) user);
    }

    @Override
    public void removeUser(User user) {
        this.patients.remove((Patient) user);
    }

    @Override
    public User findUser(User user) {
        int index = this.patients.indexOf(user);
        return this.patients.get(index);
    }

    @Override
    public ArrayList<User> getUsers() {
        ArrayList<User> tempUser = new ArrayList<>();
        for (int i = 0; i < this.patients.size(); i++) {
            tempUser.add(this.patients.get(i));
	}
        return tempUser;
    }
    
}
