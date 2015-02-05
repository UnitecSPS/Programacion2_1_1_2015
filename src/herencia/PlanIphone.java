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
    public double calcularPago(int mins, int msgs){
        double m=0;
        if(mins > 500)
            m += (mins-500)*0.8;
        if(msgs > 1000)
            m += (msgs-1000) * 0.01;
        return precio + m+ 20;
    }

    @Override
    public void quienSoy() {
        System.out.println("SOY EL MAS FRESA DE TODOS, EL PLAN IPHONE");
    }
    
    @Override
    public String toString(){
        return "PlanIphone["+super.toString()+", iTunesAccount="+iTunesAccount+"]";
    } 
    
}
