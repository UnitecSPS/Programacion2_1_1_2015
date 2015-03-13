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
            System.out.println("3- Agregar Review");
            System.out.println("4- Agregar Ciente");
            System.out.println("5- Listar Clientes");
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
                    case 3:
                        review();
                        break;
                    case 4:
                        addCliente();
                        break;
                    case 5:
                        store.listClients();
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

    private static void review() throws IOException{
        System.out.println("Codigo: ");
        int cvg = lea.nextInt();
        System.out.println("Stars (0-5): ");
        int stars = lea.nextInt();
        int rating = store.addReview(cvg, stars);
        if( rating >= 0 )
            System.out.println("Nuevo Rating: "+rating);
        else
            System.out.println("No se encontro o las estrellas estan malas");
    }

    private static void addCliente()throws IOException {
        System.out.println("Nombre: ");
        String n = lea.next();
        System.out.println("Fecha dd/mm/aaaa: ");
        String f = lea.next();
        store.addClient(n, f);
    }
}
