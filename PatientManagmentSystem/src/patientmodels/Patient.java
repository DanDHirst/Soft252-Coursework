/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientmodels;

import usermodels.User;

/**
 *
 * @author dhirst1
 */
public class Patient extends User{
    private int age;
    private String sex;
    
    public Patient(int age, String sex, String username, String password, String firstName, String surname, String address) {
        super(username, password, firstName, surname, address);
        this.age = age;
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    
    
    
}
