/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExamenPractica_2_Parcial;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author KenyStev
 */
public class Biblioteca {
    private RandomAccessFile rBooks;
    private NodoBook root;
    private static final String ROOT_PATH="Library";

    public Biblioteca() {
        root=null;
        try {
            File rootDir = new File(ROOT_PATH);
            rootDir.mkdir();
            
            rBooks = new RandomAccessFile(rootDir+"/books.boo", "rw");
            reloadList();
        } catch (FileNotFoundException ex) {
            System.out.println("Error:"+ex);
        } catch (IOException ex) {
            System.out.println("Error:"+ex);
        }
    }

    private void reloadList() throws IOException {
        while(rBooks.getFilePointer() < rBooks.length()){
            long pos = rBooks.getFilePointer();
            int code = rBooks.readInt();
            rBooks.readUTF();
            rBooks.skipBytes(12);
            
            addNode(new NodoBook(code, pos));
        }
    }
    
    public boolean isEmpty(){
        return root == null;
    }

    private void addNode(NodoBook obj) {
        if(isEmpty()) root=obj;
        
        NodoBook tmp = root;
        while(tmp.nextBook!=null){
            tmp = tmp.nextBook;
        }
        tmp.nextBook = obj;
    }
    
    public long searchBook(int code){
        NodoBook tmp = root;
        while(tmp!=null){
            if(tmp.bookCode==code)
                return tmp.bookByte;
            tmp = tmp.nextBook;
        }
        return -1;
    }
    
    public boolean addBook(int code, String title, double rentPrice) throws IOException{
        if(searchBook(code)==-1){
            rBooks.seek(rBooks.length());
            long pos = rBooks.getFilePointer();
            rBooks.seek(rBooks.length());
            rBooks.writeInt(code);
            rBooks.writeUTF(title);
            rBooks.writeDouble(rentPrice);
            rBooks.writeInt(5);
            addNode(new NodoBook(code, pos));
            return true;
        }
        return false;
    }
    
    public double rentBook(int code) throws IOException{
        double price = 0;
        long filePoint = searchBook(code);
        if(filePoint>-1){
            rBooks.seek(filePoint);
            rBooks.readInt();
            String title = rBooks.readUTF();
            double p = rBooks.readDouble();
            long pos = rBooks.getFilePointer();
            int copias = rBooks.readInt();
            
            if(copias>0){
                price=p;
                rBooks.seek(pos);
                rBooks.writeInt(copias-1);
                System.out.println("Libro: "+title+" rentado!");
            }
        }
        return price;
    }
    
    public void statistics() throws IOException{
        rBooks.seek(0);
        int cantBooks=0, copiasNoPrestadas=0;
        double montoTotal=0;
        
        while(rBooks.getFilePointer() < rBooks.length()){
            rBooks.readInt();
            rBooks.readUTF();
            double p = rBooks.readDouble();
            int copias = rBooks.readInt();
            
            cantBooks++;
            copiasNoPrestadas += copias;
            montoTotal += 5 * p;
        }
        
        System.out.println("Hay en Inventario: "+cantBooks+" libros distintos");
        int copiasTotales = cantBooks*5;
        System.out.println("Total de Copias: "+copiasTotales);
        System.out.println("Hay "+(copiasTotales-copiasNoPrestadas)+" copias prestadas");
        System.out.println("Monto total si se rentaran todos los libros: "+montoTotal);
    }
    
    public void reportBooks(String filename) throws IOException{
        FileWriter fw = new FileWriter(filename, false);
        rBooks.seek(0);
        fw.write("***** REPORT BOOKS *****\n");
        while(rBooks.getFilePointer() < rBooks.length()){
            int code = rBooks.readInt();
            String title = rBooks.readUTF();
            double p = rBooks.readDouble();
            int copias = rBooks.readInt();
            
            fw.write("Code: "+code+" - Title: "+title+" - Precio:"+p+" - Copias Disponibles: "+copias+"\n");
        }
        fw.close();
    }
}
