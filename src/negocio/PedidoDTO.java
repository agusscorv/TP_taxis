package negocio;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class PedidoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private String zona;
	private boolean mascota, baul;
	private int cantPasajeros;
	private double distancia;
	private GregorianCalendar fecha;
	private ClienteDTO cliente;


	public PedidoDTO() {
    // TODO Auto-generated constructor stub
	}

	public String getZona() {
		return zona;
	}
    public void setZona(String zona){
        this.zona = zona;
    }    
	public boolean isMascota() {
		return mascota;
	}
    public void setMascota(boolean mascota){
        this.mascota = mascota;
    }
    public void setBaul(boolean baul){
        this.baul = baul;
    }
	public boolean isBaul() {
		return baul;
	}
    public void setPasajeros(int pasajeros){
        this.cantPasajeros = pasajeros;
    }
	public int getCantPasajeros() {
		return cantPasajeros;
	}
    public void setCliente(ClienteDTO cliente){
        this.cliente = cliente;
    }
	public ClienteDTO getCliente() {
		return cliente;
	}
    public void setDistancia(double distancia){
        this.distancia = distancia;
    }
	public double getDistancia() {
		return distancia;
	}
    public void setFecha(GregorianCalendar fecha){
        this.fecha = fecha;
    }
	public GregorianCalendar getFecha() {
		return fecha;
	}

	public String getUserCliente() {
		return this.cliente.getUser();

	}



}
