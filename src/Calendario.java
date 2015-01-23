
import java.util.Calendar;
import java.util.Locale;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Docente 17082011
 */
public class Calendario {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
       
        //customizar una fecha
        c.set(1982, Calendar.AUGUST, 10);
        System.out.println(c.getTime());
        //jalar una informacion especifica
        System.out.println("Cuando naci: " + c.get(Calendar.MONTH));
        c.add(Calendar.YEAR, 1);
        System.out.println(c.getTime());
        c.add(Calendar.MONTH,6);
        System.out.println(c.getTime());
        System.out.println("c = " + 
                c.getDisplayName(Calendar.DAY_OF_WEEK, 
                        Calendar.LONG, 
                        Locale.ENGLISH));
    }
}
