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
    
}
