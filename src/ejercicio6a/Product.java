package ejercicio6a;

public class Product {
	int id;
	String name;
	String description;
	double price;
	int stock;
	boolean shippingIncluded;
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public void setShippingIncluded(boolean shippingIncluded) {
		this.shippingIncluded = shippingIncluded;
	}
	
	@Override
	public String toString() {
		return "\n Producto [Id: " + id +", Nombre: " + name + ", Precio: " + price + "]";
	}
}
