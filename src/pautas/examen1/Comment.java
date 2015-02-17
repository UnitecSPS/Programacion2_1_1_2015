/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pautas.examen1;

/**
 *
 * @author Docente 17082011
 */
public class Comment {
    public int postId;
    public String msg;

    public Comment(int postId, String msg) {
        this.postId = postId;
        this.msg = msg;
    }
    
    @Override
    public String toString(){
        return msg;
    }
}
