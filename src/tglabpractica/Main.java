/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tglabpractica;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author KenyStev
 */
public class Main {
    static ArrayList<Loan> loans = new ArrayList<>();
    static Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) {
        int opt=0;
        
        do{
            try{
                System.out.printf("%s\n%s\n%s\n%s\n",
                        "1. Agregar Prestamo",
                        "2. Pagar Cuota",
                        "3. Ver Informacion de Prastamo",
                        "4. Salir");
                
                System.out.print("Ingrese opcion: ");
                opt = scan.nextInt();
                String name;
                
                switch(opt){
                    case 1:
                        System.out.print("Ingrese el Nombre");
                        name = scan.next();
                        System.out.println("Ingrese Monto y cantidad de Cuaotas");
                        loans.add(new Loan(name, scan.nextDouble(), scan.nextInt()));
                        break;
                    case 2: 
                        System.out.print("Ingrese el Nombre del Cliente: ");
                        payCuota(scan.next());
                        break;
                    case 3: 
                        System.out.print("Ingrese el Nombre del Cliente: ");
                        infoLoans(scan.next());
                        break;
                }
            }
            catch(LoanInvalidException e){
                System.out.println("No se Puede validar el Prestamo!");
                System.out.println("Error: "+e.getMessage());
            }
            catch(AlreadyPaidException e){
                System.out.println("Error: "+e.getMessage());
            }
            catch(Exception e){
                System.out.println("Error: "+e.getMessage());
            }
        }while(opt!=4);
        
    }
    
    static int showLoans(String name){
        int pres=0;
        for (int i = 0; i<loans.size(); i++) {
            if(loans.get(i).equals(name)){
                System.out.println(i+". "+loans.get(i).toString());
                pres++;
            }
        }
        return pres;
    }

    static void payCuota(String name) {
        if(showLoans(name)>0){
            System.out.print("Cual cuota quiere pagar?: ");
            int pay = scan.nextInt();
            loans.get(pay).pay();
        }else
            System.out.println("CLIENTE NO TIENE PRESTAMOS");
    }
    
    static void infoLoans(String name){
        if(showLoans(name)>0){
            System.out.print("Cual cuota quiere ver?: ");
            int see = scan.nextInt();
            loans.get(see).print();
        }else
            System.out.println("CLIENTE NO TIENE PRESTAMOS");
    }
    
}
