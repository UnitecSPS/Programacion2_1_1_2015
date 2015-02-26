/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pruebas;

import java.util.Scanner;

/**
 *
 * @author Docente 17082011
 */
public class HedmanAlas {
    static Bus hedman = new Bus();
    static Scanner lea = new Scanner(System.in);
    
    public static void main(String[] args) {
        vender();
    }

    private static void vender() {
        try{
            String name = lea.next();
            int f = lea.nextInt();
            int a = lea.nextInt();
            
            hedman.venderAsiento(new Pasajero(name), f, a);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Asiento No Valido");
        }
        catch(SeatNotAvailableException e){
            System.out.println(e.getMessage());
        }
        catch(Exception e){
            System.out.println("Error: " + e);
        }
    }
}
