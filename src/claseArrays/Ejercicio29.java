package claseArrays;

import java.util.Scanner;

public class Ejercicio29 {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		
		int[][] matriz = new int[4][4];
		
		int n1 = 0;
		int n2 = 0;
		
		for (int i = 0; i < 4; i++) {
			for(int j=0; j<4; j++) {
				System.out.println("Ingrese un numero para la posicion [" + i + "][" + j + "]");
				matriz[i][j] = Integer.parseInt(reader.next());
			}
		}
		
		n1 = matriz[0][0] + matriz[1][1] + matriz[2][2] + matriz[3][3];
		n2 = matriz[0][3] + matriz[1][2] + matriz[2][1] + matriz[3][0];
		
		n1 = n1*n2;
		
		System.out.println(n1);
		
		reader.close();
		
	}

}
