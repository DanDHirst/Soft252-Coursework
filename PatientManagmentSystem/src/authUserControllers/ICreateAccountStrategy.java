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
public interface ICreateAccountStrategy {
    public Models CreateAccount(Models models,User user);
    
}
