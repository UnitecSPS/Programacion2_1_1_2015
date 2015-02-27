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
public class LoanInvalidException extends Exception{

    public LoanInvalidException(double monto) {
        super("El préstamo por ["+monto+"]no es aceptado");
    }
}
