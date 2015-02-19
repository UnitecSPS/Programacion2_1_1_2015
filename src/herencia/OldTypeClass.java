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
public final class OldTypeClass {
    int year;
    private String name;
    public static final OldTypeClass MOTOROLA = new OldTypeClass(1998, 
            "MOTOROLA");
    public static final OldTypeClass NOKIA = new OldTypeClass(1996,
        "NOKIA");
    public static final OldTypeClass KYOCERA = new OldTypeClass(2001,
        "KYOCERA");
    
    public OldTypeClass(int y, String nam){
        year = y;
        name = nam;
    }
    
    public String test(){
        return "Soy un "+this.name+ " y soy del "+ year;
    }
}
