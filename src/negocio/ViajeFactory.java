package negocio;

public class ViajeFactory {

	public IViaje getViaje(Pedido pedido, Chofer chofer, Vehiculo vehiculo) {
		
		
		
		
		IViaje rta=null; IViaje encapsulado=null; IViaje decoratorM=null;
		if (pedido.getZona.equalsIgnoreCase("Zona Peligrosa"))
			encapsulado= new DecoratorZonaPeligrosa(pedido);
		else if(/*chequea otras zonas*/) {
	
		}
		
		if (encapsulado!=null) {
			if(pedido.isMascota(pedido))
				decoratorM= new DecoratorConMascota(encapsulado);
			else
				decoratorM= new DecoratorSinMascota(encapsulado);
			if(/*chequea decorator baul*/) {
				
			}
		}
	}	
}