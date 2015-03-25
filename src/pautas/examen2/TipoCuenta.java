/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pautas.examen2;

/**
 *
 * @author Docente 17082011
 */
public enum TipoCuenta {
    NORMAL(0.02,500), PLANILLA(0,200), VIP(0.04,1000);
    double tasaInteres, minSaldo;

    private TipoCuenta(double t, double m) {
        tasaInteres = t;
        minSaldo = m;
    }
}
