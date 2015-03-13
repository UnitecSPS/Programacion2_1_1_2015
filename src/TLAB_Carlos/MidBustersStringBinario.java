/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TLAB_Carlos;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 
 * @author CarlosHaddad
 */
public class MidBustersStringBinario {
    public static void main(String[] args) {
        try(RandomAccessFile raf = new RandomAccessFile("mithbuster.mbs","rw")){
            
            String txt = "Carlos";
            
            raf.writeUTF(txt);
            long pos = raf.getFilePointer();
            double size = (double)pos / (double)txt.length();
            System.out.println("Con 6 caracteres se toma "+pos+" bytes "+" cada caracter mide "+size+" bytes");
            
            raf.writeChars(txt);
            pos = raf.getFilePointer() - pos;
            size = (double)pos / (double)txt.length();
            System.out.println("Con 6 caracteres se tomo "+pos+" bytes "+" cada caracter mide "+size+" bytes");
            raf.writeInt(10);
            
            raf.seek(0);
            System.out.println("-"+raf.readUTF());
            System.out.println("-"+raf.readUTF());
            System.out.println("-"+raf.readInt());
            
        } catch(IOException e){
            System.out.println(e);
        }
    }
}
