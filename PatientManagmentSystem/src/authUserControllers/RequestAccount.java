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
public class RequestAccount implements CreateAccountStrategy {

    @Override
    public Models CreateAccount(Models models, User user) {
        models.pendingAccountsStore.addUser(user);
        return models;
    }
    
}
