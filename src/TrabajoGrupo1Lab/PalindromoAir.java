package TrabajoGrupo1Lab;


import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kenystev
 */
public class PalindromoAir {
    private Ticket[] tickets = new Ticket[30];
    
    public int firstAvailable(){return firstAvailable(0);}
    
    private int firstAvailable(int index){
        if(index < tickets.length){
            if(tickets[index]==null) return index;
            return firstAvailable(index+1);
        }
        return -1;
    }
    
    public int searchPassenger(String name){return searchPassenger(name,0);}
    
    private int searchPassenger(String name, int index){
        if(index < tickets.length){
            if(tickets[index] != null && tickets[index].getName().equals(name))
                return index;
            return searchPassenger(name,index+1);
        }
        return -1;
    }
    
    public void printPassengers(){printPassengers(0);}
    
    private void printPassengers(int index){
        if(index<tickets.length){
            if(tickets[index]!=null)
                tickets[index].print();
            printPassengers(index+1);
        }
    }
    
    public double income(){return income(0);}
    
    private double income(int index){
        if(index < tickets.length){
            if(tickets[index] != null){
                return tickets[index].getPagado() + income(index+1);
            }
            return income(index+1);
        }
        return 0;
    }
    
    public boolean isPalindromo(String name){return isPalindromo(name, 0, name.length()-1);}
    
    private boolean isPalindromo(String name, int inicio, int fin){
        if(inicio<fin){
            if(name.charAt(inicio) == name.charAt(fin))
                return isPalindromo(name, inicio+1, fin-1);
            return false;
        }
        return true;
    }
    
    public void sellTicket(String name){
        int index = firstAvailable();
        if(index>=0){
            double price = isPalindromo(name)?(800 - (800*0.2)):800;
            tickets[index] = new Ticket(name, price);
            System.out.println("Monto a pagar: "+price);
        }
    }
    
    private void reset(int index){
        if(index < tickets.length){
            tickets[index]=null;
            reset(index+1);
        }
    }
    
    public void dispatch(){
        System.out.print("Ingreso generado: "+income());
        reset(0);
    }
    
    public boolean cancelTicket(String name){
        int index = searchPassenger(name);
        if(index>=0){
            tickets[index] = null;
            return true;
        }
        return false;
    }
}
