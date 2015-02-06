/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Polimorfismo.Chess;

import java.util.ArrayList;

/**
 *
 * @author KenyStev
 */
public abstract class Pieza {
    protected Position position;
    protected ArrayList<Position> movesValids = new ArrayList<>();
    protected BattelGround ground;
    protected String name, color, simbol;
    
    public abstract boolean move(int row, int col);
    public abstract boolean move(Position p);
    protected abstract void generateMovesValids();

    public Pieza(BattelGround ground, int row, int col, String name, String color) {
        this.ground=ground;
        position = new Position(row, col);
        this.name=name;
        this.color=color;
        simbol = name.charAt(0)+""+color.charAt(0);
    }
    
    public Pieza(BattelGround ground, Position p, String name, String color) {
        this(ground, p.getRow(), p.getCol(), name, color);
    }

    public String getSimbol() {
        return simbol;
    }
}
