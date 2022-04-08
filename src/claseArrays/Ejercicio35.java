package claseArrays;

public class Ejercicio35 {

	public static void main(String[] args) {
		int[] numeros = {23, 45, 68, 99, 10, 15 ,4};

		int max = numeros[0];
		int min = numeros[0];
		for (int i = 0; i < numeros.length; i++) {
			if(numeros[i] >= max) {
				max = numeros[i];
			}
			if(numeros[i] < min) {
				min = numeros[i];
			}
		}
		
		System.out.println("Minimo: " + min);
		System.out.println("Maximo: " + max);
	}

}
