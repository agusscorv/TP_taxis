package negocio;

public class ViajeFactory {

	
	/**Este método es el encargado de fabricar un objeto de tipo Viaje con todas sus especificaciones de Zona, Mascota y Baul. A traves de Decorators (o propaga excepcion)
	 * pre: pedido != null
	 * post: devuelve un objeto de tipo IViaje con sus correspondientes decorators
	 * 
	 * @param pedido = formulario del pedido en base al cual se creara el viaje
	 * 
	 * @throws ZonaInexistenteException = se lanza en caso de que la zona del pedido no sea una zona existente en el sistema
	 */
	public IViaje getViaje(Pedido pedido)throws FaltaDeChoferException, FaltaDeVehiculoException, ZonaInexistenteException{	
		
		IViaje rta=null; 
		IViaje encapsulado=null; 
		IViaje decoratorM=null;
		
		if (pedido.getZona().equalsIgnoreCase("Zona Peligrosa")) {
			encapsulado= new ZonaPeligrosa(pedido); //throws FaltaDeChoferException & FaltaDeVehiculoException 
		}
		else if(pedido.getZona().equalsIgnoreCase("Zona Estandar")) {
			encapsulado= new ZonaEstandar(pedido);
		}
		else if(pedido.getZona().equalsIgnoreCase("Calle Tierra")) {
			encapsulado= new CalleTierra(pedido);
		}
		
		if (encapsulado!=null) {
			if(pedido.isMascota())
				decoratorM= new DecoratorConMascota(encapsulado);
			else
				decoratorM= new DecoratorSinMascota(encapsulado);
			
			if(pedido.isBaul())
				rta= new DecoratorConBaul(decoratorM);
			else
				rta= new DecoratorSinBaul(decoratorM);
		}
		else
			throw new ZonaInexistenteException();
		return rta;
	}	
}