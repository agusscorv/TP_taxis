package negocio;

public abstract class Pedido {
	String fechaYHora, zona;
	boolean mascota, baul;
	int cantPasajeros;
	Cliente cliente;
	
	public Pedido() {
		
	}

	public String getFechaYHora() {
		return fechaYHora;
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
	
	
	
}
