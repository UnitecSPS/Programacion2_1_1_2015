/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package memoria;

import java.io.Serializable;

/**
 *
 * @author Docente 17082011
 */
public class ArreyList implements Serializable {
    private Nodo root = null;
    
    public boolean iSEmpty(){
        return root == null;
    }
    
    public void clear(){
        root = null;
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
    
    public void print(){
        Nodo tmp = root;
        
        while(tmp != null){
            System.out.println(tmp);
            tmp = tmp.next;
        }
    }
    
    public boolean contains(String elemento){
        return get(elemento) != null;
    }
    
    public Nodo get(String elemento){
        Nodo tmp = root;
        while(tmp != null){
            if(tmp.name.equals(elemento))
                return tmp;
            tmp = tmp.next;
        }
        return null;
    }
    
    public boolean remove(String elemento){
        if(!iSEmpty()){
            if(root.name.equals(elemento)){
                root = root.next;
                return true;
            }else{
                Nodo tmp = root;
                while(tmp.next != null){
                    if(tmp.next.name.equals(elemento)){
                        tmp.next = tmp.next.next;
                        return true;
                    }
                    tmp = tmp.next;
                }
            }
        }
        return false;
    }
    
    public int size(){
        int cont=0;
        Nodo tmp = root;
        while(tmp != null){
            cont++;
            tmp = tmp.next;
        }
        return cont;
    }
    
    public boolean add(int index, Nodo obj){
        if(index == 0){
            obj.next = root;
            root = obj;
            return true;
        }
        else{
            Nodo tmp = root;
            int cont = 1;
            
            while(tmp != null){
                if(cont == index){
                    obj.next = tmp.next;
                    tmp.next = obj;
                    return true;
                }
                else{
                    cont++;
                    tmp = tmp.next;
                }
            }
        }
        
        return false;
    }
    
    public Nodo[] toArray(){
        Nodo arr[] = new Nodo[size()];
        Nodo tmp = root;
        for(int p=0; p < arr.length; p++){
            try{
                arr[p] = (Nodo) tmp.clone();
            }
            catch(CloneNotSupportedException e){
                arr[p] = null;
            }
            tmp = tmp.next;
        }
        return arr;
    }
}
