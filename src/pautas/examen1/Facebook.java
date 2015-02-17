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
public class Facebook extends SocialClass implements iComment {
    private ArrayList<Comment> comments;
    
    public Facebook(String u){
        super(u);
        comments = new ArrayList<>();
    }

    @Override
    public boolean addComment(int postId, String msg) {
        if(postId >= 0 && postId < posts.size()){
            comments.add(new Comment(postId,msg));
            return true;
        }
        return false;
    }
    
    @Override
    public void timeline() {
        System.out.println(username);
        
        for(int p=0; p < posts.size(); p++){
            System.out.println(posts.get(p));
            for(Comment comment : comments ){
                if( comment.postId == p )
                    System.out.println("-"+comment);
            }
        }
    }

}
