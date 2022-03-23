package ejercicio5a;

public class Empleado {
	
	private String dni;
	private String nombre;
	private String apellido;
	private String email;
	private int sueldoBase;
	
	public void setDni(String dni) {
		if(dni != null) {
			this.dni = dni;
		}
	}
	
	public void setNombre(String nombre) {
		if(nombre != null) {
			this.nombre = nombre;
		}
	}
	
	public void setApellido(String apellido) {
		if(apellido != null) {
			this.apellido = apellido;
		}
	}
	
	public void setEmail(String email) {
		if(email != null) {
			this.email = email;
		}
	}
	
	public void setSueldoBase(String sueldoBase) {
		if(sueldoBase != null) {
			this.sueldoBase = Integer.parseInt(sueldoBase);
		}
	}
	
	public String getDni() {
		return this.dni;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getApellido() {
		return this.apellido;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public double getSueldo() {
		return this.sueldoBase;
	}
	
}
