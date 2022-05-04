package ejercicio6a;

import java.sql.*;
import java.util.LinkedList;
import javax.swing.JOptionPane;

public class Driver {
	
	LinkedList<Product> products = new LinkedList<>();
	String message;
	Connection conn = null;

	public Driver() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		}catch(InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	private void createConnection() {
		products.clear();
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/javamarket", "root", "root");	
		}
		catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());	
		}
		
	}
	
	
	public String listAll() {
		
		try {
			this.createConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from product");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Product p = new Product();
				
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setPrice(rs.getDouble("price"));
				
				this.products.add(p);
			}
			
			if(rs != null) {rs.close();}
			if(pstmt != null) {pstmt.close();}
			conn.close();
		}
		catch(SQLException ex) {
			this.message = "Error: " + ex.getMessage();
		}
		
		if(products.size() == 0) {
			this.message = "No se ha encontrado ningún producto.";
		}else {
			this.message = "";
			for (Product p : products) {
				this.message = message + "Id: " + p.getId() + ", Nombre: " + p.getName() + ", Precio: " + p.getPrice() + "\n";
			}
		}
		
		return message;
	}
	
	
	public String getOne(int id) {
		
		try {
			this.createConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from product where id=?");
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Product p = new Product();
				
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setDescription(rs.getString("description"));
				p.setPrice(rs.getDouble("price"));
				p.setStock(rs.getInt("stock"));
				p.setShippingIncluded(rs.getBoolean("shippingIncluded"));
				
				this.products.add(p);
			}
			
			if(rs != null) {rs.close();}
			if(pstmt != null) {pstmt.close();}
			
			conn.close();
		}
		catch(SQLException ex) {
			this.message = "Error: " + ex.getMessage();
		}
	
		if(products.size() == 0) {
			this.message = "No se ha encontrado ningún producto con ese id";
		}else {
			for (Product p : products) {
				this.message = "Id: " + p.getId() + "\nNombre: " + p.getName() + "\nDescripción: " + p.getDescription() + "\nPrecio: " + p.getPrice() + "\nStock: " + p.getStock() + "\nIncluye envío: " + (p.getShippingIncluded() ? "Si" : "No");
			}
		}
		
		return message;
	}
	
	public String createProduct(String newName, String newDescription, double newPrice, int newStock, boolean newShippingIncluded) {
		try {
			this.createConnection();
			PreparedStatement pstmt = conn.prepareStatement("insert into product (name, description, price, stock, shippingIncluded) values (?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, newName);
			pstmt.setString(2, newDescription);
			pstmt.setDouble(3, newPrice);
			pstmt.setInt(4, newStock);
			pstmt.setBoolean(5, newShippingIncluded);
			
			pstmt.executeUpdate();
			
			ResultSet keyRS = pstmt.getGeneratedKeys();
			
			this.message = "";
			while(keyRS != null && keyRS.next()) {
				int id = keyRS.getInt(1);
				String name = keyRS.getString(2);
				
				//Error al mostrar el mensaje.
				
				this.message = message + "Tu producto: \nId: " + id + "\nNombre: " + name + "\nSe agregó exitosamente!";
			}
			
			if(keyRS != null) {keyRS.close();}
			if(pstmt != null) {pstmt.close();}
			conn.close();
		}
		catch(SQLException ex) {
			this.message = "Error: " + ex.getMessage();
		}
		
		return message;
	}
	
}
