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
public class TestLista {
    public static void main(String[] args) {
        ArreyList list = new ArreyList();
        
        list.add(new Nodo("Dennis"));
        list.add(new Nodo("Carlos"));
        list.add(new Nodo("Ricardo"));
        list.add(new Nodo("Kevin"));
        list.add(new Nodo("Bladimir"));
        list.add(new Nodo("Eduardo"));
        
        list.print();
        
        //eliminar la raiz
        list.remove("Dennis");
        //eliminar enmedio
        list.remove("Ricardo");
        //eliminar cola
        list.remove("Eduardo");
        //uno que no existe
        list.remove("Gochez");
        
        System.out.println("\nDESPUES DE LOS REMOVES\n-------");
        list.print();
        System.out.println("Size: " + list.size());
        
        if( list.contains("Carlos"))
            System.out.println("Si esta Carlos");
        if(!list.contains("Dennis"))
            System.out.println("Si, ya no esta Dennis");
        
        list.add(0, new Nodo("Leo Messi"));
        list.add(2,new Nodo("Neymar"));
        list.add(100,new Nodo("CR7"));
        System.out.println("\nDESPUES DE LOS ADDS con Index\n-------");
        list.print();
        
        Nodo arr[ ] = list.toArray();
        arr[0].next.name = "LIONEL MESSI";
        System.out.println("\nDESPUES DEL toArray\n-------");
        list.print();
        System.out.println("\nAhora toArray\n-------");
        for(Nodo n : arr){
            System.out.println(n);
        }
    }
}
