package claseArrays;

public class Ejercicio32 {

	public static void main(String[] args) {
		int[] numeros = new int[100];
		
		for (int i = 0; i < numeros.length; i++) {
			if(numeros[i] < 10) {
				numeros[i] = numeros[i] + 4;
			}else {
				numeros[i] = numeros[i] + 5;
			}
			
			System.out.print(numeros[i] + ", ");
		}

	}

}
