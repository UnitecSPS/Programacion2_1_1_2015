/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package herencia;

import shapes.DrawCircle;

/**
 *
 * @author Docente 17082011
 */
public class Circulo extends Figura {

    public Circulo(){
        super("circulo");
    }

    @Override
    public void dibujar() {
        new DrawCircle().geo_circle();
    }
}
