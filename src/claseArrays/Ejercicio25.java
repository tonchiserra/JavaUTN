package claseArrays;

public class Ejercicio25 {

	public static void main(String[] args) {
		int[] numeros = {7, 5, 6, 8, 1, 2, 3, 4};
		
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
		
		int aux;
		for (int i = 0; i < numeros.length; i++) {
			for (int j = 0; j < (numeros.length)-1; j++) {
				if(numeros[j] > numeros[j+1]) {
					aux = numeros[j];
					numeros[j] = numeros[j+1];
					numeros[j+1] = aux;
				}
			}
		}
		
		for (int i = 0; i < numeros.length; i++) {
			System.out.println(numeros[i]);
		}
		
		System.out.println("max:" + max);
		System.out.println("min:" + min);

	}

}
