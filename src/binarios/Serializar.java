/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package binarios;

import herencia.PlanIphone;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author Docente 17082011
 */
public class Serializar {
    public static void main(String[] args) throws IOException {
        FileOutputStream fo = new FileOutputStream("iphones.tigo");
        ObjectOutputStream oo = new ObjectOutputStream(fo);
        oo.writeObject(new PlanIphone(12, "Carlos"));
        oo.writeObject(new PlanIphone(33, "Dennis"));
        
       
    }
}
