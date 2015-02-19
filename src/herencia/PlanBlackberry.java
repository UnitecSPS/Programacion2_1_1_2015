/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package herencia;

import java.util.ArrayList;

/**
 *
 * @author Docente 17082011
 */
public final class PlanBlackberry extends Plan {
    ArrayList<String> amigos;
    private String pin;
    
    public PlanBlackberry(int n, String c, String p) {
        super(n, c, 40);
        pin = p;
        amigos = new ArrayList<>();
    }

    public String getPin() {
        return pin;
    }
    
    public void addFriend(String pin){
        if(!amigos.contains(pin)){
            amigos.add(pin);
            System.out.println("\n Friends added:");
            listFriends();
        }
    }
    
    private void listFriends(){
        for(String f : amigos)
            System.out.println("-"+f);
    }
    
    @Override
    public double calcularPago(int mins, int msgs){
        return precio + (mins * 0.05) + (msgs * 0.01);
    }
    
    @Override
    public void quienSoy() {
        System.out.println("SOY EL FOREVER ALONE, EL PLAN BB");
    }
    
    @Override
    public String toString(){
        return "PlanBB["+super.toString()+", pin="+pin+"]";
    } 
}
