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
    static ArrayList<Plan> planes;
    static Scanner lea = new Scanner(System.in);
            
    public static void main(String[] args) {
        planes = new ArrayList<>();
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
        int op;
        do{
            System.out.println("1- Agregar un nuevo Plan");
            System.out.println("2- Cobrar un Plan");
            System.out.println("3- Listar los planes");
            System.out.println("4- Set ItUnesAccount");
            System.out.println("5- Agregar BB Friend");
            System.out.println("6- Agregar Tarjeta");
            System.out.println("7- Salir");
            System.out.println("Escoja opcion: ");
            op = lea.nextInt();
            
            switch(op){
                case 1:
                    System.out.println("Numero: ");
                    int n = lea.nextInt();
                    System.out.println("Cliente: ");
                    String c = lea.next();
                    System.out.println("Tipo: ");
                    String t = lea.next();
                    
                    if( addPlan(n, c, t))
                        System.out.println("Se agrego Exitoso");
                    else
                        System.out.println("No se pudo agregar");
                    break;
                case 2:
                    System.out.println("Numero: ");
                    n = lea.nextInt();
                    System.out.println("Minutos: ");
                    int mins = lea.nextInt();
                    System.out.println("Mensaje: ");
                    int msgs = lea.nextInt();
                    charge(n, mins, msgs);
                    break;
                case 3:
                    listPlans();
                    break;
                case 4:
                    System.out.println("Numero: ");
                    n = lea.nextInt();
                    System.out.println("Itunes: ");
                    String it = lea.next();
                    setItunes(n, it);
                    break;
                case 5:
                    System.out.println("Numero: ");
                    n = lea.nextInt();
                    System.out.println("Pin de Amigo: ");
                    String pin = lea.next();
                    addBBFriend(n, pin);
                    break;
                case 6:
                    System.out.println("Numero: ");
                    n = lea.nextInt();
                    System.out.println("Tipo [50,100,500]: ");
                    int tc = lea.nextInt();
                    setCard(n, tc);
                    break;
            }
        }while(op!=7);
    }
    
    public static Plan search(int n){
        for(Plan p : planes){
            if( p.getNumero() == n)
                return p;
        }
        return null;
    }
    
    public static Plan searchConContains(int n){
        int index = planes.indexOf(new Plan(n,"",0));
        if (index != -1)
            return planes.get(index);
        return null;
    }
    
    public static boolean addPlan(int n,String c,String t){
        if( search(n) == null ){
            switch(t.toLowerCase()){
                case "iphone":
                    planes.add(new PlanIphone(n, c));
                    return true;
                case "prepago":
                    planes.add(new PlanPrePago(n, c));
                    return true;
                case "blackberry":
                    System.out.println("Pin: ");
                    planes.add(new PlanBlackberry(n, c, lea.next()));
                    return true;
                default:
                    System.out.println("Plan Incorrecto");
            }
        }
        return false;
    }
    
    public static void charge(int n, int mins, int msgs){
        Plan p = search(n);
        if( p != null ){
            System.out.println("Pagar: " + p.calcularPago(mins, msgs));
        }
        else{
            System.out.println("No existe ese Plan");
        }
    }
    
    public static void listPlans(){
        System.out.println("LISTADO DE PLANES\n--------------");
        listPlans(0);
    }

    private static void listPlans(int i) {
        if( i < planes.size() ){
            System.out.println("-"+planes.get(i));
            listPlans(i+1);
        }
    }
    
    public static void setItunes(int n, String it){
        Plan p = search(n);
        if( p instanceof PlanIphone ){
            ((PlanIphone)p).setiTunesAccount(it);
        }
        else{
            System.out.println("No existe ese Plan o no es de Iphone");
        }
    }
    
    public static void addBBFriend(int n, String pin){
        Plan p = search(n);
        if( p instanceof PlanBlackberry ){
            ((PlanBlackberry)p).addFriend(pin);
        }
        else{
            System.out.println("No existe ese Plan o no es de BB");
        }
    }
    
    public static void setCard(int n, int t){
        Plan p = search(n);
        if( p instanceof PlanPrePago ){
            ((PlanPrePago)p).setCard(t);
        }
        else{
            System.out.println("No existe ese Plan o no es de PrePago");
        }
    }
    
    
}
