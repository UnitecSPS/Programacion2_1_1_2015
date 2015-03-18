package binarios;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Calendar;
import java.util.Date;

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
    public static final String ROOT_FOLDER  = "steam", DOWNLOADS_FOLDER="downloads", CLIENTS_FOLDER="clientes";
    
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
       
        while(rVideoGames.getFilePointer() < rVideoGames.length()){
            int rating = 0;
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
    
    public boolean searchVideoGame(int cvg)throws IOException{
        rVideoGames.seek(0);
        while(rVideoGames.getFilePointer() < rVideoGames.length()){
            if(rVideoGames.readInt() == cvg)
                return true;
            rVideoGames.readUTF();
            rVideoGames.skipBytes(16);
            rVideoGames.readUTF();
            rVideoGames.readUTF();
            rVideoGames.skipBytes(3);
        }
        return false;
    }
    
    public int addReview(int cbg, int stars)throws IOException{
        if(stars >= 0 && stars <= 5){
            if( searchVideoGame(cbg) ){
                rVideoGames.readUTF();
                rVideoGames.readDouble();
                long pos = rVideoGames.getFilePointer();
                int s = rVideoGames.readInt();
                int r = rVideoGames.readInt();
                rVideoGames.seek(pos);
                rVideoGames.writeInt(s+stars);
                rVideoGames.writeInt(r+1);
                return (s+stars) / (r+1);
            }
        }
        return -1;
    }
    
    /**
     * Agregar un nuevo cliente
     * @param n Nombre del cliente
     * @param f Fecha de Nacimiento en formato dd/mm/aaaa
     */
    public void addClient(String n, String f)throws IOException{
        rClientes.seek(rClientes.length());
        //codigo
        int codigo = getClientAvailableCode();
        rClientes.writeInt(codigo);
        //nombre
        rClientes.writeUTF(n);
        //fecha
        String data[] = f.split("/");
        int dia = Integer.parseInt(data[0]);
        int mes = Integer.parseInt(data[1]);
        int year = Integer.parseInt(data[2]);
        Calendar c = Calendar.getInstance();
        c.set(year, mes-1, dia);
        rClientes.writeLong(c.getTimeInMillis());
        //cantidad dows
        rClientes.writeInt(0);
        //creamos el folder

        new File(clientFolder(codigo,n)).mkdirs();
    }
    
    private String clientFolder(int codigo, String n) {
        return ROOT_FOLDER+"/"+CLIENTS_FOLDER+"/"+codigo + n.toLowerCase().trim();
    }
    
    private String downloadPath(int code, int codeCli, String cliente){
        return ROOT_FOLDER+"/"+clientFolder(codeCli, cliente)+"/download_"+code+".stm";
    }
    
    public boolean searchClient(int cc)throws IOException{
        rClientes.seek(0);
        while(rClientes.getFilePointer() < rClientes.length()){
            if(rClientes.readInt() == cc)
                return true;
            rClientes.readUTF();
            rClientes.skipBytes(12);
        }
        return false;
    }
    
    public void listClients()throws IOException{
        rClientes.seek(0);
        while(rClientes.getFilePointer() < rClientes.length()){
            int cod = rClientes.readInt();
            String n = rClientes.readUTF();
            Date fecha = new Date(rClientes.readLong());
            int cd = rClientes.readInt();
            
            System.out.println(cod+"-"+n+" nacido en "+fecha+
                    " Ha bajado "+cd+" games.");
        }
    }
    
    public boolean downloadGame(int cvg, int ccli, char SO)throws IOException{
        if(searchClient(ccli) && searchVideoGame(cvg)){
            rVideoGames.readUTF();
            double price = rVideoGames.readDouble();
            rVideoGames.skipBytes(8);
            rVideoGames.readUTF();
            Rate rate = Rate.valueOf(rVideoGames.readUTF().toUpperCase());
            boolean OS=false;
            switch(SO){
                case 'W': OS = rVideoGames.readBoolean(); 
                               rVideoGames.skipBytes(2);
                               break;
                case 'M': rVideoGames.readBoolean();
                          OS = rVideoGames.readBoolean();
                          rVideoGames.readBoolean();
                          break;
                case 'L': rVideoGames.skipBytes(2);
                          OS = rVideoGames.readBoolean();
                          break;
                    default:
                        rVideoGames.skipBytes(3);
            }
            
            if(OS){
                String nameCli = rClientes.readUTF();
                if(rate.canIDownload(new Date(rClientes.readLong()))){
                    int codeDown = getDownloadAvailableCode();
                    try(RandomAccessFile rDown = new RandomAccessFile(downloadPath(codeDown, ccli, nameCli), "rw")){
                        rDown.writeInt(codeDown);
                        rDown.writeInt(cvg);
                        rDown.writeLong(new Date().getTime());
                        rDown.writeDouble(price);
                        rDown.writeChar(SO);
                        
                        long posCli = rClientes.getFilePointer();
                        int cant_donw = rClientes.readInt();
                        rClientes.seek(posCli);
                        rClientes.writeInt(cant_donw+1);
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public void updatePriceFor(int cvg, double newprice)throws IOException{
        if(searchVideoGame(cvg)){
            rVideoGames.readUTF();
            rVideoGames.writeDouble(newprice);
        }
    }
    
    public void updateAvailableFor(int cvg, char SO)throws IOException{
        if(searchVideoGame(cvg)){
            rVideoGames.readUTF();
            rVideoGames.skipBytes(16);
            rVideoGames.readUTF();
            rVideoGames.readUTF();
            long pos = rVideoGames.getFilePointer();
            
            boolean Win = rVideoGames.readBoolean();
            boolean Mac = rVideoGames.readBoolean();
            boolean Tux = rVideoGames.readBoolean();
            
            switch(SO){
                case 'W': Win = !Win;
                if(Win) System.out.println("Ahora esta Disponible para: Windows!");
                else    System.out.println("Ya no esta disponible para: Windows!");
                          break;
                case 'M': Mac = !Mac;
                if(Mac) System.out.println("Ahora esta Disponible para: Mac!");
                else    System.out.println("Ya no esta Disponible para: Mac!");
                          break;
                case 'L': Tux = !Tux;
                if(Tux) System.out.println("Ahora esta Disponible para: GNU/Linux!");
                else    System.out.println("Ya no esta Disponible para: GNU/Linux!");
                          break;
            }
            rVideoGames.seek(pos);
            rVideoGames.writeBoolean(Win);
            rVideoGames.writeBoolean(Mac);
            rVideoGames.writeBoolean(Tux);
        }
    }
    
    public void reportForClient(int ccli, String txtFile) throws IOException{
        if(searchClient(ccli)){
            FileWriter report = new FileWriter(txtFile, false);
            
            String name = rClientes.readUTF();
            Date nac = new Date(rClientes.readLong());
            int canDows = rClientes.readInt();
            
            report.write(ccli+" - "+name+" - "+" - "+nac+" - Cant_Dows: "+canDows+"\n");
            
            File userDir = new File(clientFolder(ccli, name));
            
            double invertido=0;
            
            for (File down : userDir.listFiles()) {
                RandomAccessFile rDown = new RandomAccessFile(down, "r");
                
                int code = rDown.readInt();
                int codeV  =rDown.readInt();
                Date downloaded = new Date(rDown.readLong());
                double price = rDown.readDouble();
                char SO = rDown.readChar();
                
                searchVideoGame(codeV); String nameVideo = rVideoGames.readUTF();
                
                report.write(code+" - "+nameVideo+" $"+price+"SO: "+SO+" fecha: "+downloaded+"\n");
                invertido+=price;
            }
            
            report.write("Tolat Invertido: $"+invertido);
            
            System.out.println("Reporte Creado!");
            report.close();
        }else{
            System.out.println("No se Pudo crear Reporte!");
        }
    }
    
    public void clientEstrella()throws IOException{
        rClientes.seek(0);
        long pos = rClientes.getFilePointer();
        rClientes.readInt();rClientes.readUTF();rClientes.readLong();
        int allDows = rClientes.readInt();
        
        while(rClientes.getFilePointer() < rClientes.length()){
            long pos2 = rClientes.getFilePointer();
            rClientes.readInt();
            rClientes.readUTF();
            rClientes.readLong();
            int allDows2=rClientes.readInt();
            if(allDows2>allDows){
                pos = pos2;
                allDows=allDows2;
            }
        }
        
        if(allDows>0){
            rClientes.seek(pos);
            
            int code = rClientes.readInt();
            String name = rClientes.readUTF();
            Date nac = new Date(rClientes.readLong());
            int downs = rClientes.readInt();
            
            System.out.println("Cliente estrella!!!");
            System.out.println("Code: "+code+" Nombre: "+name+" Fecha Nac: "+nac+" Can_Downs: "+downs);
        }
    }
}
