package negocio;


public class VehiculoFactory {

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
