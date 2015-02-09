/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package herencia;

import java.util.ArrayList;

/**
 *
 * @author Docente 17082011
 */
public class Tigo {
    public static void main(String[] args) {
        //UPCASTINGS
        Plan pi = new PlanIphone(995,"Dennis");
        
        if(pi.equals(995))
            System.out.println("Si es cierto equals!");
        if(pi.equals(new Plan(996,"",0))){
            System.out.println("Si es cierto equals!");
        }
        
        //FORMATO DE instanceof: variable instanceof CLASE
        if( pi instanceof PlanIphone ){
            System.out.println("Si es Plan Iphone!");
            //DOWNCASTING
            //INDIRECTO---
            PlanIphone ip = (PlanIphone)pi;
            ip.setiTunesAccount("gotcha@ios.com");
            //DIRECTO---
            ((PlanIphone)pi).setiTunesAccount("gotcha@hotmail.com");
        }
        
        //Colecciones de Plan
        ArrayList<Plan> planes = new ArrayList<>();
        planes.add(pi);
        planes.add(new PlanBlackberry(9998, "Carlos", "PCD6520"));
        planes.add(new Plan(9999, "Ricardo", 20));
        
        for(Plan p : planes){
            p.quienSoy();
            System.out.println(p);
            double pago = p.calcularPago(400, 800);
            System.out.println("Pago: " + pago);
        }
        
        if(planes.contains(9998)){
            
        }
        
    }
}
