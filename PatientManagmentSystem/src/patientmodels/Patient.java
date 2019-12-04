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
public class Patient extends User implements PatientInfo{
    private int age;
    private String sex;
    
    public Patient(int age, String sex, String username, String password, String firstName, String surname, String address) {
        super(username, password, firstName, surname, address);
        this.age = age;
        this.sex = sex;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String getSex() {
        return sex;
    }

    @Override
    public void setSex(String sex) {
        this.sex = sex;
    }
    
    
    
}
