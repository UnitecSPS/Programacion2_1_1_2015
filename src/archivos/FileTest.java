    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package archivos;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Docente 17082011
 */
public class FileTest {
    public static void main(String[] args) throws IOException {
        do{
            Scanner lea = new Scanner(System.in);
            System.out.println("Path del file: ");
            
            File file = new File(lea.next());
            
            if(file.exists()){
                System.out.println("Nombre: " + file.getName());
                System.out.println("Parent: " + file.getParent());
                System.out.println("Path: " + file.getPath());
                System.out.println("Absolute Path: " + file.getAbsolutePath());
                if(file.isFile())
                    System.out.println("Es un archivo");
                else if(file.isDirectory()){
                    System.out.println("Es un directorio");
                    System.out.println("Quiere imprimir el dir command: ");
                    if(lea.next().equalsIgnoreCase("SI"))
                        dirCommand(file);
                    System.out.println("Quiere imprimir el tree command: ");
                    if(lea.next().equalsIgnoreCase("SI"))
                        treeCommand(file);
                }
                if(file.isHidden())
                    System.out.println("Esta Oculto");
                if(file.isAbsolute())
                    System.out.println("Fue instanciado con path absoluto");
                System.out.println("Size: " + file.length());
                System.out.println("Lo queres borrar? ");
                if(lea.next().equals("SI"))
                    file.delete();
            }
            else{
                boolean exito = false;
                System.out.println("FILE o DIR ?");
                switch(lea.next().toUpperCase()){
                    case "FILE":
                        exito = file.createNewFile();
                        break;
                    case "DIR":
                        exito = file.mkdirs();
                }
                
                if(exito)
                    System.out.println("Se realizo perfecto");
                else
                    System.out.println("No se pudo crear");   
            }
            
        }while(true);
    }

    private static void dirCommand(File file) {
        for(File child : file.listFiles()){
            if(!child.isHidden()){
                System.out.print(new Date(child.lastModified())+"\t");
                if(child.isDirectory())
                    System.out.print("<DIR>\t");
                if(child.isFile())
                    System.out.print(child.length()+ "\t");
                System.out.println("-"+child.getName());
            }
        }
    }

    private static void treeCommand(File file) {
        treeCommand("",file);
    }

    private static void treeCommand(String tab, File file) {
        if(file.isDirectory()){
            System.out.println(tab+file.getName());
            for(File child : file.listFiles())
                treeCommand(tab+"--",child);
        }
    }
}
