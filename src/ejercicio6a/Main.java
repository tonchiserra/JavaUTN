package ejercicio6a;

import java.util.LinkedList;

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
		LinkedList<Product> products = new LinkedList<>();
		
		while(!flag) {
			op = JOptionPane.showInputDialog("Ingrese una opción: \n[1] List \n[2] Search \n[3] New \n[4] Delete \n[5] Update \n\n[0] Exit");
			
			if(op == null) break;
			
			switch (op) {
			case "1":
				JOptionPane.showMessageDialog(null, drvr.listAll());
				break;
				
			case "2":
				products = drvr.getOne(Integer.parseInt(JOptionPane.showInputDialog("Ingrese id: ")));
				if(products.size() == 0) {
					JOptionPane.showMessageDialog(null, "No se ha encontrado ningún producto con ese id");
				}else {
					for (Product p : products) {
						 JOptionPane.showMessageDialog(null, "Id: " + p.getId() + "\nNombre: " + p.getName() + "\nDescripción: " + p.getDescription() + "\nPrecio: " + p.getPrice() + "\nStock: " + p.getStock() + "\nIncluye envío: " + (p.getShippingIncluded() ? "Si" : "No"));
					}
				}
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
				Product updatedProduct = new Product();
				
				products = drvr.getOne(Integer.parseInt(JOptionPane.showInputDialog("Ingrese id del producto que desea modificar: ")));
				if(products.size() == 0) {
					JOptionPane.showMessageDialog(null, "No se ha encontrado ningún producto con ese id");
				}else {
					for (Product p : products) {
						updatedProduct.setId(p.getId());
						updatedProduct.setName(p.getName());
						updatedProduct.setDescription(p.getDescription());
						updatedProduct.setPrice(p.getPrice());
						updatedProduct.setStock(p.getStock());
						updatedProduct.setShippingIncluded(p.getShippingIncluded());
					}
				}
				
				while(!updateFlag) {
					updateOp = JOptionPane.showInputDialog(null, "Tu producto es:\n\n" + updatedProduct.toString() + "\n\n¿Qué quieres modificar? \n[1] Nombre \n[2] Descripción \n[3] Precio \n[4] Stock \n[5] Envío \n[0] Aceptar ");
					
					if(updateOp == null) break;
					
					switch (updateOp) {
					case "1":
						updatedProduct.setName(JOptionPane.showInputDialog("Ingrese nuevo nombre:"));
						break;
						
					case "2":
						updatedProduct.setDescription(JOptionPane.showInputDialog("Ingrese nueva descripción:"));
						break;
						
					case "3":
						updatedProduct.setPrice(Double.parseDouble(JOptionPane.showInputDialog("Ingrese nuevo precio:")));
						break;
						
					case "4":
						updatedProduct.setStock(Integer.parseInt(JOptionPane.showInputDialog("Ingrese nuevo stock:")));
						break;
						
					case "5":
						updatedProduct.setShippingIncluded(JOptionPane.showInputDialog("Ingrese 0 si el producto no incluye envio") != "0" ? true : false);
						break;
						
					case "0":
						updateFlag = true;
						break;
						
					default:
						JOptionPane.showMessageDialog(null, "Por favor, ingrese una opción válida");
						break;
					}
					
				}
				
				JOptionPane.showMessageDialog(null, drvr.updateProduct(updatedProduct));
				
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