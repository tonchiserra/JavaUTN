package ejercicio6a;

import java.sql.*;
import java.util.LinkedList;
import javax.swing.JOptionPane;

public class Driver {
	
	LinkedList<Product> products = new LinkedList<>();
	String message;

	public Driver() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			
			//Pregunta, por que me sale una alerta en el newInstance?
			
		}catch(InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	
		//Pregunta, este try catch debe ir aca o en otra clase?
	}
	
	
	private void createConnection(String query) {
		Connection conn = null;
		
		this.products.clear();
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/javamarket", "root", "root");
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				Product p = new Product();
				
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setDescription(rs.getString("description"));
				p.setPrice(rs.getDouble("price"));
				p.setStock(rs.getInt("stock"));
				p.setShippingIncluded(rs.getBoolean("shippingIncluded"));
				
				products.add(p);
			}
			
			if(rs != null) {rs.close();}
			if(stmt != null) {rs.close();}
			
			conn.close();
		}
		catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}
	}
	
	
	public void listAll() {
		this.createConnection("select * from product");
		
		//JOptionPane.showMessageDialog(null, products);
		
		this.message = "";
		for (Product p : products) {
			this.message = message + "Id: " + p.getId() + ", Nombre: " + p.getName() + ", Precio: " + p.getPrice() + "\n";
		}
		JOptionPane.showMessageDialog(null, message);
	}
	
	
	public void getOne() {
		String id = JOptionPane.showInputDialog("Ingrese id: ");
		
		this.createConnection("select * from product p where p.id = " + id);			
	
		//JOptionPane.showMessageDialog(null, products);
	
		this.message = "";
		if(products.isEmpty()) {
			this.message = "No se ha encontrado ningún producto con ese id";
		}else {
			for (Product p : products) {
				this.message = message + "Id: " + p.getId() + "\nNombre: " + p.getName() + "\nDescripción: " + p.getDescription() + "\nPrecio: " + p.getPrice() + "\nStock: " + p.getStock() + "\nIncluye envío: " + (p.getShippingIncluded() ? "Si" : "No");
			}
		}
		JOptionPane.showMessageDialog(null, message);
	}
	
}
