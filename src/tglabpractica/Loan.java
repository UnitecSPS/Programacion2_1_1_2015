/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tglabpractica;

import java.io.Serializable;
import java.util.Calendar;

/**
 *
 * @author KenyStev
 */
public class Loan implements Pagable, Serializable{
    private String name;
    private double montoPrestamo;
    private int totalCuotas;
    private Calendar fechaCreacionDelPrestamo;
    private Bill[] cuotas;

    public Loan(String name, double montoPrestamo, int totalCuotas) throws LoanInvalidException{
        if(montoPrestamo<5000 || totalCuotas<5)
            throw new LoanInvalidException(montoPrestamo);
        
        this.name = name;
        this.montoPrestamo = montoPrestamo;
        this.totalCuotas = totalCuotas;
        fechaCreacionDelPrestamo = Calendar.getInstance();
        cuotas = new Bill[totalCuotas];
        initBills();
    }

    @Override
    public void pay() throws AlreadyPaidException {
        Calendar now = Calendar.getInstance();
        int diff = now.get(Calendar.MONTH) - fechaCreacionDelPrestamo.get(Calendar.MONTH); //???
        try{
            if(!cuotas[diff].isPagada()){
                cuotas[diff].payThisBill();
            }else
                throw new AlreadyPaidException();
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Bill puede no existir, si existe, comuníquese con el área de soporte!");
        }
    }

    @Override
    public double balanceDue() {
        double porPagar = montoPrestamo;
        for (Bill cuota : cuotas) {
            if(cuota.isPagada())
                porPagar -= cuota.getMonto();
        }
        return porPagar;
    }

    private void initBills() {
        final double montoXcuota = montoPrestamo/totalCuotas;
        for (int i = 0; i < cuotas.length; i++) {
            Calendar c = Calendar.getInstance();
            c.add(Calendar.MONTH, (i+1));
            cuotas[i] = new Bill(c, montoXcuota);
        }
    }
    
    public void print(){
        System.out.println(this);
        for (int i = 0; i < cuotas.length; i++) {
            double montoBill = cuotas[i].getMonto();
            Calendar fechaBill = cuotas[i].getFechaDePago();
            boolean isPayed = cuotas[i].isPagada();
            
            System.out.print(i+". "+(isPayed?"Pagada":"No Pagada"));
            if(isPayed){
                System.out.println(montoBill+" pagado para la fecha: "+fechaBill.getTime());
            }else{
                Calendar now = Calendar.getInstance();
                if(now.before(cuotas[i].getFechaDePago())){
                    System.out.println(montoBill+" aun pendiente de pago para el: "+fechaBill.getTime());
                }else{
                    System.out.println(montoBill+" pendiente y ALERTA! Se debió pagar el "+ fechaBill.getTime() +", contactar cliente");
                }
            }
        }
        System.out.println("Monto Total Pendiente: "+balanceDue());
    }

    @Override
    public String toString() {
        return "name=" + name + ", montoPrestamo=" + montoPrestamo + ", totalCuotas=" + totalCuotas + ", fechaCreacionDelPrestamo=" + fechaCreacionDelPrestamo.getTime();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof String)
            return name.equals((String)obj);
        return false;
    }
    
}
