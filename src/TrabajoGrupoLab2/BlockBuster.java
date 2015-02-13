/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TrabajoGrupoLab2;

import herencia.GochaCell;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Docente 17082011
 */
public class BlockBuster {
    static ArrayList<RentItem> items = new ArrayList<RentItem>();
    static Scanner lea = new Scanner(System.in);
    
    public static void main(String[] args) {
        int op;
        
        do{
            System.out.println("1- Agregar Item");
            System.out.println("2- Rentar Item");
            System.out.println("3- Sub Menu de Item");
            System.out.println("4- Imprimir Items");
            System.out.println("5- Salir");
            System.out.println("Escoja opcion: ");
            op = lea.nextInt();
            
            switch(op){
                case 1:
                    System.out.println("Codigo: ");
                    int cod = lea.nextInt();
                    System.out.println("Tipo: ");
                    String tipo = lea.next().toUpperCase();
                    addCuenta(cod, tipo);
                    break;
                case 2:
                    System.out.println("Id del Item: ");
                    int id = lea.nextInt();
                    System.out.println("Dias: ");
                    int dias = lea.nextInt();
                    rent(id,dias);
                    break;
                case 3:
                    System.out.println("Id del Item: ");
                    submenu(lea.nextInt());
                    break;
                case 4:
                    listAll();
                    break;
            }
            
        }while( op != 5 );
    }
    
    private static RentItem search(int id){
        return search(id,0);
    }
    
    private static RentItem search(int id, int pos) {
        if(pos < items.size()){
            if(items.get(pos).getCodigo() == id)
                return items.get(pos);
            return search(id, pos+1);
        }
        return null;
    }

    private static void addCuenta(int id, String tipo) {
        if(search(id) == null){
            System.out.println("Nombre: ");
            String title = lea.next();
            
            if(tipo.equals("MOVIE")){
                System.out.println("Precio: ");
                items.add(new Movie(id, title, lea.nextDouble()));
            }
            else{
                items.add(new PS3Game(id, title));
            }
        }
    }

    private static void rent(int id, int dias) {
        RentItem item = search(id);
        if(item != null)
            System.out.println("Pago: " + item.pagoRenta(dias));
    }

    private static void submenu(int id) {
         RentItem item = search(id);
         if(item instanceof MenuActions){
             MenuActions ma = (MenuActions)item;
             ma.submenu();
             System.out.println("Escoja Opcion: ");
             ma.ejecutarOpcion(lea.nextInt());
         }
    }

    private static void listAll() {
        System.out.println("ITEMS\n-----------");
        for(RentItem item : items)
            System.out.println("-"+item);
    }

}
