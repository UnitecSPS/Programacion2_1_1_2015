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
public class PlanIphone extends Plan {
    private String iTunesAccount;
    
    public PlanIphone(int n, String c){
        super(n,c,70);
        iTunesAccount = "";
    }

    public String getiTunesAccount() {
        return iTunesAccount;
    }

    public void setiTunesAccount(String iTunesAccount) {
        this.iTunesAccount = iTunesAccount;
    }

    @Override
    public void quienSoy() {
        System.out.println("SOY EL MAS FRESA DE TODOS, EL PLAN IPHONE");
    }
    
    @Override
    public String toString(){
        return "PlanIphone["+super.toString()+" iTunesAccount="+iTunesAccount+"]";
    } 
    
}
