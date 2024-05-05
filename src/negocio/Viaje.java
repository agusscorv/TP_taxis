package negocio;

public abstract class Viaje implements IViaje, Cloneable, Comparable {
	private String estado, zona;
	private Cliente cliente;
	private Vehiculo vehiculo;
	private Chofer chofer;
	private double costo, distancia;
	private int cantPasajeros;
	private boolean mascota, baul;
	private static float costoBase= 1000;
	private Empresa empresa = Empresa.obtenerInstancia(); //pq va a ser singleton
	
	public int compareTo(Object obj) {
		int rta = -1;
		Viaje viaje = (Viaje) obj;
	
		if (this.getCosto() <= viaje.getCosto())
			rta = 1;
		else
			rta = 0;
		
		return rta;
	}
	
	public Viaje(Pedido pedido)throws FaltaDeChoferException, FaltaDeVehiculoException {
		
		this.cliente= pedido.getCliente();
		this.costo= costoBase; 
		//this.distancia= cliente.getDistanciaViaje(); //el cliente tiene un ATRIBUTO q es la distancia
		this.cantPasajeros= pedido.getCantPasajeros();
		this.zona= pedido.getZona();
		this.mascota= pedido.isMascota();
		this.baul= pedido.isBaul();
		this.estado="Solicidato";
		
		this.vehiculo= empresa.seleccionaMejorVehiculo(pedido); //throws FaltaDeVehiculoException
		this.estado="Con Vehiculo";
		
		this.chofer= empresa.seleccionaChofer(pedido); //throws FaltaDeChoferException
		this.estado="Iniciado";
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
	
	public void Pagado() {
		estado="Pagado";
		//en un futuro aca se podria poner que tanto el Chofer como su Vehiculo vuelven al ArrayList, y estan listos para otro pedido
		estado="Finalizado";
	}
	
	protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
		
}	

