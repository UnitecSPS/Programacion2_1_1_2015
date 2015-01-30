package TrabajoGrupo1Lab;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kenystev
 */
public class Ticket {
    private String name;
    private double pagado;

    public Ticket(String name, double pagado) {
        this.name = name;
        this.pagado = pagado;
    }

    public String getName() {
        return name;
    }

    public double getPagado() {
        return pagado;
    }

    public void print() {
        System.out.println("Nombre: "+name+", Pagado: "+pagado);
    }
}
