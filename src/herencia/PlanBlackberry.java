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
public class PlanBlackberry extends Plan {

    public PlanBlackberry(int n, String c) {
        super(n, c, 60);
    }
    
    @Override
    public void quienSoy() {
        System.out.println("SOY EL FOREVER ALONE, EL PLAN BB");
    }
    
    @Override
    public String toString(){
        return "PlanBB["+super.toString()+"]";
    } 
}
