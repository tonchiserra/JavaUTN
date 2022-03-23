package ejercicios1a4;

import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		
		String[] enteros = {"1","3","4","6","1","12","65","3","23","8","9","233","23","12","5","655","31","7","432","2"};
		String[] mayores = new String[20];
		
		String otroEntero;
		
		System.out.print("Ingrese un entero: ");
		otroEntero = reader.next();
		
		for (int i = 0; i < enteros.length; i++) {
			if(Integer.parseInt(enteros[i]) > Integer.parseInt(otroEntero)) {
				mayores[i] = enteros[i];
			}
		}
		
		System.out.println("");
		System.out.print("Lista de 20 enteros: ");
		for (String entero : enteros) {
			System.out.print(entero + ", ");
		}
		
		System.out.println("");System.out.println("");
		System.out.print("Los numeros mayores a " + otroEntero + " son: " );
		for (String mayor : mayores) {
			if(mayor != null) {
				System.out.print(mayor + ", ");
			}
		}
		
		reader.close();
	}

}
