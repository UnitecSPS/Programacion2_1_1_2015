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
public enum OldTypes {
    NOKIA(1996){
        void patito(){
            System.out.println("TOC TOC");
        }
    }, KYOCERA(2001){
        void patito(){
            System.out.println("KIK KIK");
        }
    }, MOTOROLA(1998){
        void patito(){
            System.out.println("HELLO MOTO!");
        }
    };
    int year;
    
    OldTypes(int y){
        year = y;
    }
    
    public String test(){
        return "Soy un "+this.name()+ " y soy del "+ year;
    }
    
    abstract void patito();
}
