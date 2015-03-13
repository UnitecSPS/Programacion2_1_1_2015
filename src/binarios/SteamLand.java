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
            System.out.println("6- Bajar un juego");
            System.out.println("7- Actualizar Precio Game");
            System.out.println("8- Actualizar disponibilidad Game");
            System.out.println("9- Reporte de CLiente");
            System.out.println("10- Cliente Estrella");
            System.out.println("11- Salir");
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
                    case 6:
                        download();
                        break;
                    case 7:
                        price();
                        break;
                    case 8:
                        availableFor();
                        break;
                    case 9:
                        report();
                        break;
                    case 10:
                        store.clientEstrella();
                        break;
                }
            }
            catch(Exception e){
                System.out.println("Error: " + e);
            }
            
            
        }while(op != 11);
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

    private static void download()throws IOException {
        System.out.println("Video Game: ");
        int cvg=lea.nextInt();
        System.out.println("Cliente: ");
        int ccli = lea.nextInt();
        System.out.println("SO (W,M,L): ");
        char so = lea.next().charAt(0);
        
        if(store.addDownload(cvg, ccli, so))
            System.out.println("Download Exitoso\n");
        else
            System.out.println("Fallo el Download\n");
    }

    private static void price()throws IOException {
        System.out.println("Video Game: ");
        int cvg=lea.nextInt();
        System.out.println("Nuevo Precio: ");
        double newprice = lea.nextDouble();
        store.updatePriceFor(cvg, newprice);
    }

    private static void availableFor()throws IOException {
        System.out.println("Video Game: ");
        int cvg=lea.nextInt();
        System.out.println("SO (W,M,L): ");
        char SO = lea.next().charAt(0);
        store.updateAvailableFor(cvg, SO);
    }

    private static void report()throws IOException {
        System.out.println("Cliente: ");
        int ccli = lea.nextInt();
        System.out.println("Path del txt: ");
        String path = lea.next();
        store.reportForClient(ccli, path);
    }
    
}
