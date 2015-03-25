/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pautas.examen2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Date;

/**
 *
 * @author Docente 17082011
 */
public class ManageBank {
    private RandomAccessFile rcuentas;
    
    public ManageBank(){
        try{
            new File("banco").mkdir();
            rcuentas = new RandomAccessFile("banco/cuentas.bnk", "rw");
        }
        catch(FileNotFoundException e){
            
        }
    }
    
    public long buscar(int code)throws IOException{
        rcuentas.seek(0);
        while(rcuentas.getFilePointer() < rcuentas.length()){
            if(code == rcuentas.readInt())
                return rcuentas.getFilePointer();
            rcuentas.readUTF();
            rcuentas.skipBytes(16);
            rcuentas.readUTF();
        }
        return -1;
    }
    
    public void addCuenta(int cod, String nom, TipoCuenta tipo)throws IOException, AccountAlreadyExistException{
        if(buscar(cod) == -1){
            rcuentas.writeInt(cod);
            rcuentas.writeUTF(nom);
            rcuentas.writeLong(new Date().getTime());
            rcuentas.writeDouble(tipo.minSaldo);
            rcuentas.writeUTF(tipo.name());
        }
        else{
            throw new AccountAlreadyExistException(cod);
        }
    }
    
    public void deposito(int cod, double m)throws IOException{

        if(buscar(cod)!=-1){
            rcuentas.readUTF();
            rcuentas.writeLong(new Date().getTime());
            long pos = rcuentas.getFilePointer();
            double s = rcuentas.readDouble();
            rcuentas.seek(pos);
            rcuentas.writeDouble(s+m);
        }
    }
    
    public boolean retiro(int cod, double m)throws IOException{
        if(buscar(cod)!=-1){
            rcuentas.readUTF();
            long pos = rcuentas.getFilePointer();
            rcuentas.readLong();
            double s = rcuentas.readDouble();
            if(s>m){
                rcuentas.seek(pos);
                rcuentas.writeLong(new Date().getTime());
                rcuentas.writeDouble(s-m);
                return true;
            }
        }
        return false;
    }
    
    public void registrarIntereses()throws IOException{
        rcuentas.seek(0);
        while(rcuentas.getFilePointer() < rcuentas.length()){
            rcuentas.readInt();
            rcuentas.readUTF();
            rcuentas.readLong();
            long pos = rcuentas.getFilePointer();
            double s = rcuentas.readDouble();
            double tasa = TipoCuenta.valueOf(rcuentas.readUTF()).tasaInteres;
            rcuentas.seek(pos);
            rcuentas.writeDouble(s+(s*tasa));
            rcuentas.readUTF();
        }
    }
    
    public void importCuentas(String filename)throws IOException{
        FileWriter fw = new FileWriter(filename);
        rcuentas.seek(0);
        while(rcuentas.getFilePointer() < rcuentas.length()){
            int cod = rcuentas.readInt();
            String n = rcuentas.readUTF();
            rcuentas.readLong();
            double s = rcuentas.readDouble();
            String t = rcuentas.readUTF();
            fw.write(cod+"-"+n+" lps. "+s+" tipo: "+t);
        }
        fw.close();
    }
}
