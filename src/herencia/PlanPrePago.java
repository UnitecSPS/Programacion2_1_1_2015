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
 * El plan cuesta 60
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
    private CellCard cell;
    private static final double costMin=0.5,costMjs=0.05; 

    public PlanPrePago(int n, String c) {
        super(n, c, 0);
        cell = new CellCard500();
    }

    public CellCard getCell() {
        return cell;
    }
    
    public void setCard(int tipo){
        switch(tipo){
            case 100: cell.addSaldoByCard(new CellCard100()); break;
            case 50: cell.addSaldoByCard(new CellCard50()); break;
            case 500: cell.addSaldoByCard(new CellCard500()); break;
        }
    }

    @Override
    public double calcularPago(int mins, int msgs) {
        double pago = 0;
        if(cell.isValid()){
            pago = mins*costMin + msgs*costMjs;
            cell.decreaseSaldo(pago);
        }else{
            System.out.println("Tarjeta no valida!");
        }
        return pago;
    }

    @Override
    public String toString() {
        return "PlanPrePago["+super.toString() + ", "+ cell+"]";
    }
}
