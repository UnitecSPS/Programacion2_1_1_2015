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
    public static final String ROOT_FOLDER  = "steam";
    
    public Steam(){
        try{
            new File(ROOT_FOLDER).mkdirs();
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
        return ROOT_FOLDER+"/clients/"+codigo + n.toLowerCase().trim();
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
    
    public boolean addDownload(int cvg, int ccli, char so)throws IOException{
        if(searchClient(ccli) && searchVideoGame(cvg)){
            String titulo = rVideoGames.readUTF();
            double precio = rVideoGames.readDouble();
            rVideoGames.skipBytes(8);
            rVideoGames.readUTF();
            Rate rate = Rate.valueOf(rVideoGames.readUTF());
            
            if( isAvailableForSO(so) ){
                String cliente = rClientes.readUTF();
                Date nacimiento = new Date(rClientes.readLong());
                
                if( rate.canIDownload(nacimiento) ){
                    int cant = rClientes.readInt();
                    rClientes.seek(rClientes.getFilePointer()-4);
                    rClientes.writeInt(cant+1);
                    int codDown = getDownloadAvailableCode();
                    String downloadPath = downloadPath(codDown,ccli,cliente);
                    
                    RandomAccessFile rDown 
                            = new RandomAccessFile(downloadPath, "rw");
                    //codigo
                    rDown.writeInt(codDown);
                    //cod vg
                    rDown.writeInt(cvg);
                    //fecha
                    rDown.writeLong(new Date().getTime());
                    //precio
                    rDown.writeDouble(precio);
                    //so
                    rDown.writeChar(Character.toUpperCase(so));
                    rDown.close();
                    
                    System.out.println("\n"+cliente+" has bajado "+titulo+
                            " a un precio de $"+precio);
                    
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * USARLO SOLO SI EL PUNTERO ESTA AL INICIO DE LOS DATOS
     * BOOLEANOS
     * @param so Sistema Operativo (W:Windows, M: Mac, L: Linux)
     * @return 
     */
    private boolean isAvailableForSO(char so)throws IOException {
        char soUpper = Character.toUpperCase(so);
        boolean win = rVideoGames.readBoolean();
        boolean mac = rVideoGames.readBoolean();
        boolean linux = rVideoGames.readBoolean();
        
        if( soUpper == 'W' ){
            return win;
        }
        else if(soUpper == 'M'){
            return mac;
        }
        else if(soUpper == 'L'){
            return linux;
        }
        else{
            return false;
        }
    }

    private String downloadPath(int codDown, int ccli, String cliente) {
        return clientFolder(ccli, cliente)+"/download_"+codDown+".stm";
    }
    
    public void updatePriceFor(int cvg, double newprice)throws IOException{
        if(searchVideoGame(cvg)){
            String titulo = rVideoGames.readUTF();
            rVideoGames.writeDouble(newprice);
            System.out.println("\nSe ha actualizado el precio de "+titulo+
                    " a $" + newprice);
        }
    }
    
    public void updateAvailableFor(int cvg, char SO)throws IOException{
        if(searchVideoGame(cvg)){
            String titulo = rVideoGames.readUTF();
            rVideoGames.skipBytes(16);
            rVideoGames.readUTF();
            rVideoGames.readUTF();
            char soUp = Character.toUpperCase(SO);
            if( soUp == 'W' ){
                updateAvailableFor("Windows", titulo);
            }else if( soUp == 'M' ){
                rVideoGames.readBoolean();
                updateAvailableFor("Mac",titulo);
            }
            else if( soUp == 'L' ){
                rVideoGames.skipBytes(2);
                updateAvailableFor("Linux",titulo);
            }
        }
    }

    /**
     * EL PUNTERO DEBE DE ESTAR AL INICIO DEL BOOLEANO ADECUADO
     * @param SO
     * @param titulo 
     */
    private void updateAvailableFor(String SO, String titulo)throws IOException {
        boolean so = !rVideoGames.readBoolean();
        rVideoGames.seek(rVideoGames.getFilePointer()-1);
        rVideoGames.writeBoolean(so);
        
        if(so)
            System.out.println("\n"+titulo+" ahora esta disponible para "+
                    SO+"\n");
        else
            System.out.println("\n"+titulo+" ya no esta disponible para "+
                    SO+"\n");
    }
    
    public void reportForClient(int ccli, String txtFile) throws IOException{
        if(searchClient(ccli)){
            FileWriter fw = new FileWriter(txtFile);
            fw.write("REPORTE DE CLIENTE\n--------------------\n");
            String nombre = rClientes.readUTF();
            fw.write("Nombre: "+nombre+"\n");
            Date naci = new Date(rClientes.readLong());
            fw.write("Nacimiento: "+naci.toString()+"\n");
            fw.write("Lista de Downloads("+rClientes.readInt()+"): \n");
            writeDownloadsToReportFor(fw, ccli, nombre);
            fw.close();
            System.out.println("REPORTE CREADO");
        }
        else
            System.out.println("NO SE PUEDE CREAR REPORTE");
    }

    private void writeDownloadsToReportFor(FileWriter fw, int ccli, String nombre)throws IOException {
        File dirClient = new File(clientFolder(ccli, nombre));
        double invertido = 0;
        for(File down : dirClient.listFiles()){
            //por si las moscas
            if(down.isFile()){
                RandomAccessFile rDown = new RandomAccessFile(down, "r");
                int cod = rDown.readInt();
                int codvid = rDown.readInt();
                String game = "No Disponible";
                if( searchVideoGame(codvid))
                    game = rVideoGames.readUTF();
                Date fecha = new Date(rDown.readLong());
                double prec = rDown.readDouble();
                invertido += prec;
                char so = rDown.readChar();
                
                fw.write(cod+" - "+game+" - $"+prec+" - "+so+" - "+
                        fecha.toString()+"\n");
                rDown.close();
            }
        }
        fw.write("\nTotal Invertido: $"+invertido);
    }
    
    public void clientEstrella( )throws IOException{
        int mayor = 0, codMayor=0;
        String cliMayor="";
        Date fechaMayor=new Date();
        
        rClientes.seek(0);
        while(rClientes.getFilePointer() < rClientes.length()){
            int cod = rClientes.readInt();
            String nombre = rClientes.readUTF();
            Date naci = new Date(rClientes.readLong());
            int cant = rClientes.readInt();
            
            if(cant > mayor){
                mayor = cant;
                codMayor = cod;
                cliMayor = nombre;
                fechaMayor = naci;
            }
        }
        
        if(mayor > 0){
            System.out.println("\nClient Estrella con "+mayor+" downloads es:");
            System.out.println("\t"+codMayor+"-"+cliMayor+"- Nacido en "+fechaMayor);
        }
    }
}
