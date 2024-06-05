package negocio;

import java.util.GregorianCalendar;

public interface IViaje {
	
	public void setCondicion(String condicion); //NUEVO
	
	public String getEstado();
	
	public int getCantPasajeros();
	
	public double getDistancia();
	
	public GregorianCalendar getFecha();
	
	/**
	 * Calculo del costo extra por Pasajero en base al costoBase, que dependera de sus especificaciones Zona, Mascota o Baul
	 * 
	 * @return Devuelve el costo extra especificado
	 */
	public double getIncPasajeros();
	
	/**
	 * Calculo del costo extra por Kilometro en base al costoBase, que dependera de sus especificaciones Zona, Mascota o Baul
	 * 
	 * @return Devuelve el costo extra especificado
	 */
	public double getIncKilometros();
	
	public double getCostoBase();
	
	/**
	 * Calculo del costo final del viaje, que dependera de sus respectivos incrementos
	 * 
	 * @return Devuelve el costo final teniendo en cuenta getIncKilometros() y getIncPasajeros() 
	 */
	public double getCosto();
	
	public Cliente getCliente();
	
	public Vehiculo getVehiculo();
	
	public Chofer getChofer();
	
	public int compareTo(Object obj);
	
	public void Pagado();
	
	public Object clone() throws CloneNotSupportedException;

	public void setChofer(Chofer chofer);
	
	
}
