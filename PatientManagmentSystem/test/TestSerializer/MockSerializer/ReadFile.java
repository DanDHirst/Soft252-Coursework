/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestSerializer.MockSerializer;

import com.google.gson.Gson;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelStore.Models;

/**
 *
 * @author dan
 */
public class ReadFile extends TemplateFileManagement{
    FileReader file;
    
    /**
     *Reads JSON data from a file
     * <p> Reads file using GSON and writes it to a Models object
     * </p>
     */
    @Override
    protected void modifyFile() {
        Models store = null;
        Gson gson = new Gson();
        try (Reader reader = new FileReader("TestData.json")) {
            // Convert JSON File to Java Object
            store = gson.fromJson(reader, Models.class);	
            // print staff 
            this.modelStore = store;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *Closes the open file
     * <p> Closes the open file so the contents save and can 
     * be accessed again </p>
     */
    @Override
    protected void closeFile() {
        try {
            file.close();
        } catch (IOException ex) {
            Logger.getLogger(ReadFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Opens the file to be read from
     * <p> Opens the file Data.json to be read from </p>
     */
    @Override
    protected void openFile() {
        try {
            this.file = new FileReader("Data.json");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
