/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package herencia;

/**
 *
 * @author Docente 17082011
 * 
 * Atributos: de tipo CellCard y hacerle un get
 * 
 * Constructor:
 *   - Inicialmente se activa una CellCard500
 * 
 * Funciones:
 *  - setCard(int tipo). tipos validos 100, 50, 500
 * 
    - calcularPago: Va a cobrar 0.5 x min y 0.05 x msg
    *   este saldop se va a rebajar. Pero validen que la 
    *   tarjeta este valida, sino, se retorna cero.
 *   -
 *  - toString(): Para incluir lo que ya hace el padre + CellCard
 * 
 */
public class PlanPrePago extends Plan {
    private CellCard card;
    
    public PlanPrePago(int n, String c) {
        super(n, c, 0);
        card = new CellCard500();
    }

    public CellCard getCard() {
        return card;
    }
    
    public void setCard(int tipo){
        switch(tipo){
            case 50:
                card.addSaldoByCard(new CellCard50());
                break;
            case 100:
                card.addSaldoByCard(new CellCard100());
                break;
            case 500:
                card.addSaldoByCard(new CellCard500());
                break;
            default:
                System.out.println("TARJETA INCORRECTA");
        }
    }

    @Override
    public String toString() {
        return "PlanPrePago["+super.toString()+", "+card+"]"; 
    }

    @Override
    public double calcularPago(int mins, int msgs) {
        double m = 0;
        
        if( card.isValid() ){
            m = mins * 0.5 + msgs * 0.08;
            card.decreaseSaldo(m);
        }
        else
            System.out.println("No Tiene Saldo o Tarjeta Expiro, Recargue");
        
        return m;
    }
    
    
    
}
