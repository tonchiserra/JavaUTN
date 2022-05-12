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
	
	public String createProduct(Product newProduct) {
		try {
			this.createConnection();
			PreparedStatement pstmt = conn.prepareStatement("insert into product (name, description, price, stock, shippingIncluded) values (?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, newProduct.name);
			pstmt.setString(2, newProduct.description);
			pstmt.setDouble(3, newProduct.price);
			pstmt.setInt(4, newProduct.stock);
			pstmt.setBoolean(5, newProduct.shippingIncluded);
			
			pstmt.executeUpdate();
			
			ResultSet keyRS = pstmt.getGeneratedKeys();
			
			this.message = "";
			while(keyRS != null && keyRS.next()) {
				int id = keyRS.getInt(1);
				
				this.message = message + "Tu producto: \nId: " + id + "\nNombre: " + newProduct.name + "\nSe agregó exitosamente!";
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
	
	
	public String deleteProduct(int id) {
		try {
			this.createConnection();
			PreparedStatement pstmt = conn.prepareStatement("delete from product where id=?");
			pstmt.setInt(1, id);
			
			pstmt.executeUpdate();
			
			this.message = "El producto numero " + id + " fue eliminado correctamente";
			
			if(pstmt != null) {pstmt.close();}
			conn.close();
		}
		catch(SQLException ex) {
			this.message = "Error: " + ex.getMessage();
		}
		
		return message;
	}
	
	public String updateNameProduct(int id, String newName) {
		try {
			this.createConnection();
			PreparedStatement pstmt = conn.prepareStatement("update product set name = ? where id = ?");
			pstmt.setString(1, newName);
			pstmt.setInt(2, id);
			
			pstmt.executeUpdate();
			
			this.message = "El producto fue modificado correctamente";
			
			if(pstmt != null) {pstmt.close();}
			conn.close();
		}
		catch(SQLException ex) {
			this.message = "Error: " + ex.getMessage();
		}
		
		return message;
	}
	
	public String updateDescriptionProduct(int id, String newDescription) {
		try {
			this.createConnection();
			PreparedStatement pstmt = conn.prepareStatement("update product set description = ? where id = ?");
			pstmt.setString(1, newDescription);
			pstmt.setInt(2, id);
			
			pstmt.executeUpdate();
			
			this.message = "El producto fue modificado correctamente";
			
			if(pstmt != null) {pstmt.close();}
			conn.close();
		}
		catch(SQLException ex) {
			this.message = "Error: " + ex.getMessage();
		}
		
		return message;
	}
	
	public String updatePriceProduct(int id, double newPrice) {
		try {
			this.createConnection();
			PreparedStatement pstmt = conn.prepareStatement("update product set price = ? where id = ?");
			pstmt.setDouble(1, newPrice);
			pstmt.setInt(2, id);
			
			pstmt.executeUpdate();
			
			this.message = "El producto fue modificado correctamente";
			
			if(pstmt != null) {pstmt.close();}
			conn.close();
		}
		catch(SQLException ex) {
			this.message = "Error: " + ex.getMessage();
		}
		
		return message;
	}
	
	public String updateStockProduct(int id, int newStock) {
		try {
			this.createConnection();
			PreparedStatement pstmt = conn.prepareStatement("update product set stock = ? where id = ?");
			pstmt.setInt(1, newStock);
			pstmt.setInt(2, id);
			
			pstmt.executeUpdate();
			
			this.message = "El producto fue modificado correctamente";
			
			if(pstmt != null) {pstmt.close();}
			conn.close();
		}
		catch(SQLException ex) {
			this.message = "Error: " + ex.getMessage();
		}
		
		return message;
	}
	
	public String updateShippingIncludedProduct(int id, boolean newShippingIncluded) {
		try {
			this.createConnection();
			PreparedStatement pstmt = conn.prepareStatement("update product set shippingIncluded = ? where id = ?");
			pstmt.setBoolean(1, newShippingIncluded);
			pstmt.setInt(2, id);
			
			pstmt.executeUpdate();
			
			this.message = "El producto fue modificado correctamente";
			
			if(pstmt != null) {pstmt.close();}
			conn.close();
		}
		catch(SQLException ex) {
			this.message = "Error: " + ex.getMessage();
		}
		
		return message;
	}
}
