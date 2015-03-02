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
                else if(file.isDirectory())
                    System.out.println("Es un directorio");
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
                System.out.println("FILE o DIR ?");
                switch(lea.next().toUpperCase()){
                    case "FILE":
                        file.createNewFile();
                        break;
                    case "DIR":
                        file.mkdir();
                }
            }
            
        }while(true);
    }
}
