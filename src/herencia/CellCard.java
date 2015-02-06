
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package herencia;

import java.util.Calendar;

/**
 *
 * @author Docente 17082011
 */
public abstract class CellCard {
    public Calendar expiracion;
    public double saldo;
    
    public CellCard(double s){
        saldo = s;
        expiracion = Calendar.getInstance();
        expiracion.add(Calendar.DATE, 30);
    }
    
    public boolean isValid(){
        return saldo > 0 && Calendar.getInstance().before(expiracion);
    }
    
    public void addSaldo(double s){
        saldo += s;
        expiracion.add(Calendar.DATE, 30);
    }
    
    public void addSaldoByCard(CellCard cc){
        addSaldo(cc.saldo);
    }
    
    public void decreaseSaldo(double s){
        if( saldo > s && s > 0)
            saldo -= s; 
    }

    @Override
    public String toString() {
        return "CellCard{" + "expiracion=" + expiracion + ", saldo=" + saldo + '}';
    }
    
    
}
