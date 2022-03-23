package ejercicios1a4;

public class Ejercicio1 {

	public static void main(String[] args) {
		
		System.out.print("Numeros enteros: ");
		for (int i = 1; i <= 10; i++) {
			System.out.print(i + " ");
		}
		
		System.out.println(" ");
		System.out.print("Numeros impares: ");
		for (int i = 1; i <= 20; i++) {
			if (i % 2 != 0) {
				System.out.print(i + " ");
			}
		}
		
		
	}

}
