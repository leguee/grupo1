package ServidorDNS;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import server.Monitoreo.ServidorHilo;

public class RegistradorServidores implements Runnable{

	Vector<String> direcciones;
	private ServerSocket ss;
	
	public RegistradorServidores(Vector<String> direcciones) {
		this.direcciones=direcciones;
	}

	@Override
	public void run() {
		try {
			ss = new ServerSocket(10579);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (true){
			Socket sk;
			try {
				sk = ss.accept();
				DataInputStream dis = new DataInputStream(sk.getInputStream());
				String ipServidorEntrante = dis.readUTF();
				((RegistradorServidorHilo) new RegistradorServidorHilo(ipServidorEntrante,direcciones)).run();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
