package negocio;

import java.util.GregorianCalendar;

/**
 * Clase Decorator de Baul que implementa IViaje y decorara un hijo de Viaje 
 */
public abstract class DecoratorBaul implements IViaje {
	IViaje encapsulado;

	/**
	 * Constructor del Decorator que recibe un encapsulado a decorar
	 * 
	 * Pre: aEncapsular!=null
	 * Post: Se decora el encapsulado en cuestion
	 * 
	 * @param aEncapsular: IViaje a ser decorado dependiendo sus parametros 
	 */
	public DecoratorBaul(IViaje aEncapsular) {
		encapsulado= aEncapsular;
	}

	@Override
	public int getCantPasajeros() {
		return encapsulado.getCantPasajeros();
	}

	@Override
	public double getDistancia() {
		return encapsulado.getDistancia();
	}
	
	@Override
	public GregorianCalendar getFecha() {
		return encapsulado.getFecha();
	}
	
	@Override
	public double getCostoBase() {
		return encapsulado.getCostoBase();
	}

	/**
	 * Calculo del costo final del viaje, que dependera de sus respectivos incrementos, y los de su encapsulado
	 * 
	 * Post: Devuelve el costo final teniendo en cuenta getIncKilometros() y getIncPasajeros() 
	 */
	@Override
	public double getCosto() {// getIncKilometros() y getIncPasajeros() no estan implementados en esta capa aun, pero lo seran en sus decorator hijos :)
		return encapsulado.getCosto() + getIncKilometros() + getIncPasajeros();
	}
}
