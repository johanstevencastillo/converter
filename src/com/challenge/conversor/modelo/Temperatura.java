package com.challenge.conversor.modelo;

import java.text.DecimalFormat; 

public class Temperatura {
	
	public Temperatura() {
		
	}
	
	public String convertirTemperatura(String tempInicial, String tempFinal, double temperatura) {
		double finalTemp = 0;
		if(tempInicial == "CELCIUS" && tempFinal == "FAHRENHEIT") {
			
			finalTemp = ((9*temperatura)/5)+32;
			
		}else if(tempInicial == "FAHRENHEIT" && tempFinal == "CELCIUS") {
			
			finalTemp = (5 * (temperatura - 32 ))/9;
			
		}else if(tempInicial == "CELCIUS" && tempFinal == "KELVIN") {
			
			finalTemp = temperatura + 273.15;
			
		}else if (tempInicial ==  "KELVIN" && tempFinal == "CELCIUS") {
			
			finalTemp = temperatura - 273.15;
			
		}else if (tempInicial == "KELVIN" && tempFinal == "FAHRENHEIT") {
			
			finalTemp = ((9 * (temperatura - 273.15)) / 5) + 32;
				
		}else if(tempInicial == "FAHRENHEIT" && tempFinal == "KELVIN") {
			
			finalTemp = ((5 *(temperatura - 32 )) / 9) +273.15; 
		}else {
			finalTemp = temperatura;
		}
		
		DecimalFormat decimalFormat = new DecimalFormat("#.##");		
		String redondeado = decimalFormat.format(finalTemp);	
		
		return redondeado;
	}

}
