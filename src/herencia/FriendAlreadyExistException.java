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
public class FriendAlreadyExistException extends Exception {
    public FriendAlreadyExistException(String friend){
        super(friend + " already exist");
    }
}
