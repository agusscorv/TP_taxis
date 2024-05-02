package negocio;

public class ZonaEstandar extends Viaje {

	public ZonaEstandar(Pedido pedido)throws FaltaDeChoferException, FaltaDeVehiculoException {
		super(pedido);
	}


	@Override
	public double getIncPasajeros() {
		return getCostoBase()*0.1*getCantPasajeros();
	}

	@Override
	public double getIncKilometros() {
		return getCostoBase()*0.1*getDistancia();
	}

}
