/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package memoria;

/**
 *
 * @author Docente 17082011
 */
public class ArreyList {
    private Nodo root = null;
    
    public boolean iSEmpty(){
        return root == null;
    }
    
    public void add(Nodo obj){
        if( iSEmpty() ){
            root = obj;
        }
        else{
            Nodo tmp = root;
            while(tmp.next != null){
                tmp = tmp.next;
            }
            tmp.next = obj;
        }
    }
}
