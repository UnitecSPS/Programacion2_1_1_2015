
import java.util.ArrayList;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Docente 17082011
 */
public class ArreglosDinamicos {
    public static void main(String[] args) {
        ArrayList<Date> fechas = new ArrayList<>();
        ArrayList<String> cadenas = new ArrayList<>();
        
        //agrego valores
        //arreglo[pos] = expr;
        fechas.add(new Date(122334));
        Date d = new Date();
        
        fechas.add(d);
        cadenas.add("Hola");
        cadenas.add(0,"Mundo");
        //recorro un arraylist
        for(int c=0; c < fechas.size(); c++){
            //arreglo[pos]
            System.out.println("Fecha: " + fechas.get(c));
        }
        
        for(String cad : cadenas){
            System.out.println(cad);
        }
        
        //remover un elemento
        fechas.remove(d);
        for(Date fe : fechas){
            System.out.println(fe);
        }
        cadenas.remove(0);
        for(String cad : cadenas){
            System.out.println(cad);
        }
        
        //busquedas
        if(cadenas.contains("Hola"))
            System.out.println("La tiene!");
        System.out.println("indice de Hola: " + cadenas.indexOf("Hola"));
        
        //Set
        cadenas.set(0, "Mundo");
        for(String cad : cadenas){
            System.out.println(cad);
        }
        
        //Arraylist con tipos primitivos
        /*
            int -> Integer
            double -> Double
            char -> Character
            boolean -> Boolean
        */
        ArrayList<Integer> numeros = new ArrayList<>();
        numeros.add(5);
        numeros.add(10);
        for(int x : numeros){
            System.out.println(x);
        }
        
    }
}
