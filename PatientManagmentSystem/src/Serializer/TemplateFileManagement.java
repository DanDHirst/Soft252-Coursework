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

    /**
     *Model that will be returned
     */
    protected Models modelStore;

    /**
     *The template method for file management
     * <p> Template strategy to read and write to the file
     * it handles all the file management and returns the models
     * from the data.json file </p>
     *
     * @param modelStore
     * @return The models written/read from the JSON file
     */
    public Models executeAction(Models modelStore){
        this.modelStore = modelStore;
        openFile();
        modifyFile();
        closeFile();
        return this.modelStore;
    }

    /**
     * Abstract method to implement
     */
    protected abstract void modifyFile();

    /**
     * Abstract method to implement
     */
    protected abstract void closeFile();

    /**
     * Abstract method to implement
     */
    protected abstract void openFile();
        
    
}
