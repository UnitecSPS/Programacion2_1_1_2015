/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tglabpractica;

/**
 *
 * @author KenyStev
 */
public interface Pagable {
    //Que sirve para determinar una lógica de pago.
    void pay() throws AlreadyPaidException;
    //Que debería retornar el monto aun por pagar.
    double balanceDue();
}
