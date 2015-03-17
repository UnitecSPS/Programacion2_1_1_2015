/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package memoria;

/**
 *
 * @author Docente 17082011
 */
public class FundamentoBasico {
    public static void main(String[] args) {
        Nodo a = new Nodo("Dennis");
        Nodo b = a;
        
        b.name = "Kevin";
        
        if( a == b )
            System.out.println("Estan en el mismo espacio!");
     
        System.out.println(a);
        System.out.println(b);
        
        String ca = "hola";
        String cb = new String("hola");
        
        if( ca == cb )
            System.out.println("Son iguales!");
        
    
    }
}
