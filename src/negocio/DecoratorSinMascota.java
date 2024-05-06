package negocio;

/**
 * Clase Extendida de Decorator de Mascota que implementa IViaje y decorara un hijo de Viaje 
 */
public class DecoratorSinMascota extends DecoratorMascota {

	public DecoratorSinMascota(IViaje aEncapsular) {
		super(aEncapsular);
	}

	/**
	 * Calculo del costo extra por Pasajero en base al costoBase, que dependera de su especificacion Mascota
	 * 
	 * Post: Devuelve el costo extra especificado
	 */
	@Override
	public double getIncPasajeros() {
		return 0;
	}
	
	/**
	 * Calculo del costo extra por Kilometro en base al costoBase, que dependera de su especificacion Mascota
	 * 
	 * Post: Devuelve el costo extra especificado
	 */
	@Override
	public double getIncKilometros() {
		return 0;
	}
	
	public void setEncapsulado(IViaje aEncapsular) {
		this.encapsulado= aEncapsular;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		DecoratorSinMascota aux= (DecoratorSinMascota) super.clone();
		aux.setEncapsulado( (IViaje) this.encapsulado.clone() ); 
		return aux;
	}

}
