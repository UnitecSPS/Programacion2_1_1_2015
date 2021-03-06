/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package herencia;

import java.io.Serializable;

/**
 *
 * @author Docente 17082011
 */
public class Plan implements Serializable {
    protected int numero;
    protected double precio;
    protected String cliente;
    
    public Plan(int n, String c, double p){
        numero = n;
        precio = p;
        cliente = c;
    }

    public final int getNumero() {
        return numero;
    }

    public final double getPrecio() {
        return precio;
    }

    public final String getCliente() {
        return cliente;
    }
    
    public void quienSoy(){
        System.out.println("SOY EL PAPA! PLAN");
    }
    
    public double calcularPago(int mins, int msgs){
        return precio;
    }

    @Override
    public String toString() {
        return "numero=" + numero + ", precio=" + precio + ", cliente=" + cliente;
    }
    
    @Override
    public boolean equals(Object val){
        if(val instanceof Integer)
            return (int)val == numero;
        if(val instanceof Plan)
            return ((Plan)val).getNumero() == numero;
        return false;
    }
    
}
