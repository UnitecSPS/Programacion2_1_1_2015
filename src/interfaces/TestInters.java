/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaces;

/**
 *
 * @author Docente 17082011
 */
public class TestInters {
    public static void main(String[] args) throws CloneNotSupportedException {
        Pugin p = new Pugin("Hola");
        Pugin b = (Pugin)p.clone();
        b.test = "Otra Cosa";
        System.out.println("p: " + p.test);
        System.out.println("p: " + b.test);
    }
}
