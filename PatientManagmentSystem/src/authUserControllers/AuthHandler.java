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
 * @author dhirst1
 */
public class AuthHandler {
    private CreateAccountStrategy createAccount;

    /**
     * sets up the authandler but it should never be used
     */
    public AuthHandler() {
        
    }

    /**
     *sets the strategy by passing in a strategy you want
     * @param createAccount
     */
    public void setStrategy(CreateAccountStrategy createAccount){
        this.createAccount = createAccount;
    }
    
    /**
     *Calls the create account strategy by passing in models and the user
     * @param models
     * @param user
     * @return the models once the account has been created
     */
    public Models createAccount(Models models,User user){
        return createAccount.CreateAccount(models, user);
    }
}
