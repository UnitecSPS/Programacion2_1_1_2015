/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tglabpractica;

import java.util.Calendar;

/**
 *
 * @author KenyStev
 */
public class Bill {
    private Calendar fechaDePago;
    private double monto;
    private boolean pagada;

    public Bill(Calendar fechaDePago, double monto) {
        this.fechaDePago = fechaDePago;
        this.monto = monto;
        this.pagada = false;
    }

    public Calendar getFechaDePago() {
        return fechaDePago;
    }

    public double getMonto() {
        return monto;
    }

    public boolean isPagada() {
        return pagada;
    }
    
    public void payThisBill(){
        pagada=true;
    }
}
