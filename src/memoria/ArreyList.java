/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package memoria;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

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
    
    public void print(){
        Nodo tmp = root;
        while(tmp!=null){
            System.out.println(tmp);
            tmp = tmp.next;
        }
    }
    
    public boolean contains(String name){
        Nodo tmp = root;
        while(tmp!=null){
            if(tmp.name.equals(name))
                return true;
            tmp = tmp.next;
        }
        return false;
    }
    
    public Nodo get(String name){
        Nodo tmp = root;
        while(tmp!=null){
            if(tmp.name.equals(name))
                return tmp;
            tmp = tmp.next;
        }
        return null;
    }
    
    public boolean remove(String name){
        if(!iSEmpty()){
            if(root.name.equals(name)){
                root = root.next;
                return true;
            }else{
                Nodo tmp = root;
                while(tmp.next!=null){
                    if(tmp.next.name.equals(name)){
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
        int size=0;
        Nodo tmp = root;
        while(tmp!=null){
            size++;
            tmp = tmp.next;
        }
        return size;
    }
    
    public Nodo[] toArray(){
        Nodo[] arr = new Nodo[size()];
        Nodo tmp=root;
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = tmp;
            tmp = tmp.next;
        }
        return arr;
    }
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /*ArrayList<String> lists = new ArrayList<>();
        lists.add("Keny");
        lists.add("Stev");
        lists.add("Konami");
        lists.add("Rom");
        lists.add("Rock");
        lists.add("Tiled");
        lists.add("Miyam");
        
        FileOutputStream fo = new FileOutputStream("Lista.tmp", false);
        ObjectOutputStream oo = new ObjectOutputStream(fo);
        
        FileInputStream fi = new FileInputStream("Lista.tmp");
        ObjectInputStream oi = new ObjectInputStream(fi);
        
        oo.writeObject(lists);
        
        ArrayList<String> liss = (ArrayList<String>)oi.readObject();
        System.out.println("\n");
        for (String lis : liss) {
            System.out.println(lis);
        }
        
        lists.add("Nada");
        lists.add("Nodismo");
        lists.add("Karaoke");
        
        fo = new FileOutputStream("Lista.tmp", false);
        oo = new ObjectOutputStream(fo);
        
        fi = new FileInputStream("Lista.tmp");
        oi = new ObjectInputStream(fi);
        
//        oo.writeUnshared(lists);
        oo.writeObject(lists);
        
        ArrayList<String> liss2 = (ArrayList<String>)oi.readObject();
        System.out.println("\n");
        for (String lis : liss2) {
            System.out.println(lis);
        }*/
        
        ArreyList lists = new ArreyList();
        lists.add(new Nodo("Keny"));
        lists.add(new Nodo("Stev"));
        lists.add(new Nodo("Konami"));
        lists.add(new Nodo("Rom"));
        lists.add(new Nodo("Rock"));
        lists.add(new Nodo("Tiled"));
        lists.add(new Nodo("Miyam"));
        
        for(Nodo n : lists.toArray()){
            System.out.println(n);
        }
    }
}
