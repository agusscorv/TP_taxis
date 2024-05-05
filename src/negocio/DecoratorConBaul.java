package negocio;

/**
 * Clase Extendida de Decorator de Baul que implementa IViaje y decorara un hijo de Viaje 
 */
public class DecoratorConBaul extends DecoratorBaul {

	public DecoratorConBaul(IViaje aEncapsular) {
		super(aEncapsular);
	}
	
	/**
	 * Calculo del costo extra por Pasajero en base al costoBase, que dependera de su especificacion Baul
	 * 
	 * Post: Devuelve el costo extra especificado
	 */
	@Override
	public double getIncPasajeros() {
		return getCostoBase()*0.1*getCantPasajeros();
	}
	
	/**
	 * Calculo del costo extra por Kilometro en base al costoBase, que dependera de su especificacion Baul
	 * 
	 * Post: Devuelve el costo extra especificado
	 */
	@Override
	public double getIncKilometros() {
		return getCostoBase()*0.05*getDistancia();
	}

}
