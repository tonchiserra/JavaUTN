package ejercicio6a;

import java.util.LinkedList;

import javax.swing.JOptionPane;

import java.sql.*;

public class Main {

	public static void main(String[] args) {
		
		Driver drvr = new Driver();
		
		menu();
	}
	
	
	private static void listAll() {
		
		LinkedList<Product> products = new LinkedList<>();
		
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/javamarket", "root", "root");
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from product");
			
			while(rs.next()) {
				Product p = new Product();
				
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setPrice(rs.getDouble("price"));
				
				products.add(p);
			}
			
			if(rs != null) {rs.close();}
			if(stmt != null) {rs.close();}
			
			conn.close();
			
			JOptionPane.showMessageDialog(null, products);
			//System.out.println(products);
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error message: " + ex.getMessage());
			//System.out.println( "Error message: " + ex.getMessage() );
		}
	}
	
	public static void getOne() {
	
		String id = JOptionPane.showInputDialog("Ingrese id: ");
				
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/javamarket", "root", "root");
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from product p where p.id = " + id);
			
			while(rs.next()) {
				Product p = new Product();
				
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setPrice(rs.getDouble("price"));
			
				JOptionPane.showMessageDialog(null, p);
			}
			
			if(rs != null) {rs.close();}
			if(stmt != null) {rs.close();}
			
			conn.close();

		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error message: " + ex.getMessage());
		}
			
	}
	
	public static void menu() {
		boolean flag = false;
		int op;
		
		while(!flag) {
			op = Integer.parseInt(JOptionPane.showInputDialog("Ingrese una opción: \n[1] List \n[2] Search \n[3] New \n[4] Delete \n[5] Update \n\n[0] Exit"));
			
			switch (op) {
			case 1:
				listAll();
				break;
			case 2:
				getOne();
				break;
			case 3:
				//createProduct();
				break;
			case 4:
				//deleteProduct();
				break;
			case 5:
				//updateProduct();
				break;
			case 0:
				flag = true;
				break;
			default:
				break;
			}
		}
	}

}
