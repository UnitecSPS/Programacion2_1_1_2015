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
public class Plan {
    protected int numero;
    protected double precio;
    protected String cliente;
    
    public Plan(int n, String c, double p){
        numero = n;
        precio = p;
        cliente = c;
    }

    public int getNumero() {
        return numero;
    }

    public double getPrecio() {
        return precio;
    }

    public String getCliente() {
        return cliente;
    }
    
    public void quienSoy(){
        System.out.println("SOY EL PAPA! PLAN");
    }

    @Override
    public String toString() {
        return "numero=" + numero + ", precio=" + precio + ", cliente=" + cliente;
    }
    
    
}
