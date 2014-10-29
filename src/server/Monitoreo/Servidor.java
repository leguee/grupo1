package server.Monitoreo;
import java.io.*;
import java.net.*;
import java.util.logging.*;

import dispatcher.ServidorHilo;

public class Servidor {

    

    	//ServerSocket ss;
       // System.out.print("Inicializando servidor de monitoreo ");
        
        public String ip;

		public Servidor(String ip) {
			this.ip = ip;
		}
        
//        try {
//            ss = new ServerSocket(10578);
//            System.out.println("\t[OK]");
//            int idSession = 0;
//            while (true) {
//                Socket socket;
//                socket = ss.accept();
//                System.out.println("Nueva conexión entrante: "+socket);
//                ((ServidorHilo) new ServidorHilo(socket, idSession)).start();
//                idSession++;
//            }
//
//        } catch (IOException ex) {
//            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
//        }
    
}
