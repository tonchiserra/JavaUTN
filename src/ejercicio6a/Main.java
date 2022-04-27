package ejercicio6a;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		
		Driver drvr = new Driver();
		
		menu(drvr);
		
		System.exit(0);
	}
	
	
	public static void menu(Driver drvr) {
		boolean flag = false;
		String op;
		
		while(!flag) {
			op = JOptionPane.showInputDialog("Ingrese una opción: \n[1] List \n[2] Search \n[3] New \n[4] Delete \n[5] Update \n\n[0] Exit");
			
			if(op == null) break;
			
			switch (op) {
			case "1":
				drvr.listAll();
				break;
			case "2":
				drvr.getOne();
				break;
			case "3":
				//createProduct();
				break;
			case "4":
				//deleteProduct();
				break;
			case "5":
				//updateProduct();
				break;
			case "0":
				flag = true;
				break;
			default:
				JOptionPane.showMessageDialog(null, "Por favor, ingrese una opción válida");
				break;
			}
		}
	}

}
