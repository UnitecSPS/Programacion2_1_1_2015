/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package herencia;

import java.util.ArrayList;

/**
 *
 * @author Docente 17082011
 */
public class DibujoTecnico {
    public static void main(String[] args) {
        ArrayList<Figura> figuras = new ArrayList<>();
        figuras.add(new Circulo());
        figuras.add(new Rectangulo());
        figuras.add(new Triangulo());
        
        for(Figura f : figuras){
            System.out.println(f.getNombre()+"\n--------");
            f.dibujar();
        }
        
        //FUNCIONES ON DEMAND--------------------------------
        Figura fig = new Figura("Matrix"){
            public void draw(){
                System.out.println("010001011");
            }
            
            @Override
            public void dibujar(){
                draw();
            }
        };
        
        fig.dibujar();
    }
}
