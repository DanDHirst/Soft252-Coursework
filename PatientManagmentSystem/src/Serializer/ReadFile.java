/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serializer;

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
    
    @Override
    protected void modifyFile() {
        Models store = null;
        Gson gson = new Gson();
        try (Reader reader = new FileReader("Data.json")) {
            // Convert JSON File to Java Object
            store = gson.fromJson(reader, Models.class);	
            // print staff 
            this.modelStore = store;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void closeFile() {
        try {
            file.close();
        } catch (IOException ex) {
            Logger.getLogger(ReadFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void openFile() {
        try {
            this.file = new FileReader("Data.json");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
