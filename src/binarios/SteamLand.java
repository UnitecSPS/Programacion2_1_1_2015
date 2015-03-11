/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package binarios;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Docente 17082011
 */
public class SteamLand {
    static Steam store = new Steam();
    static Scanner lea = new Scanner(System.in);
    
    public static void main(String[] args) {
        lea.useDelimiter("\n");
        int op=0;
        
        do{
            System.out.println("1- Agregar Video Game");
            System.out.println("2- Listar Available Games");
            System.out.println("7- Salir");
            System.out.println("Opcion: ");
            
            try{
                op = lea.nextInt();
                
                switch(op){
                    case 1:
                        addGame();
                        break;
                    case 2:
                        store.listAvailableGames();
                        break;
                }
            }
            catch(Exception e){
                System.out.println("Error: " + e);
            }
            
            
        }while(op != 7);
    }

    private static void addGame()throws IOException {
        System.out.println("Titulo: ");
        String t = lea.next();
        System.out.println("Precio: ");
        double p = lea.nextDouble();
        System.out.println("Genero: ");
        Genero g = Genero.valueOf(lea.next().toUpperCase());
        System.out.println("Rate: ");
        Rate r = Rate.valueOf(lea.next().toUpperCase());
        
        store.addVideoGame(t, p, g, r);
    }
}
