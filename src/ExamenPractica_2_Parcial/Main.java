/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExamenPractica_2_Parcial;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KenyStev
 */
public class Main {
    static Biblioteca library = new Biblioteca();
    static Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) {
        while(true){
            try {
                System.out.printf("\n%s\n%s\n%s\n%s\n%s\n\n",
                        "1. addBook",
                        "2. rentBook",
                        "3. statistics",
                        "4. reportBooks",
                        "5. salir");
                System.out.print("Escoja su opcion: ");
                int resp = scan.nextInt();
                switch(resp){
                    case 1: //addBook
                        System.out.println("Ingrese code title price");
                        library.addBook(scan.nextInt(), scan.next(), scan.nextDouble());
                        break;
                    case 2: //rentBook
                        System.out.println("Ingrese code");
                        library.rentBook(scan.nextInt());
                        break;
                    case 3: //statistics
                        library.statistics();
                        break;
                    case 4: //reportBooks
                        System.out.println("Ingrese en Path del archivo");
                        library.reportBooks(scan.next());
                        break;
                    case 5: System.exit(0);
                }
            } catch (IOException ex) {
                System.out.println("Error: "+ex);
            }
        }
    }
}
