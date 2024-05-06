package negocio;

import java.util.GregorianCalendar;

/**
 * Clase abstract Viaje, de la que extenderan las Zonas y seran decoradas. 
 */
public abstract class Viaje implements IViaje, Cloneable, Comparable {
	private String estado;
	private Vehiculo vehiculo;
	private Pedido pedido;
	private Chofer chofer;
	private double costo;
	private static float costoBase= 1000;
	private Empresa empresa = Empresa.obtenerInstancia(); //pq va a ser singleton
	
	/**
	 * Constructor de Viaje, recibe un pedido y lo procesa
	 * 
	 * Pre: pedido!=null
	 * Post: Se crea e inicia un nuevo viaje o propaga excepcion
	 * 
	 * @param pedido: es el formulado del pedido en el que se basa la solicitacion del viaje 
	 */
	public Viaje(Pedido pedido)throws FaltaDeChoferException, FaltaDeVehiculoException {
		
		this.pedido= pedido;
		this.costo= costoBase; 
		this.estado="Solicidato";
		
		this.vehiculo= empresa.seleccionaMejorVehiculo(pedido); //throws FaltaDeVehiculoException
		this.estado="Con Vehiculo";
		
		this.chofer= empresa.seleccionaChofer(pedido); //throws FaltaDeChoferException
		this.estado="Iniciado";
	}
	
	/**
	 * Compara los costos del objeto actual de viaje con el que se manda como parametro 
	 * 
	 * Pre: obj =! null && obj tipo Viaje
	 * Post: Se crea e inicia un nuevo viaje o propaga excepcion
	 * 
	 * @param pedido: es el formulario del pedido en el que se basa la solicitacion del viaje 
	 */
	public int compareTo(Object obj) {
		int rta = -1;
		IViaje viaje = (IViaje) obj;
		
		if (this.getCosto() <= viaje.getCosto())
			rta = 1;
		else
			rta = 0;
		
		return rta;
	}

	public static void setCostoBase(float costoBase) {
		Viaje.costoBase = costoBase;
	}
	
	public String getEstado() {
		return estado;
	}

	public String getZona() {
		return pedido.getZona();
	}

	public double getDistancia() {
		return pedido.getDistancia();
	}

	public Cliente getCliente() {
		return pedido.getCliente();
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public Chofer getChofer() {
		return chofer;
	}

	public boolean isMascota() {
		return pedido.isMascota();
	}

	public boolean isBaul() {
		return pedido.isBaul();
	}
	
	@Override
	public double getCostoBase() {
		return costoBase;
	}

	@Override
	public int getCantPasajeros() {
		return pedido.getCantPasajeros();
	}

	/**
	 * Calculo del costo final del viaje, que dependera de sus respectivos incrementos
	 * 
	 * Post: Devuelve el costo final teniendo en cuenta getIncKilometros() y getIncPasajeros() 
	 */
	@Override
	public double getCosto() { 
		return costo + getIncKilometros() + getIncPasajeros();
	}
	
	@Override
	public GregorianCalendar getFecha() {
		return pedido.getFecha();
	}
	
	
	/** Continua el recorrido del pedido, luego haber sido iniciado
	 * pre: el objeto viaje que lo efectua tiene estado iniciado
	 * post: actualiza el estado del viaje
	 */
	public void Pagado() {
		estado="Pagado";
		//en un futuro aca se podria poner que tanto el Chofer como su Vehiculo vuelven al ArrayList, y estan listos para otro pedido
		estado="Finalizado";
	}

	public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
		
}	

