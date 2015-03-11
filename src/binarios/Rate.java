/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package binarios;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Docente 17082011
 */
public enum Rate {
    EVERYONE(0), PG(6), PG13(13), TEEN(15), MATURE(18);
    int min_age;
    Rate(int ma){
        min_age = ma;
    }
    
    public boolean canIDownload(Date d){
        Calendar c = Calendar.getInstance();
        Calendar nac = Calendar.getInstance();
        nac.setTime(d);
        int ac = nac.get(Calendar.YEAR);
        int aa = c.get(Calendar.YEAR);
        return (aa-ac) >= min_age;
    }
}
