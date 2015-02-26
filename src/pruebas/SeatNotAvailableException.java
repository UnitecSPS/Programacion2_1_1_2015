/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pruebas;

/**
 *
 * @author Docente 17082011
 */
class SeatNotAvailableException extends RuntimeException {

    public SeatNotAvailableException(int f, int a) {
        super("Asiento ["+f+"]["+a+"] no disponible");
    }
    
}
