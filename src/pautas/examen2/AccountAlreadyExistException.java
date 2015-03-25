/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pautas.examen2;

/**
 *
 * @author Docente 17082011
 */
public class AccountAlreadyExistException extends Exception{
    public AccountAlreadyExistException(int cod){
        super("Cuenta "+cod+" ya esta agregada en el sistema");
    }
}
