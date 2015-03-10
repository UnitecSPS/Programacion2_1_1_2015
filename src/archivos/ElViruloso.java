/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package archivos;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Docente 17082011
 */
public class ElViruloso {
    private String newFilePath = "viruloso";
    private String newFolderPath = "basura";
    
    public void propage(){
        for(int v=0;v<100;v++){
            File dir = new File(newFolderPath+"/"+newFilePath+v);
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
    
    public void clean(){clean(new File(newFolderPath));}
    
    public void clean(File file){
        if(file.isDirectory()){
            for (File f : file.listFiles()) {
                clean(f);
            }
        }
        file.delete();
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ElViruloso newFolder = new ElViruloso();
        
        newFolder.propage();
        System.out.print("Ingrese le path a borra: ");
        newFolder.clean(new File(scan.next()));
    }
}
