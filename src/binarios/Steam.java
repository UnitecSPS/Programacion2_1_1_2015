package binarios;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Docente 17082011
 * @see formatos.txt
 */
public class Steam {
    RandomAccessFile rVideoGames;
    RandomAccessFile rClientes;
    RandomAccessFile rCodes;
    public static final String ROOT_FOLDER  = "steam";
    
    public Steam(){
        try{
            new File(ROOT_FOLDER).mkdir();
            rVideoGames = new RandomAccessFile(ROOT_FOLDER+"/videogames.stm", "rw");
            rClientes = new RandomAccessFile(ROOT_FOLDER+"/clientes.stm", "rw");
            initCodes();
        }catch(IOException e){
            System.out.println(e);
        }
    }

    private void initCodes()throws IOException {
        rCodes = new RandomAccessFile(ROOT_FOLDER+"/codes.stm", "rw");
        if(rCodes.length() == 0){
            rCodes.writeInt(1);
            rCodes.writeInt(1);
            rCodes.writeInt(1);
        }
    }
    
    private int getCode(int offset)throws IOException{
        rCodes.seek(offset);
        int code = rCodes.readInt();
        
        rCodes.seek(offset);
        rCodes.writeInt(code+1);
        
        return code;
    }
    
    private int getVideoGameAvailableCode()throws IOException{
        return getCode(0);
    }
    
    private int getDownloadAvailableCode()throws IOException{
        return getCode(4);
    }
    
    private int getClientAvailableCode()throws IOException{
        return getCode(8);
    }
    
    public void addVideoGame(String t, double p, Genero g, Rate r)throws IOException{
        rVideoGames.seek(rVideoGames.length());
        //codigo
        rVideoGames.writeInt(getVideoGameAvailableCode());
        //title
        rVideoGames.writeUTF(t);
        //precio
        rVideoGames.writeDouble(p);
        //stars
        rVideoGames.writeInt(0);
        //reviews
        rVideoGames.writeInt(0);
        //genero
        rVideoGames.writeUTF(g.name());
        //rate
        rVideoGames.writeUTF(r.name());
        //avaiables WIN, MAC, LINUX
        rVideoGames.writeBoolean(true);
        rVideoGames.writeBoolean(false);
        rVideoGames.writeBoolean(false);
    }
    
    public void listAvailableGames()throws IOException{
        rVideoGames.seek(0);
        int rating = 0;
        while(rVideoGames.getFilePointer() < rVideoGames.length()){
            int c = rVideoGames.readInt();
            String t = rVideoGames.readUTF();
            double p = rVideoGames.readDouble();
            int stars = rVideoGames.readInt();
            int revs = rVideoGames.readInt();
            if(revs > 0 )
                rating = stars / revs;
            String gen = rVideoGames.readUTF();
            String rate = rVideoGames.readUTF();
            boolean fwin = rVideoGames.readBoolean();
            boolean fmac = rVideoGames.readBoolean();
            boolean flinux = rVideoGames.readBoolean();
            
            if(fwin || fmac || flinux ){
                System.out.print(c+"-"+t+"- $"+p+" Rating: "+rating+
                        " - "+gen+" para: "+rate);
                if(fwin)
                    System.out.print(" WINDOWS");
                if(fmac)
                    System.out.print(" MAC");
                if(flinux)
                    System.out.print(" LINUX");
                System.out.println("");
            }
        }
    }
}
