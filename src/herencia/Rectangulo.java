/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package herencia;

import shapes.DrawRectangle;

/**
 *
 * @author Docente 17082011
 */
public class Rectangulo extends Figura {
    public Rectangulo(){
        super("Rectangulo");
    }

    @Override
    public void dibujar() {
        new DrawRectangle().geo_rect();
    }
    
    
}
