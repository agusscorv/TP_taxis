package negocio;

/**
 * Clase correspondiente al patron factory que se encarga de la creacion de un tipo de vehiculo necesario para brindar el servicio de viaje.
 */
public class VehiculoFactory {

	/**Este método es el encargado de fabricar un objeto de tipo Vehiculo que es moto, combi o auto.
	 * pre: tipo!=null, tipo!="",patente!=null,patente!=""
	 * post: devuelve un objeto de tipo moto,auto o combi.
	 * @param tipo = tipo de vehiculo que se quiere crear
	 * @param patente = patente que hace de identificador de vehiculo
	 * @throws TipoVehiculoInexistenteException si el tipo de vehiculo no es ni moto, ni combi, ni auto, se dispara una excepcion indicando que el tipo de vehiculo ingresado es incorrecto
	 */
	public Vehiculo getVehiculo(String tipo, String patente) throws TipoVehiculoInexistenteException {
		Vehiculo respuesta = null;
		if (tipo.equalsIgnoreCase("Moto")) 
			respuesta = new Moto(patente);
		else 
			if (tipo.equalsIgnoreCase("Auto")) 
				respuesta = new Auto(patente);
		    else 
			  if (tipo.equalsIgnoreCase("Combi")) 
				  respuesta = new Combi(patente);
			  else
				  throw new TipoVehiculoInexistenteException();
		return respuesta;
	}	
}
