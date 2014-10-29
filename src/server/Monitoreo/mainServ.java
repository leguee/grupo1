package server.Monitoreo;
import java.io.*;
import java.net.*;
import java.util.Vector;


public class mainServ {
	public static final String ipServ1 = "100.10.10.1";
	public static final String ipServ2 = "100.10.10.2";
	public static final String ipServ3 = "100.10.10.3";
	
    public static void main(String args[]) throws IOException {
    	
 
    	
//    	int idSession1, idSession2, idSession3;
    	
    	Vector<Thread> servidores = new Vector<Thread>(); // 3 servidores iniciales de monitoreo
    	
    	System.out.print("Inicializando servidores de monitoreo ");
    	ServerSocket sockMonitoreo1 = new ServerSocket(5001); // crea los socketServer
    	ServerSocket sockMonitoreo2  = new ServerSocket(5002);
    	ServerSocket sockMonitoreo3 = new ServerSocket(5003);
    	
    
    	
		Thread servMomit1 = new ServidorMonitoreo(sockMonitoreo1, ipServ1); // crea los servidores
		Thread servMonit2 = new ServidorMonitoreo (sockMonitoreo2, ipServ2);
		Thread servMonit3 = new ServidorMonitoreo (sockMonitoreo3, ipServ3);
		
		servidores.add(servMomit1); // agrega al vector
    	servidores.add(servMonit2);
    	servidores.add(servMonit3);
		
		servMomit1.start(); // los inicia
		servMonit2.start();
		servMonit3.start();
				
    	
    	
    
           }
}
