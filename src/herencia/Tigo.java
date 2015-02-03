/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package herencia;

/**
 *
 * @author Docente 17082011
 */
public class Tigo {
    public static void main(String[] args) {
        //UPCASTINGS
        Plan pi = new PlanIphone();
        pi.numero  =2;
        System.out.println(pi);
        
        //FORMATO DE instanceof: variable instanceof CLASE
        if( pi instanceof PlanIphone )
            System.out.println("Si es Plan!");
    }
}
