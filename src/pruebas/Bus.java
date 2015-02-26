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
public class Bus {
    private Pasajero asientos[][];
    
    public void venderAsiento(Pasajero p, int f, int a){
        if(asientos[f][a] == null){
            asientos[f][a] = p;
        }
        else{
            throw new SeatNotAvailableException(f,a);
        }
    }
}
