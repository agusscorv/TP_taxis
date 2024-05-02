package negocio;

public class DecoratorConBaul extends DecoratorBaul {

	public DecoratorConBaul(IViaje aEncapsular) {
		super(aEncapsular);
	}
	
	@Override
	public double getIncPasajeros() {
		return getCostoBase()*0.1*getCantPasajeros();
	}
	@Override
	public double getIncKilometros() {
		return getCostoBase()*0.05*getDistancia();
	}

}
