package ServidorDNS;

import java.io.*;
import java.net.*;
import java.util.Vector;
import java.util.logging.*;

public class SerDNS {

	private static ServerSocket ss;
	private static Vector<String> direcciones;
	private static int idSer;
	
    public static void main(String args[]) throws IOException {
    	
    	direcciones = new Vector<String>();
    	idSer=0;
    	
    	direcciones.addElement("100.10.10.1");
    	direcciones.addElement("100.10.10.2");
    	direcciones.addElement("100.10.10.3");
    	
        System.out.print("Inicializando servidor... ");
        try {
            ss = new ServerSocket(10578); //SE CREA UNA CONEXIÓN del SERVER
            System.out.println("\t[OK]");
            
            int idSession = 0;
            while (true) { //ESPERA CLIENTES
                //System.out.println("Nueva conexión entrante: "+ (Socket)ss.accept());
            	System.out.println("idServidor"+idSer);
                ((SerDNSHilo) new SerDNSHilo((Socket)ss.accept(), idSession, direcciones.elementAt(idSer%direcciones.size())) ).start(); //LE PASO EL SOCKET AL SERHILO, LO CREO Y LO RUNNEO
                idSession++;
                idSer++;
            }

        } catch (IOException ex) {
            Logger.getLogger(SerDNS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
