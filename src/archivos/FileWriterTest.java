/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package archivos;

import java.io.FileWriter;
import java.util.Scanner;

/**
 *
 * @author Docente 17082011
 */
public class FileWriterTest {
    public static void main(String[] args) {
        do{
            Scanner lea = new Scanner(System.in);
            lea.useDelimiter("\n");
                
            System.out.println("Path del file: ");
            String path = lea.next();
            System.out.println("Append o no? (s/n): ");
            char app = lea.next().charAt(0);
              
            try(FileWriter fw = new FileWriter(path, app=='s')){
                String txt;
                do{
                    System.out.println("Ingrese un texto: ");
                    txt = lea.next();
                    if(!txt.equals("#$%"))
                        fw.write(txt+"\n");
                    fw.flush();
                }while(!txt.equals("#$%"));
                
            }
            catch(Exception e){
                System.out.println(e);
            }
            
        }while(true);
    }
}
