package Clientes;

import java.io.*;
import java.net.Socket;
import java.util.logging.*;

class Script extends Thread {

    protected Socket sk;
    protected DataOutputStream dos;
    protected DataInputStream dis;
    private int id;

    public Script(int id) {
        this.id = id;
    }

    public void run() {
        try {
            sk = new Socket("192.168.0.12", 10578);
            dos = new DataOutputStream(sk.getOutputStream()); //LE DOY LAS ENTRADAS Y SALIDAS DEL SOCKET
            dis = new DataInputStream(sk.getInputStream());
            
            System.out.println(id + " Pide Servidor ");
            dos.writeUTF("getServidor"); //SALIDA
            String respuesta="";
            respuesta = dis.readUTF(); //ENTRADA
            System.out.println(id + " Servidor devuelve: " + respuesta);
     
            //dis.close(); //CIERRO LA ENTRADA, SALIDA y el SOCKET
            //dos.close();
            //sk.close();
        } catch (IOException ex) {
            Logger.getLogger(Script.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}