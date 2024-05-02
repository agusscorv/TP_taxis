package negocio;

public class ViajeFactory {

	public IViaje getViaje(Pedido pedido, Chofer chofer, Vehiculo vehiculo)
		throws FaltaDeChoferException, FaltaDeVehiculoException, ZonaInexistenteException{
		
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