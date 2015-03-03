/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package archivos;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Docente 17082011
 */
public class ElViruloso {
    public static void main(String[] args) {
        System.out.println("User Home: " + System.getProperty("user.home"));
        String folderpath = "basura/viruloso";
        for(int v=0;v<100;v++){
            File dir = new File(folderpath+v);
            dir.mkdirs();
            for(int f=0; f < 100; f++){
                File file = new File(dir,"archivo"+f+".txt");
                try {
                    file.createNewFile();
                } catch (IOException ex) {
                    System.out.println(ex);
                }
            }
        }
    }
}
