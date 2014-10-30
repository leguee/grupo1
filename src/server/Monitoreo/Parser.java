package server.Monitoreo;

import java.util.Vector;



public class Parser {
	
	private Click click;
	
	public Parser() {
		click = new Click();
	}
 
	public Click parsear( String p ) {
		String palabra = p;
		Vector<String> srtg = new Vector<String>();
		String delims = "[$]+";
		String[] tokens = palabra.split(delims);
		
		/////Muestra los tokens
		for(String e: tokens){
			e. trim();
			srtg.add(e);
			System.out.println(e+ ",");
		}
		/////
		
		click.setFecha(srtg.elementAt(0));
		click.setHora(srtg.elementAt(1));
		click.setBrowser(srtg.elementAt(2));
		click.setSo(srtg.elementAt(3));
		click.setLink(srtg.elementAt(4));
		click.setIp(srtg.elementAt(5));
		
		return click;
	}
	
}
