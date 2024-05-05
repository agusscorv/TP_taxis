package negocio;

import java.util.GregorianCalendar;

public class Pedido {
	private String zona;
	private boolean mascota, baul;
	private int cantPasajeros;
	private GregorianCalendar fecha;
	private Cliente cliente;
	
	public Pedido(GregorianCalendar fecha, String zona, boolean mascotas, boolean baul, int cantPasajeros, Cliente cliente) {
		this.fecha=fecha;
		this.zona= zona;
		this.mascota= mascotas;
		this.baul= baul;
		this.cantPasajeros = cantPasajeros;
		this.cliente = cliente;
	}

	public String getZona() {
		return zona;
	}

	public boolean isMascota() {
		return mascota;
	}

	public boolean isBaul() {
		return baul;
	}

	public int getCantPasajeros() {
		return cantPasajeros;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public GregorianCalendar getFecha() {
		return fecha;
	}
	
	
	
}
