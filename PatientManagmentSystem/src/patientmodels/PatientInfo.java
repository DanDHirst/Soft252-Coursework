/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientmodels;

/**
 *
 * @author dan
 */
public interface PatientInfo {

    /**
     *gets age 
     * @return gets age as a integer
     */
    public int getAge();
    
    /**
     * sets age as a integer
     * @param age
     */
    public void setAge(int age);

    /**
     * gets sex
     * @return gets sex as a String
     */
    public String getSex();

    /**
     * sets sex as a string
     * @param sex
     */
    public void setSex(String sex);
}
