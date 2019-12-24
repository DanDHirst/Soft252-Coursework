/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serializer;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import modelStore.Models;

/**
 *
 * @author danhi
 */
public class WriteFile {
    public  static void write(Models modelStore){
        Gson gson = new Gson();
            try {
            String jsonString = gson.toJson(modelStore);

            FileWriter file = new FileWriter("test.json");
            file.write(jsonString);
            file.close();
        } catch (IOException e) {
            System.out.println("exception " + e.getMessage());
            e.printStackTrace();
        } 
    }
}
