package negocio;

public class Pedido {
	private String zona;
	private boolean mascota, baul;
	private int cantPasajeros, hora;
	private long fecha;
	private Cliente cliente;
	
	public Pedido(long fecha, int hora, String zona, boolean mascotas, boolean baul, int cantPasajeros, Cliente cliente) {
		this.fecha=fecha;
		this.hora= hora;
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

	public long getFecha() {
		return fecha;
	}
	
	public int getHora() {
		return hora;
	}
	
}
