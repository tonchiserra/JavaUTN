package ejercicios1a4;

import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		
		String[] palabras = new String[10];
		String otraPalabra;
		Boolean bandera = true;
		
		for (int i = 0; i < 10; i++) {
			System.out.println("[" + (i+1) + "]" + " Ingrese una palabra: ");
			palabras[i] = reader.next();
		}
		
		System.out.println("Ingrese palabra para comparar:");
		otraPalabra = reader.next();
		
		for (String palabra : palabras) {
			if(palabra.equalsIgnoreCase(otraPalabra)) {
				System.out.println(otraPalabra + " SI fue ingresada antes");
				bandera = true;
				break;
			}else {
				bandera = false;
			}
		}
		
		if(!bandera) {
			System.out.println(otraPalabra + " NO fue ingresada antes");
		}
		
		reader.close();

	}

}
