package negocio;

import java.util.GregorianCalendar;

public interface IViaje {
	
	public int getCantPasajeros();
	
	public double getDistancia();
	
	public GregorianCalendar getFecha();
	
	public double getIncPasajeros();
	
	public double getIncKilometros();
	
	public double getCostoBase();
	
	public double getCosto();
}
