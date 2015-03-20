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
public class DoubleLinkedList {
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
            obj.before = tmp;
        }
    }
    
    public void print(){
        Nodo tmp = root;
        Nodo bef = root;
        while(tmp!=null){
            System.out.println(tmp);
            bef = tmp;
            tmp = tmp.next;
        }
        System.out.println("-----------\nReverso\n-----------");
        while(bef!=null){
            System.out.println(bef);
            bef = bef.before;
        }
    }
    
    public boolean contains(String name){
        return get(name) != null;
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
                root.before=null;
                return true;
            }else{
                Nodo tmp = root;
                while(tmp.next!=null){
                    if(tmp.next.name.equals(name)){
                        tmp.next = tmp.next.next;
                        
                        //por si se elimina el ultimo elemento
                        if(tmp.next!=null)
                            tmp.next.before = tmp;
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
    
    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();
        list.add(new Nodo("Keny"));
        list.add(new Nodo("Stev"));
        list.add(new Nodo("Rony"));
        list.add(new Nodo("Mary"));
        list.add(new Nodo("Konami"));
        list.add(new Nodo("Rocky"));
        
        list.print();
        
        list.remove("Keny");
        list.remove("Mary");
        list.remove("Rocky");
        
        System.out.println("\n\n\n Removed\n\n\n");
        list.print();
    }
    
}
