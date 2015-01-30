package TrabajoGrupo1Lab;


import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kenystev
 */
public class main {
    public static void main(String[] args) {
        PalindromoAir pal = new PalindromoAir();
        Scanner scan = new Scanner(System.in);
        
        while(true){
            System.out.printf("\n%s\n%s\n%s\n%s\n%s\n\n",
                    "1. Sellticket",
                    "2. CancelTicket",
                    "3. PrintPassengers",
                    "4. dispatch",
                    "5. salir");
            System.out.print("Escoja su opcion: ");
            int resp = scan.nextInt();
            switch(resp){
                case 1:
                    System.out.print("Ingrese el nombre: ");
                    pal.sellTicket(scan.next());
                    break;
                case 2:
                    System.out.print("Ingrese el nombre: ");
                    pal.cancelTicket(scan.next());
                    break;
                case 3: pal.printPassengers(); break;
                case 4: pal.dispatch(); break;
                case 5: System.exit(0);
            }
            
        }
    }
}
