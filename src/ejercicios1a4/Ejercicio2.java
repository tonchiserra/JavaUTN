package ejercicios1a4;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		
		String[] palabras = new String[10];
		
		for (int i = 0; i < 10; i++) {
			System.out.println("[" + (i+1) + "]" + " Ingrese una palabra: ");
			palabras[i] = reader.next();
		}
		
		for (int i = 10; i > 0; i--) {
			System.out.println(palabras[i-1]);
		}
		
		reader.close();
	}

}
