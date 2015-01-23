
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Docente 17082011
 */
public class Fechas {
    //atributos
    private int dia;
    //constructor
    
    public Fechas(int dia){
        this.dia = dia;
    }
    
    //funciones
    public int getDia(){
        return dia;
    }
    
    public static void main(String[] args) {
        Fechas f = new Fechas(5);
        f.getDia();
        
        //----------------------------------
        Date old = new Date(1) ;
        Date now = new Date();
        Date now2 = new Date();
        System.out.println(old);
        System.out.println("Mili: " + old.getTime());
        
        if( old.before(now) ){
            System.out.println("Old paso antes");
        }
        
        if( now.after(old)){
            System.out.println("Now paso despues de old");
        }
        
        if( now.getTime() >= now2.getTime() ){
            System.out.println("Paso el mismo dia o now paso despues");
        }
        
        System.out.println(old.compareTo(now)); //-1
        System.out.println(now.compareTo(now2));//0
        System.out.println(now.compareTo(old));//1
        
        long diff = now.getTime() - old.getTime();
        long seg = diff / 1000;
        long min = seg / 60;
        long hrs = min / 60;
        long dia = hrs / 24;
        long meses = dia / 30;
        long years = meses / 12;
        System.out.println("Ha pasado: " + years);
    }
}
