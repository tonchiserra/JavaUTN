package ejercicio5b;

public class Administrativo extends Empleado {
	
	private int hsExtra;
	private int hsMes;
	
	public void setHsExtra(String hsExtra) {
		if(hsExtra != null) {
			this.hsExtra = Integer.parseInt(hsExtra);
		}
	}
	
	public void setHsMes(String hsMes) {
		if(hsMes != null) {
			this.hsMes = Integer.parseInt(hsMes);
		}
	}
	
	@Override
	public double getSueldo() {
		double sueldoTotal = (super.getSueldo() * ((hsExtra * 1.5) + hsMes) / hsMes);
		
		return sueldoTotal;
	}
}
