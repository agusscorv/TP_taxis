package negocio;

import java.util.GregorianCalendar;

public class PedidoDTO {
	private String zona;
	private boolean mascota, baul;
	private int cantPasajeros;
	private double distancia;
	private GregorianCalendar fecha;
	private Cliente cliente;
	private String condicionPedido;
	
	
	public PedidoDTO() {
    // TODO Auto-generated constructor stub
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

	public double getDistancia() {
		return distancia;
	}

	public GregorianCalendar getFecha() {
		return fecha;
	}
	
	public String getUserCliente() {
		return this.cliente.getUser();
		
	}
	
	
	
}
