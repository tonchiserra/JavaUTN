package ejercicio5b;

public class Vendedor extends Empleado {
	
	private double porcenComision;
	private double totalVentas;
	
	public void setPorcenComision(String porcenComision) {
		if(porcenComision != null) {
			this.porcenComision = Double.parseDouble(porcenComision);
		}
	}
	
	public void setTotalVentas(String totalVentas) {
		if(totalVentas != null) {
			this.totalVentas = Double.parseDouble(totalVentas);
		}
	}
	
	@Override
	public double getSueldo() {
		double sueldoTotal = (super.getSueldo() + (porcenComision * totalVentas / 100));
		
		return sueldoTotal;
	}
}
