/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package errores;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Docente 17082011
 */
public class TraiCatch {
    public static void main(String[] args) {
        System.out.println("Ejecutando main...");
        A();
        System.out.println("Finalizando a main...");
    }

    private static void A() {
        System.out.println("Ejecutando a A...");
        try{
            B();
            System.out.println("Mas Cosas!");
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Ingresar una coordenada correcta");
        }
        catch(InputMismatchException e){
            System.out.println("Ingrese un valor valido");
            //throw e;
        }
        catch(ArithmeticException e){
            System.out.println("No se puede dividir entre cero");
        }
        catch(Exception e){
            System.out.print("Error: " + e.getMessage() + " en: ");
            //e.printStackTrace();
            System.out.println(e.getStackTrace()[0].toString());
        }
        finally{
            System.out.println("Se corrio finally");
            closeConnection();
        }
        
        System.out.println("Finalizando a A....");
    }

    private static void B() {
        System.out.println("Ejecutando a B");
        Scanner lea = new Scanner(System.in);//null;
        int n = lea.nextInt();
        ArrayTest(n);
        int x = 10/n;
        //int arr[] = {1,2,4};
        //System.out.println("Pos: " + arr[x]);
        System.out.println("Finalizando B");
    }

    private static void closeConnection() {
        System.out.println("Cerrando la conexion al Mars Rovers");
        System.out.println("Limpiando memoria");
    }
    
    private static void ArrayTest(int pos){
        ArrayList<String> cads = new ArrayList<>();
        cads.add("HOLA");
        System.out.println(cads.get(pos));
    }

}
