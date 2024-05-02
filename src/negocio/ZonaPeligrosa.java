package negocio;

public class ZonaPeligrosa extends Viaje {

	public ZonaPeligrosa(Pedido pedido)throws FaltaDeChoferException, FaltaDeVehiculoException {
		super(pedido);
	}


	@Override
	public double getIncPasajeros() {
		return getCostoBase()*0.1*getCantPasajeros();
	}

	@Override
	public double getIncKilometros() {
		return getCostoBase()*0.2*getDistancia();
	}

}
