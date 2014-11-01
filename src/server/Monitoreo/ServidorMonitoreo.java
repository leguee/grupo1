package server.Monitoreo;
import java.io.*;
import java.net.*;
import java.util.logging.*;

import server.Monitoreo.ServidorHilo;
import server.procesamiento.Servidor;

public class ServidorMonitoreo {

    public static void main(String args[]) throws IOException {

        ServerSocket ss;
        String ip = "172.0.0.1"; //  TODO poner la ip de la pc donde va a ser ejecutado este main 
        String ipDns = "172.0.0.1";// Harcodear ipDns
        System.out.print("Inicializando servidor... " + ip); 
        try {
            ss = new ServerSocket(5001);
            // Inicializacion de heartbeat
            Heartbeat hear = new Heartbeat(ipDns);
            hear.run();
            System.out.println("\t[OK]");
            int idSession = 0;
            while (true) {
                Socket socket;
                socket = ss.accept();
                System.out.println("Nueva conexión entrante: "+socket);
                ((ServidorHilo) new ServidorHilo(socket, idSession)).start();
                idSession++;
            }

        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
	
	
	
    
}
