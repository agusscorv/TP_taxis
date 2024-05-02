package negocio;

import java.util.ArrayList;

public class Cliente {
	private String user;
	private String contrasena;
	private String nombre;
	private ArrayList<Viaje> viajes;
	

	public String getUser() {
		return user;
	}

	public String getContrasena() {
		return contrasena;
	}

	public String getNombre() {
		return nombre;
	}

	public Cliente(String user, String contrasena, String nombre) {
		this.user= user;
		this.contrasena = contrasena;
		this.nombre = nombre;
		this.viajes = new ArrayList<>();
	}

	//Falta que no se pueda repetir nombre de usuario. no se como hacerlo, si en el constructor o como
	
	//PAGAR VIAJE como seria? tiene dinero?
	
	
	//CALIFICAR CHOFER
	
	public void getViajesPropios(Cliente cliente) { //falta algortimo en empresa o en prueba que lo busque 
		for (int i = 0; i < viajes.size(); i++){
				//escribir el viaje??
			
		}
	}
	
	
}