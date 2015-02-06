/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Polimorfismo.Chess;

/**
 *
 * @author KenyStev
 */
public class Position {
    private int[] pos = new int[2];

    public Position(int row, int col) {
        pos[0]=row;
        pos[1]=col;
    }
    
    public void set(int row, int col){
        pos[0]=row; pos[1]=col;
    }
    
    public void set(Position p){
        set(p.getRow(), p.getCol());
    }

    public int getRow() {
        return pos[0];
    }

    public int getCol() {
        return pos[1];
    }
    
    public boolean validar(int row, int col){
        return pos[0]==row && pos[1]==col;
    }
    
    public boolean validar(Position p){
        return validar(p.getRow(), p.getCol());
    }
}
