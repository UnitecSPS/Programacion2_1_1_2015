/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package herencia;

import java.util.Scanner;

/**
 *
 * @author Docente 17082011
 */
public class TestEnum {
    public static void main(String[] args) {
        
        System.out.println(OldTypes.KYOCERA.test());
        System.out.println(OldTypes.MOTOROLA.test());
        System.out.println(OldTypeClass.NOKIA.test());
        OldTypes.KYOCERA.patito();
        
        PlanType type = PlanType.PREPAGO; 
        
        System.out.println("Name: "+type.name()+ " ordinal: "+
                type.ordinal());
        
        //SI lo ingreso del teclado?
        Scanner lea = new Scanner(System.in);
        type = PlanType.valueOf( lea.next().toUpperCase());
        System.out.println("Name: "+type.name()+ " ordinal: "+
                type.ordinal());
        
        int ordi = lea.nextInt();
        for(PlanType typ : PlanType.values()){
            if(ordi == typ.ordinal()){
                System.out.println("Se selecciono Name: "+type.name()+ " ordinal: "+
                    type.ordinal());
            }
        }
        
        //y si yo lo quiero comparar?
        if(type == PlanType.IPHONE){
            System.out.println("Si es Iphone!");
        }
        
        switch(type){
            case IPHONE:
                System.out.println("Con Switch es Iphone");
                break;
            case BLACKBERRY:
                 System.out.println("Con Switch es bb");
                break;
            case PREPAGO:
                 System.out.println("Con Switch es pp");
                break;
        }
        
        if(type.equals(PlanType.IPHONE)){
            System.out.println("Si es Iphone!");
        }
        
    }
}
