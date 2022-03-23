package ejercicios1a4;

import java.util.Scanner;
import java.util.LinkedList;

public class Ejercicio4b {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		
		LinkedList<Integer> enteros = new LinkedList<>();
		enteros.add(1);
		enteros.add(11);
		enteros.add(23);
		enteros.add(27);
		enteros.add(9);
		enteros.add(30);
		enteros.add(22);
		enteros.add(44);
		enteros.add(91);
		enteros.add(111);
		enteros.add(222);
		enteros.add(289);
		enteros.add(122);
		enteros.add(378);
		enteros.add(342);
		enteros.add(892);
		enteros.add(2);
		enteros.add(82);
		enteros.add(19);
		enteros.add(9);
		
		LinkedList<Integer> mayores = new LinkedList<>();
		
		int otroEntero;
		
		System.out.print("Ingrese un entero: ");
		otroEntero = Integer.parseInt(reader.next());
		
		for (Integer entero : enteros) {
			if(entero > otroEntero) {
				mayores.add(entero);
			}
		}
		
		System.out.println("");
		System.out.print("Lista de 20 enteros: ");
		for (Integer entero : enteros) {
			System.out.print(entero + ", ");
		}
		
		System.out.println("");System.out.println("");
		System.out.print("Los numeros mayores a " + otroEntero + " son: " );
		for (Integer mayor : mayores) {
			System.out.print(mayor + ", ");
		}
		
		reader.close();
	}

}
