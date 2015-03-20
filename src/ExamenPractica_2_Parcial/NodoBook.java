/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExamenPractica_2_Parcial;

/**
 *
 * @author KenyStev
 */
public class NodoBook {
    public int bookCode;
    public long bookByte;
    public NodoBook nextBook;
    
    public NodoBook(int bc, long bb){
        bookCode = bc;
        bookByte = bb;
        nextBook = null;
    }
}
