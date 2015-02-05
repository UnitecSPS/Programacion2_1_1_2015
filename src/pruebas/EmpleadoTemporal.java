/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pruebas;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Docente 17082011
 */
public class EmpleadoTemporal extends Empleado {
    private Date fechaFin;
    
    public EmpleadoTemporal(int c, String n){
        super(c,n);
        fechaFin = new Date();
    }
    
    @Override
    public String toString(){
        return super.toString() + "-" + fechaFin;
    }
    
    public void setFechaFin(int y, int d, int m){
        Calendar c = Calendar.getInstance();
        c.set(y, m, d);
        if( c.getTime().after(fecha) )
            fechaFin = c.getTime();
    }
}
