package negocio;

/**
 * Clase Zona Peligrosa que extiende de viaje, para luego ser decorada 
 */
public class ZonaPeligrosa extends Viaje {

	/**
	 * Constructor de Zona Peligrosa, recibe un pedido y llama a super
	 * 
	 * Pre: pedido!=null
	 * Post: Se crea e inicia un nuevo viaje o propaga excepcion
	 * 
	 * @param pedido: es el formulado del pedido en el que se basa la solicitacion del viaje 
	 */
	public ZonaPeligrosa(Pedido pedido)throws FaltaDeChoferException, FaltaDeVehiculoException {
		super(pedido);
	}

	/**
	 * Calculo del costo extra por Pasajero en base al costoBase, que dependera de sus especificacion Zona
	 * 
	 * Post: Devuelve el costo extra especificado
	 */
	@Override
	public double getIncPasajeros() {
		return getCostoBase()*0.1*getCantPasajeros();
	}

	/**
	 * Calculo del costo extra por Kilometro en base al costoBase, que dependera de sus especificaciones Zona
	 * 
	 * Post: Devuelve el costo extra especificado
	 */
	@Override
	public double getIncKilometros() {
		return getCostoBase()*0.2*getDistancia();
	}

}
