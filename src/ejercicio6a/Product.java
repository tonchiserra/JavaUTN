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
	
	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public Double getPrice() {
		return this.price;
	}
	
	public int getStock() {
		return this.stock;
	}
	
	public boolean getShippingIncluded() {
		return this.shippingIncluded;
	}
}
