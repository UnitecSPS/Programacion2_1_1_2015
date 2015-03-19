/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package memoria;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Docente 17082011
 */
public class Nodo implements Serializable, Cloneable{
    public String name;
    public Nodo next;

    public Nodo(String name) {
        this.name = name;
        next = null;
    }

    @Override
    public String toString() {
        return "Nodo{" + "name=" + name + '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
    
}
