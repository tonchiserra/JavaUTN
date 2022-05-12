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
				JOptionPane.showMessageDialog(null, drvr.listAll());
				break;
			case "2":
				JOptionPane.showMessageDialog(null, drvr.getOne(Integer.parseInt(JOptionPane.showInputDialog("Ingrese id: "))));
				break;
			case "3":
				Product newProduct = new Product();
				newProduct.setName(JOptionPane.showInputDialog("Ingrese nombre del producto a ingresar:"));
				newProduct.setDescription(JOptionPane.showInputDialog("Ingrese descripción del producto:"));
				newProduct.setPrice(Double.parseDouble(JOptionPane.showInputDialog("Ingrese precio del producto:")));
				newProduct.setStock(Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad de stock:")));
				newProduct.setShippingIncluded(JOptionPane.showInputDialog("Ingrese 0 si el producto no incluye envio") != "0" ? true : false);
				JOptionPane.showMessageDialog(null, drvr.createProduct(newProduct));
				break;
			case "4":
				JOptionPane.showMessageDialog(null, drvr.deleteProduct(Integer.parseInt(JOptionPane.showInputDialog("Ingrese id del producto que deseas eliminar:"))));
				break;
			case "5":
				String updateOp;
				boolean updateFlag = false;
				int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese id del producto que desea modificar: "));
				while(!updateFlag) {
					updateOp = JOptionPane.showInputDialog(null, "Tu producto es:\n\n" + drvr.getOne(id) + "\n\n¿Qué quieres modificar? \n[1] Nombre \n[2] Descripción \n[3] Precio \n[4] Stock \n[5] Envío \n[0] Salir ");
					if(updateOp == null) break;
					switch (updateOp) {
					case "1":
						JOptionPane.showMessageDialog(null, drvr.updateNameProduct(id, JOptionPane.showInputDialog("Ingrese nuevo nombre:")));
						break;
					case "2":
						JOptionPane.showMessageDialog(null, drvr.updateDescriptionProduct(id, JOptionPane.showInputDialog("Ingrese nueva descripción:")));
						break;
					case "3":
						JOptionPane.showMessageDialog(null, drvr.updatePriceProduct(id, Double.parseDouble(JOptionPane.showInputDialog("Ingrese nuevo precio:"))));
						break;
					case "4":
						JOptionPane.showMessageDialog(null, drvr.updateStockProduct(id, Integer.parseInt(JOptionPane.showInputDialog("Ingrese nuevo stock:"))));
						break;
					case "5":
						JOptionPane.showMessageDialog(null, drvr.updateShippingIncludedProduct(id, JOptionPane.showInputDialog("Ingrese 0 si el producto no incluye envio") != "0" ? true : false));
						break;
					case "0":
						updateFlag = true;
						break;
					default:
						JOptionPane.showMessageDialog(null, "Por favor, ingrese una opción válida");
						break;
					}
					
				}
				
				//JOptionPane.showConfirmDialog(null, drvr.updateProduct());
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
