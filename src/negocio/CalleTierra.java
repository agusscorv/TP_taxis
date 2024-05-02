package negocio;

public class CalleTierra extends Viaje {

	public CalleTierra(Pedido pedido)throws FaltaDeChoferException, FaltaDeVehiculoException {
		super(pedido);
	}


	@Override
	public double getIncPasajeros() {
		return getCostoBase()*0.2*getCantPasajeros();
	}

	@Override
	public double getIncKilometros() {
		return getCostoBase()*0.15*getDistancia();
	}

}
