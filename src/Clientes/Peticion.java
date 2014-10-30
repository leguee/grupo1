package Clientes;

import java.io.*;
import java.net.Socket;
import java.util.logging.*;

class Peticion extends Thread {

    protected Socket sk;
    protected DataOutputStream dos;
    protected DataInputStream dis;
    private int id;

    public Peticion(int id) {
        this.id = id;
    }

    public void run() {
        try {
            sk = new Socket("127.0.0.1", 5001);
            dos = new DataOutputStream(sk.getOutputStream()); //LE DOY LAS ENTRADAS Y SALIDAS DEL SOCKET
            dis = new DataInputStream(sk.getInputStream());
            
            System.out.println(id + " Pide Servidor ");
            dos.writeUTF("getServidor"); //SALIDA
            String respuesta="";
            respuesta = dis.readUTF(); //ENTRADA
            System.out.println(id + " Servidor devuelve: " + respuesta);
            
            dis.close(); //CIERRO LA ENTRADA, SALIDA y el SOCKET
            dos.close();
            sk.close();
        } catch (IOException ex) {
            Logger.getLogger(Peticion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}