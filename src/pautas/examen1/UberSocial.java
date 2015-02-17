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
public class UberSocial {
    ArrayList<SocialClass> redes = new ArrayList<>();
    
    private SocialClass search(String u) {
        return search(u,0);
    }
     
    public SocialClass search(String u,int pos){
        if( pos < redes.size()){
            if( redes.get(pos).username.equals(u) ){
                return redes.get(pos);
            }
            return search(u,pos+1);
        }
        return null;
    }
    
    public void agregarCuenta(String u, String tipo){
       if( search(u) == null ){
           if(tipo.equals("FACEBOOK"))
               redes.add(new Facebook(u));
           else if(tipo.equals("TWITTER"))
               redes.add(new Twitter(u));
       }
    }
    
    public void agregarAmigo(String u1, String u2){

        SocialClass user1 = search(u1);
        SocialClass user2 = search(u2);
        
        if(user1 instanceof Facebook && user2 instanceof Facebook){
            user1.addFriend(u2);
            user2.addFriend(u1);
        }
        else if(user1 instanceof Twitter && user2 instanceof Twitter){
            user1.addFriend(u2);
        }
    }

    public void agregarComentario(String u, int pi, String c){
        SocialClass user = search(u);
        if(user instanceof iComment)
            ((iComment)user).addComment(pi, c);
       
    }
    
    public void agregarPost(String u, String post){
     
        SocialClass user = search(u);
        if( user != null){
            user.addPost(post);
        }
    }
   
}
