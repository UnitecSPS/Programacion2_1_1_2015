/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package archivos;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Docente 17082011
 */
public class FileReaderTest {
    public static void main(String[] args) {
       
        try{
            Scanner lea = new Scanner(System.in);
            lea.useDelimiter("\n");
                
            System.out.println("Path del file: ");
            String path = lea.next();
            
            File f = new File(path);
            FileReader fr = new FileReader(f);
            
             //----1 - METODO Utilizando la mera FileReader
            char buffer[] = new char[(int)f.length()];
            System.out.println("CASILLAS DEL ARREGLO: " + buffer.length);
            int bytes = fr.read(buffer);
            
            System.out.println("CONTENIDO\n--------------");
            System.out.println(buffer);
            System.out.println("Bytes leidos: " + bytes);
            
            //----2 METODO utilizando la Scanner
            fr = new FileReader(f);
            Scanner lector = new Scanner(fr);
            lector.useDelimiter("\n");
             System.out.println("\nCONTENIDO CON SCANNER\n--------------");
            while(lector.hasNext()){
                System.out.println(lector.next());
            }
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
}
