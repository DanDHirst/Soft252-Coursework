/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serializer;

import modelStore.Models;

/**
 *
 * @author dan
 */
public abstract class TemplateFileManagement {
    protected Models modelStore;

    
    public Models executeAction(Models modelStore){
        this.modelStore = modelStore;
        openFile();
        modifyFile();
        closeFile();
        return this.modelStore;
    }

    

    protected abstract void modifyFile();

    protected abstract void closeFile() ;

    protected abstract void openFile() ;
        
    
}
