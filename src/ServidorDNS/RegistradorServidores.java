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
		try {
			ss = new ServerSocket(10579);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true){
			Socket sk;
			try {
				sk = ss.accept();
				DataInputStream dis = new DataInputStream(sk.getInputStream());
				String ipServidor = dis.readUTF();
				((RegistradorServidorHilo) new RegistradorServidorHilo(ipServidor,direcciones)).run();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
