package negocio;

/**
 * Clase Extendida de Decorator de Mascota que implementa IViaje y decorara un hijo de Viaje 
 */
public class DecoratorConMascota extends DecoratorMascota {

	public DecoratorConMascota(IViaje aEncapsular) {
		super(aEncapsular);
	}
	
	/**
	 * Calculo del costo extra por Pasajero en base al costoBase, que dependera de su especificacion Mascota
	 * 
	 * Post: Devuelve el costo extra especificado
	 */
	@Override
	public double getIncPasajeros() {
		return getCostoBase()*0.1*getCantPasajeros();
	}
	
	/**
	 * Calculo del costo extra por Kilometro en base al costoBase, que dependera de su especificacion Mascota
	 * 
	 * Post: Devuelve el costo extra especificado
	 */
	@Override
	public double getIncKilometros() {
		return getCostoBase()*0.2*getDistancia();
	}

}
