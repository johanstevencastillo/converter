package com.challenge.conversor.controlador;
import java.util.HashMap;
import java.text.DecimalFormat;
public class Convertidor {
	
	//private static double USD = 4000;
	
	private static HashMap<String, Double> monedas = new HashMap<>();
	
	public Convertidor() {
		monedas.put("USD", (double) 4000);
		monedas.put("EUR", (double) 4570);
		monedas.put("GBP", (double) 5315);
		monedas.put("JPY", (double) 30);
		monedas.put("KRW", (double) 3.20);
		monedas.put("COP", (double) 1);
	}

	
	public String  convertirMoneda(String monedaInicial, String monedaFinal, double cantidad) {		
		double total  = (cantidad * monedas.get(monedaInicial))/(monedas.get(monedaFinal));		
		DecimalFormat decimalFormat = new DecimalFormat("#.####");		
		String redondeado = decimalFormat.format(total);		
		return (redondeado);
	}

}
