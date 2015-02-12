/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaces;

import java.util.TreeSet;



/**
 *
 * @author Docente 17082011
 */
public class ActionsWithFiles implements ChaturangaActions {
   
    TreeSet<String> list= new TreeSet<String>();
    
    @Override
    public boolean createUser(String u) {
        list.add(u);
        return true;
    }

    @Override
    public String getUser(String u) {
        return list.last();
    }

    @Override
    public void editUser(String old, String newval) {
        System.out.println("Lo edite!");
    }

    @Override
    public void print() {
        for(String e : list){
            System.out.println("-"+e);
        }
    }
    
}
