package ejercicio5b;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		ArrayList<Empleado> losEmpleados = new ArrayList<>();
		
		Scanner reader = new Scanner(System.in);
		
		boolean bandera = false;
		int i = 0;
		
		while (!bandera) {
			i++;
			System.out.println("Agregar empleado n° " + i);
			System.out.println("Ingresar [a] si es administrativo o [v] si es vendedor:");
			
			if(reader.next().equalsIgnoreCase("a")) {
				Administrativo unEmpleado = new Administrativo();
				System.out.println("Seleccionaste administrativo");
				
				System.out.println("");
				System.out.println("Ingrese dni:");
				unEmpleado.setDni(reader.next());
				System.out.println("Ingrese nombre:");
				unEmpleado.setNombre(reader.next());
				System.out.println("Ingrese apellido:");
				unEmpleado.setApellido(reader.next());
				System.out.println("Ingrese email:");
				unEmpleado.setEmail(reader.next());
				System.out.println("Ingrese sueldo base:");
				unEmpleado.setSueldoBase(reader.next());
				System.out.println("Ingrese horas extra:");
				unEmpleado.setHsExtra(reader.next());
				System.out.println("Ingrese horas mes:");
				unEmpleado.setHsMes(reader.next());
				
				losEmpleados.add(unEmpleado);
				
			}else {
				Vendedor unEmpleado = new Vendedor();
				System.out.println("Seleccionaste vendedor");
				
				System.out.println("");
				System.out.println("Ingrese dni:");
				unEmpleado.setDni(reader.next());
				System.out.println("Ingrese nombre:");
				unEmpleado.setNombre(reader.next());
				System.out.println("Ingrese apellido:");
				unEmpleado.setApellido(reader.next());
				System.out.println("Ingrese email:");
				unEmpleado.setEmail(reader.next());
				System.out.println("Ingrese sueldo base:");
				unEmpleado.setSueldoBase(reader.next());
				System.out.println("Ingrese porcentaje de comision:");
				unEmpleado.setPorcenComision(reader.next());
				System.out.println("Ingrese total ventas:");
				unEmpleado.setTotalVentas(reader.next());
				
				losEmpleados.add(unEmpleado);
			}
			
			System.out.println("¿Quieres agregar un nuevo empleado? [s/n]");
			if(reader.next().equalsIgnoreCase("n")) {
				bandera = true;
			}else {
				if(i >= 20) {
					bandera = true;
				}
			}
			
		}
		
		System.out.println(" ");
		System.out.println("Los empleados ingresados son: ");
		for (Empleado unEmpleado : losEmpleados) {
			System.out.println("DNI: " + unEmpleado.getDni() + " Nombre y apellido: " + unEmpleado.getNombre() + " " + unEmpleado.getApellido() + " Sueldo: " + unEmpleado.getSueldo() );
		}
		
		reader.close();
	}

}
