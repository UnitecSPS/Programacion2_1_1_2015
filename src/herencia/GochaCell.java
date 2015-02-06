/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package herencia;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Docente 17082011
 */
public class GochaCell {
    //SE TIENE que tener una coleccion ESTATICA de Plan
    static ArrayList<Plan> planes = new ArrayList<>();
    static Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) {
        /*
            MENU PARA:
               1- Agregar un nuevo Plan (Validen que el numero sea unico)
               2- Cobrar un Plan especifico
               3- Listar los planes (Recursiva)
               4- Set ItUnesAccount (SOLO para IPhones)
               5- Agregar BB Friend (SOLO para BBs)
               6- Agregar Tarjeta (SOLO para PrePagos)
        
        
               ES NECESARIO HACER UNA FUNCION DE BUSCAR
        */
        
        while(true){
            System.out.print(
               "\n\n1- Agregar un nuevo Plan (Validen que el numero sea unico)\n" +
                "2- Cobrar un Plan especifico\n" +
                "3- Listar los planes (Recursiva)\n" +
                "4- Set ItUnesAccount (SOLO para IPhones)\n" +
                "5- Agregar BB Friend (SOLO para BBs)\n" +
                "6- Agregar Tarjeta (SOLO para PrePagos)\n"
                    + "Escoja su opcion: ");
            int opt = scan.nextInt(), num=0;
            
            if(opt==0) System.exit(opt);
            
            if(opt!=3){
                System.out.print("Ingrese el Numero: ");
                num = scan.nextInt();
            }
            
            switch(opt){
                case 1:
                    System.out.print("Ingrese su Nombre: ");
                    String name = scan.next();
                    addPlan(num, name); break;
                case 2: 
                    cobrarPlan(search(num)); break;
                case 3: listPlans(0); break;
                case 4: setItunesAccount(search(num)); break;
                case 5: addBBfriend(search(num)); break;
                case 6: addCell(search(num)); break;
            }
        }
    }
    
    public static Plan search(int n){
        for (Plan plan : planes) {
            if(plan.validarNumer(n))
                return plan;
        }
        return null;
    }

    public static void addPlan(int num, String name) {
        if(search(num)==null){
            System.out.print("Ingrese el Nombre del Plan (Iphone / BB / PrePago): ");
            String namePlan = scan.next().toLowerCase();
            
            switch(namePlan){
                case "iphone":
                    planes.add(new PlanIphone(num, name));
                    break;
                case "bb":
                    System.out.print("Ingrese el BBPin");
                    String pin = scan.next();
                    planes.add(new PlanBlackberry(num, name, pin));
                    break;
                case "prepago":
                    planes.add(new PlanPrePago(num, name));
                    break;
                default:
                    System.out.println("Plan no Valido!");
            }
        }else{
            System.out.println("Y existe un Plan con ese numero!");
        }
    }

    private static void cobrarPlan(Plan plan) {
        if(plan!=null){
            System.out.print("Ingrese Mins y Msjs separados por un espacio: ");
            int mins = scan.nextInt(), msjs = scan.nextInt();
            
            System.out.println("Cobrado al numero: "+ plan.getNumero()+" un monto de: "+plan.calcularPago(mins, msjs));
        }
    }

    private static void listPlans(int i) {
        if(i<planes.size()){
            System.out.println(planes.get(i));
            listPlans(i+1);
        }
    }

    private static void setItunesAccount(Plan p) {
        if(p instanceof PlanIphone){
            System.out.print("Ingrese su ItunesAccount: ");
            String ia = scan.next();
            ((PlanIphone)p).setiTunesAccount(ia);
        }else{
            System.out.println("El Plan no existe o no es de tipo: PlanIphone!");
        }
            
    }

    private static void addBBfriend(Plan p) {
        if(p instanceof PlanBlackberry){
            System.out.print("Ingrese bbpin: ");
            String pin = scan.next();
            ((PlanBlackberry)p).addFriend(pin);
        }else{
            System.out.println("El Plan no existe o no es de tipo: PlanBackberry");
        }
    }

    private static void addCell(Plan p) {
        if(p instanceof PlanPrePago){
            System.out.print("Ingrese el monto de la tarjeta: ");
            ((PlanPrePago)p).setCard(scan.nextInt());
        }else{
            System.out.println("El Plan no existe o no es de tipo Prepago");
        }
    }
}
