/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaces;

import java.io.Serializable;

/**
 *
 * @author Docente 17082011
 */
public class Pugin implements Serializable, Cloneable {
    String test;
    
    public Pugin(String t){
        test = t;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone(); 
    }
    
    
}
