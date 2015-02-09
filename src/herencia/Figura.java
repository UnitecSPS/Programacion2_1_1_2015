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
public abstract class Figura {
    protected String nombre;
    
    public Figura(String n){
        nombre = n;
    }

    public String getNombre() {
        return nombre;
    }
    
    public abstract void dibujar();
}
