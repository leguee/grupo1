package cliente;
import java.io.*;
import java.net.Socket;
import java.util.logging.*;


class Browser extends Thread {

    protected Socket sk;
    protected DataOutputStream dos;
    protected DataInputStream dis;
    private int id;

    public Browser(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        try {
            sk = new Socket("127.0.0.1",5000);
            dos = new DataOutputStream(sk.getOutputStream());
            dis = new DataInputStream(sk.getInputStream());
            
            ///////////////////////////LEE DE UN ARCHIVO LINEA POR LINEA///////////////////////////////////// 
//            File f = new File( "C:texto.txt" );
//            BufferedReader entrada;
//            try {
//            entrada = new BufferedReader( new FileReader( f ) );
//            String linea;
//            while(entrada.ready()){
//            	linea = entrada.readLine();
//            	System.out.println(id + "envia click" );
//            	dos.writeUTF(linea);
//            }
//            }catch (IOException e) {
//            e.printStackTrace();
//            }
            /////////////////////////////////////////////////////////////////////////////////////////////////
            
            String respuesta="";
            respuesta = dis.readUTF();
            System.out.println(id + " Servidor devuelve saludo: " + respuesta);
            dis.close();
            dos.close();
            sk.close();
        } catch (IOException ex) {
            Logger.getLogger(Browser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}