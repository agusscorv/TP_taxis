package negocio;

/**
 * Clase Extendida de Decorator de Baul que implementa IViaje y decorara un hijo de Viaje 
 */
public class DecoratorSinBaul extends DecoratorBaul {

	public DecoratorSinBaul(IViaje aEncapsular) {
		super(aEncapsular);
	}
	
	/**
	 * Calculo del costo extra por Pasajero en base al costoBase, que dependera de su especificacion Baul
	 * 
	 * Post: Devuelve el costo extra especificado
	 */
	@Override
	public double getIncPasajeros() {
		return 0;
	}
	
	/**
	 * Calculo del costo extra por Kilometro en base al costoBase, que dependera de su especificacion Baul
	 * 
	 * Post: Devuelve el costo extra especificado
	 */
	@Override
	public double getIncKilometros() {
		return 0;
	}
	
	

}
