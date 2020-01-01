/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package authUserControllers;

import modelStore.Models;
import usermodels.User;

/**
 *
 * @author dan
 */
public class CreateAccount implements CreateAccountStrategy {

    /**
     * strategy to create an account
     * <p> adds a user to adminstore </p>
     * @param models
     * @param user
     * @return the updated models with the new admin 
     */
    @Override
    public Models CreateAccount(Models models, User user) {
        models.adminStore.addUser(user);
        return models;       
    }


}
