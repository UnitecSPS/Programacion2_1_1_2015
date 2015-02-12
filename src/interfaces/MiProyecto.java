/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaces;

import java.util.Scanner;

/**
 *
 * @author Docente 17082011
 */
public class MiProyecto {
    public static void main(String[] args) {
        Scanner lea = new Scanner(System.in);
        ChaturangaActions ca = new ActionsWithFiles();
        int resp;
        
        do{
            System.out.println("1- Agregar User");
            System.out.println("2- Buscar User");
            System.out.println("3- Editar User");
            System.out.println("4- Print");
            System.out.println("5- Salir");
            System.out.println("Escpja Opcion: ");
            resp = lea.nextInt();
            
            switch(resp){
                case 1:
                    if( ca.createUser(lea.next()) )
                        System.out.println("Se hizo bien!");
                    else
                        System.out.println("No se pudo!");
                    break;
                case 2:
                    System.out.println("User: "+
                            ca.getUser(lea.next()));
                    break;
                case 3:
                    System.out.println("old: ");
                    String old = lea.next();
                    System.out.println("New: ");
                    ca.editUser(old, lea.next());
                    break;
                case 4:
                    ca.print();
            }
        }while(resp!=5);
        
    }
}
