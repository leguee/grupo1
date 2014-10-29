package server.Monitoreo;
import java.io.*;
import java.net.*;
import java.util.Vector;
import dispatcher.ServidorHilo;

public class mainServ {

    public static void main(String args[]) throws IOException {
    	
    	public static final Short ipServ1 = 270;
    	public static final Short ipServ2 = 270;
    	public static final Short ipServ3 = 270;
    	
    	int idSession1, idSession2, idSession3;
    	
    	Vector<Servidor> servidores;
    	System.out.print("Inicializando servidores de monitoreo ");
    	ServerSocket sockMonitoreo1 = new ServerSocket(5001);
    	ServerSocket sockMonitoreo2  = new ServerSocket(5002);
    	ServerSocket sockMonitoreo3 = new ServerSocket(5003);
    	
		Servidor servMomit1 = Servidor(sockMonitoreo1);
		Servidor servMonit2 = Servidor(sockMonitoreo2);
		Servidor servMonit3 = Servidor (sockMonitoreo3);
		
		
		
		
    	
		
    	servidores.add(arg0)
    	
    	
    	
    	
    	
    	
    	
    	
        
        
        
           }
}
