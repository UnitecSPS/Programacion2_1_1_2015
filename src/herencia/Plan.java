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
    public Plan(){
        this(-1,"patito",0);
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

    @Override
    public String toString() {
        return "Plan{" + "numero=" + numero + ", precio=" + precio + ", cliente=" + cliente + '}';
    }
    
    
}
