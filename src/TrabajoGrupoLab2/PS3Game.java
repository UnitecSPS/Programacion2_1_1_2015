/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TrabajoGrupoLab2;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author Docente 17082011
 */
public class PS3Game extends RentItem implements MenuActions {
    private ArrayList<String> especificaciones;
    private Calendar fechaPublicacion;
    
    public PS3Game(int codigo, String nombre) {
        super(codigo, nombre, 20);
        especificaciones = new ArrayList<>();
        fechaPublicacion = Calendar.getInstance();
    }

    @Override
    public String toString() {
        return super.toString()+ " - " + fechaPublicacion.getTime() +
                " - PS3 Game"; 
    }

    
    
    @Override
    public double pagoRenta(int dias) {
        return precio * dias;
    }
    
    public void setFechaPublicacion(int year, int mes, int dia){
        fechaPublicacion.set(year, mes, dia);
    }

    @Override
    public void submenu() {
        System.out.println("1- Actualizar Fecha Publicacin");
        System.out.println("2- Agregar Especificacion");
        System.out.println("3- Ver Especificaciones");
        System.out.println("4- Salir");
    }

    @Override
    public void ejecutarOpcion(int op) {
        Scanner lea = new Scanner(System.in);
        switch(op){
            case 1:
                System.out.println("Año: ");
                int year = lea.nextInt();
                System.out.println("Mes: ");
                int mes = lea.nextInt();
                System.out.println("Dia: ");
                int dia = lea.nextInt();
                setFechaPublicacion(year, mes-1, dia);
                break;
            case 2:
                System.out.println("Especificacion: ");
                especificaciones.add(lea.next());
                break;
            case 3:
                System.out.println("\nEspecificaciones\n-----------");
                for(String es : especificaciones)
                    System.out.println("-"+es);
        }
    }
    
}
