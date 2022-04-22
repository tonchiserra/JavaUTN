package ejercicio6a;

public class Driver {

	public Driver() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			
			//Pregunta, por que me sale una alerta en el newInstance?
			
		}catch(InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	
		//Pregunta, este try catch debe ir aca o en otra clase?
	}
	
}
