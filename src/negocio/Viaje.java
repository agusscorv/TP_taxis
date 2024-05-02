package negocio;

public abstract class Viaje implements IViaje, Cloneable {
	private String estado, zona;
	private Cliente cliente;
	private Vehiculo vehiculo;
	private Chofer chofer;
	private double costo, distancia;
	private int cantPasajeros;
	private boolean mascota, baul;
	private static float costoBase= 1000;
	
	public Viaje(Pedido pedido)throws FaltaDeChoferException, FaltaDeVehiculoException {
		
		this.cliente= pedido.getCliente();
		this.costo= costoBase; ///EL COSTO BASE SE PODRA MODIFICAR DICE, COMO?
		//this.distancia= cliente.getDistanciaViaje(); //el cliente tiene un ATRIBUTO q es la distancia
		this.cantPasajeros= pedido.getCantPasajeros();
		this.zona= pedido.getZona();
		this.mascota= pedido.isMascota();
		this.baul= pedido.isBaul();
		
		
		this.vehiculo= Empresa.seleccionaMejorVehiculo(pedido); //throws FaltaDeVehiculoException
		
		
		this.chofer= Empresa.seleccionaChofer(pedido); //throws FaltaDeChoferException
		
		if (this.vehiculo!= null && this.chofer!=null)
			this.estado="Solicitado";
	}

	public static void setCostoBase(float costoBase) {
		Viaje.costoBase = costoBase;
	}
	
	public String getEstado() {
		return estado;
	}

	public String getZona() {
		return zona;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public Chofer getChofer() {
		return chofer;
	}

	public boolean isMascota() {
		return mascota;
	}

	public boolean isBaul() {
		return baul;
	}
	
	@Override
	public double getCostoBase() {
		return costoBase;
	}

	@Override
	public int getCantPasajeros() {
		return cantPasajeros;
	}

	@Override
	public double getDistancia() {
		return distancia;
	}

	@Override
	public double getCosto() { 
		return costo + getIncKilometros() + getIncPasajeros();
	}

	protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
	
}
