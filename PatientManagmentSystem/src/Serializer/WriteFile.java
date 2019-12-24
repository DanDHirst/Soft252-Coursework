/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serializer;

import com.google.gson.Gson;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelStore.Models;

/**
 *
 * @author danhi
 */
public class WriteFile extends TemplateFileManagement{
    FileWriter file;
    

    @Override
    protected void closeFile() {
        try {
            file.close();
        } catch (IOException ex) {
            Logger.getLogger(WriteFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void openFile() {
        try {
            this.file = new FileWriter("Data.json");
        } catch (IOException ex) {
            Logger.getLogger(WriteFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void modifyFile() {
        try {
            Gson gson = new Gson();
            String jsonString = gson.toJson(modelStore);
            file.write(jsonString);
        } catch (IOException ex) {
            Logger.getLogger(WriteFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
