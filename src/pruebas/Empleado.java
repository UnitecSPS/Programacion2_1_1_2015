/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pruebas;

import java.util.Date;

/**
 *
 * @author Docente 17082011
 */
public class Empleado {
    protected int codigo;
    protected String nombre;
    protected Date fecha;
    
    public Empleado(int c, String n){
        codigo = c;
        nombre = n;
        fecha = new Date();
    }
    
    @Override
    public String toString(){
        return codigo+"-"+nombre+"-"+fecha;
    }
}
