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
public class Triangulo extends Figura {

    public Triangulo() {
        super("Triangulo");
    }

    @Override
    public void dibujar() {
        for(int x=1;x<=5;x++){
            for(int y=1; y <= x; y++){
                System.out.print("*");
            }
            System.out.println("");
        }
    }
    
}
