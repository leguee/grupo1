package ServidorDNS;

import java.io.*;
import java.net.*;
import java.util.logging.*;

public class SerDNSHilo extends Thread {

    private Socket socket;
    private DataOutputStream dos;
    private DataInputStream dis;
    //private int idSessio;
    private String dirServidor;

    public SerDNSHilo(Socket socket, int id, String dir) {
        this.socket = socket;
        //this.idSessio = id;
        dirServidor=dir;
        try {
            dos = new DataOutputStream(socket.getOutputStream()); //OBENGO LAS ENTRADAS Y SALIDAS DEL SOCKET
            dis = new DataInputStream(socket.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(SerDNSHilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void desconnectar() {
        try {
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(SerDNSHilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void run() {
        try {
            if(dis.readUTF().equals("getServidor")){
                //System.out.println("El cliente con idSesion "+this.idSessio+" pide servicio");
                dos.writeUTF(dirServidor);// SALIDA: LE DOY LA DIRECCION DEL SERVIDOR CORREPONDIENTE
            }
        } catch (IOException ex) {
            Logger.getLogger(SerDNSHilo.class.getName()).log(Level.SEVERE, null, ex);
        }
        desconnectar();
    }
}
