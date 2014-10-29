package server.Monitoreo;
import java.io.*;
import java.net.*;
import java.util.logging.*;

import server.Monitoreo.ServidorHilo;

public class ServidorMonitoreo extends Thread {

    
	 	private String ip;
	 	private ServerSocket ss;
    

		public ServidorMonitoreo(ServerSocket sSocket,String ip) {
			this.ip = ip;
			this.ss = sSocket;
		}

       

		
		public void run() {
			  try {
		          
		        	System.out.println("Inicializando servidor de monitoreo.. " + ip);
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
		            Logger.getLogger(ServidorMonitoreo.class.getName()).log(Level.SEVERE, null, ex);
		        }
		}





//		public void start() {
//		
//        try {
//          
//        	System.out.println("Inicializando servidor de monitoreo.. " + ip);
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
//		}
    
}
