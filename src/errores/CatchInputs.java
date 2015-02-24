/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package errores;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Docente 17082011
 */
public class CatchInputs {
    public static void main(String[] args) {
        Scanner lea = new Scanner(System.in);
        lea.useDelimiter("\n");
        
        do{
            try{
                int x = lea.nextInt();
                System.out.println(x);
                break;
            }
            catch(InputMismatchException e){
                System.out.println("Ingrese un entero");
                lea.next();
            }
        }while(true);
    }
}
