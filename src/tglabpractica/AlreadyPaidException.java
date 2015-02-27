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
public class AlreadyPaidException extends RuntimeException{

    public AlreadyPaidException() {
        super("Pago ya realizado");
    }
}
