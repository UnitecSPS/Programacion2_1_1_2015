/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TrabajoGrupoLab2;

import java.util.Calendar;

/**
 *
 * @author Docente 17082011
 */
public class Movie extends RentItem {
    private Calendar fecha;
    
    public Movie(int codigo, String nombre, double precio) {
        super(codigo, nombre, precio);
        fecha = Calendar.getInstance();
    }
    
    public String getEstado(){
        Calendar now = Calendar.getInstance();       
        now.add(Calendar.MONTH, -3);
        if( fecha.compareTo(now) >= 0 )
            return "ESTRENO";
        return "NORMAL";
    }

    @Override
    public String toString() {
        return super.toString()+" - " + getEstado()+ " - MOVIE"; 
    }

    @Override
    public double pagoRenta(int dias) {
        String est = getEstado();
        double recargo = 0;
        
        if(est.equals("ESTRENO") && dias > 2)
            recargo = (dias-2) * 50;
        else if(est.equals("NORMAL") && dias > 5)
            recargo = (dias-5) * 30;
        
        return precio+recargo;
    }
    
}
