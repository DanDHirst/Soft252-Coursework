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
    private ICreateAccountStrategy createAccount;

    public AuthHandler() {
        
    }
    public void setStrategy(ICreateAccountStrategy createAccount){
        this.createAccount = createAccount;
    }
    
    public Models createAccount(Models models,User user){
        return createAccount.CreateAccount(models, user);
    }
}
