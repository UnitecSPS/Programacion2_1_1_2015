/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pautas.examen1;

import java.util.ArrayList;

/**
 *
 * @author Docente 17082011
 */
public abstract class SocialClass {
    protected ArrayList<String> friends;
    protected ArrayList<String> posts; 
    protected String username;
    
    public SocialClass(String u){
        username = u;
        friends = new ArrayList<>();
        posts = new ArrayList<>();
    }
    
    public boolean addFriend(String u){
        if(!friends.contains(u) && !username.equals(u)){
            friends.add(u);
            return true;
        }
        return false;
    }
    
    public void addPost(String msg){
        posts.add(msg);
    }
    
    public abstract void timeline();
}
