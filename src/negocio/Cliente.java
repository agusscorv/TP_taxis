package negocio;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Cliente {
	private String user;
	private String contrasena;
	private String nombre;
	private ArrayList<Viaje> viajes;
	private Empresa empresa = Empresa.obtenerInstancia();
	
	public Cliente(String user, String contrasena, String nombre) {
		this.user= user;
		this.contrasena = contrasena;
		this.nombre = nombre;
		this.viajes = new ArrayList<>();
	}
	
	public void hacePedido(double distancia, GregorianCalendar fecha, String zona, boolean mascotas, boolean baul, int cantPasajeros, Cliente cliente) 
			throws FaltaDeChoferException, FaltaDeVehiculoException, ZonaInexistenteException{
		
		empresa.solicitaViaje(distancia, fecha, zona, mascotas, baul, cantPasajeros, cliente);
	}
	
	public String getUser() {
		return user;
	}

	public String getContrasena() {
		return contrasena;
	}

	public String getNombre() {
		return nombre;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	
}