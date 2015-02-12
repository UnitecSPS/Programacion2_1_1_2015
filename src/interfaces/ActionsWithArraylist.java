/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaces;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Docente 17082011
 */
public class ActionsWithArraylist implements ChaturangaActions {
    ArrayList<String> users = new ArrayList<>();
    
    @Override
    public boolean createUser(String u) {
        if(!users.contains(u)){
            users.add(u);
            return true;
        }
        return false;
    }

    @Override
    public String getUser(String u) {
        int pos = users.indexOf(u);
        if(pos>=0)
            return users.get(pos);
        return "";
    }

    @Override
    public void editUser(String old, String newval) {
        int pos = users.indexOf(old);
        if(pos>=0)
            users.set(pos, newval);
    }

    @Override
    public void print() {
        for(String u : users)
            System.out.println("-"+u);
    }
    
}
